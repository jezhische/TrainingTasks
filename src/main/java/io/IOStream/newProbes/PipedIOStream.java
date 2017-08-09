package io.IOStream.newProbes;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by WORK_x64 on 09.08.2017.
 */
public class PipedIOStream {
    private int counterRead;
    private byte[] toRead = new byte[100];

    public void writeArray () {
        try(PipedInputStream input = new PipedInputStream(); PipedOutputStream output = new PipedOutputStream(input) ) {

            while (counterRead < toRead.length) {
                for (int i = 0; i < (Math.random() * 10); i++) {
                    output.write((byte)(Math.random() * 127));
                }
                int willRead = input.available();
                if (willRead + counterRead > toRead.length)
                    willRead = toRead.length - counterRead;
                counterRead += input.read(toRead, counterRead, willRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printArray(byte[] b) {

        for (int i = 0; i < b.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(b[i] + "; ");
        }
    }

    public byte[] getToRead() {
        return toRead;
    }

    public static void main(String[] args) {
        PipedIOStream pios = new PipedIOStream();

        pios.writeArray();
        pios.printArray(pios.getToRead());
    }

}
