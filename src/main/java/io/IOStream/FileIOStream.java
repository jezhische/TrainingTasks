package io.IOStream;

import java.io.*;
/**
 * Created by Ежище on 05.02.2017.
 */
public class FileIOStream { //TODO: файл должен быть заранее создан. И он будет полностью переписываться.
    private FileInputStream fis;
    private FileOutputStream fos;
    public void getAndReadFile() {
        try{
            String path = "src//main//java//io//IOStream//IOTest";
            fis = new FileInputStream(path);
            fos = new FileOutputStream(path);
            String text = "something to write\nto the file.";
            fos.write((text + "\n" + text.substring(0, 18)).getBytes());
            fos.flush();

            /* просто вывести на печать **/
            int b;
            while((b = fis.read()) != -1)
                System.out.print((char)b);
            /* TODO после того, как один раз поток прочитан, то и в случае try-with-resources, и с обычным try
            * он закрывается и уже не работает, и нужно либо открывать новый, либо - что проще - воспользоваться
            * обычным try и просто создавать его же заново, как я и сделал **/

            /* запишем в массив байт **/
            fis = new FileInputStream(path);
            byte[] bytesFromFile = new byte[fis.available()];
            fis.read(bytesFromFile, 0, fis.available());
            System.out.println("\n");
            for (byte bt: bytesFromFile)
                System.out.print((char)bt);

            /* запишем в массив int **/
            fis = new FileInputStream(path);
            int av = fis.available(); // (если ниже 2 раза использовать выражение fis.available(), то читает почему-то
            // только половину файла, так что приходится вводить еще одну переменную).
            int[] intFromFile = new int[av];
            for (int i = 0; i < av; i++)
                intFromFile[i] = fis.read();
            System.out.println("\n");
            for (int it : intFromFile)
                System.out.print((char) it);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        FileIOStream fios = new FileIOStream();
        fios.getAndReadFile();
    }
}
