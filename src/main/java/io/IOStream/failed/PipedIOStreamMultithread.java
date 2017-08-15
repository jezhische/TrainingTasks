package io.IOStream.failed;

import java.io.*;

/**
 * Created by Ежище on 05.02.2017.
 */
public class PipedIOStreamMultithread {
    private String text;
    public byte[] data;
    byte[] dataPart;
    private PipedInputStream pipeIn;
    private PipedOutputStream pipeOut;
    private boolean ready;
    private static final Object monitor = new Object();

    public PipedIOStreamMultithread(String text) throws IOException {
        this.text = text;
        data = new byte[text.length()];
        pipeOut = new PipedOutputStream();
        pipeIn = new PipedInputStream(pipeOut);
        ready = true;
    }

    Runnable putBytes = () -> {
        putBytes();
    };
    Runnable getBytes = () -> {
        getBytes();
    };

    private void putBytes(){
        int filledCount = 0;

        try {
            synchronized (monitor) {
                while (ready && filledCount < text.length()) {
                    /* будем передавать текст по 3 символа, имитируя приход данных из интернета **/
                    if (filledCount + 3 > text.length()) {
                        dataPart = text.substring(filledCount, text.length() - filledCount).getBytes();
                    } else {
                        dataPart = text.substring(filledCount, filledCount + 3).getBytes();
                    }
                    pipeOut.write(dataPart);
//                    for (byte b : data)
//                        System.out.print(b);
                    if (filledCount + 3 > text.length())
                        Thread.currentThread().interrupt();
                    ready = false;
                    monitor.wait();
                }
//                Thread.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void getBytes(){
        int filledCount = 0;

        try {
            synchronized (monitor) {
                while (!ready && filledCount < text.length()) {
                    /* будем считывать текст по 3 символа, имитируя приход данных из интернета **/
                    if (filledCount + 3 > text.length()) {
                        pipeIn.read(data, filledCount, text.length() - filledCount);
                    } else {
                       pipeIn.read(data, filledCount, filledCount + 3);
                    }
                    for (byte b : data)
                        System.out.print((char) b);
                    if (filledCount + 3 > text.length())
                        Thread.currentThread().interrupt();
                    ready = true;
                    monitor.notify();
                }
//                Thread.sleep(100);
            }
//        } catch(InterruptedException e) {
//            System.out.println(e.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        PipedIOStreamMultithread piosm = new PipedIOStreamMultithread("something up");
        new Thread(piosm.putBytes).start();
        new Thread(piosm.getBytes).start();
//        for (byte b : piosm.data)
//            System.out.print((char) b);

    }
}
