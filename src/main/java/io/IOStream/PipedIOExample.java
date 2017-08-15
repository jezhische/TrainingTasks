package io.IOStream;

/**
 * Created by Ежище on 05.02.2017.
 * http://www.intuit.ru/studies/courses/16/16/lecture/27133
 */
import java.io.*;
import java.util.Arrays;

public class PipedIOExample {
    public static void main(String[] args) {
        byte[] toRead = new byte[100];
        try {
            /* счетик заполненния массива-приемника **/
            int countRead = 0;
            PipedInputStream pipeIn = new PipedInputStream();
            PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);

            // Считывать в массив, пока он полностью не будет заполнен
            while(countRead<toRead.length) {

                // Записать в поток некоторое количество байт
                for(int i=0; i<(Math.random()*10); i++) {
                    pipeOut.write((byte)(Math.random()*127));
                }

                // Считать из потока доступные данные, добавить их к уже считанным.
                int willRead = pipeIn.available();
                if(willRead+countRead>toRead.length)

                    //Нужно считать только до предела массива
                    willRead = toRead.length-countRead;
                countRead += pipeIn.read(toRead, countRead, willRead);
            }
        } catch (IOException e) {
            System.out.println ("Impossible IOException occur: ");
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(toRead));
    }
}
