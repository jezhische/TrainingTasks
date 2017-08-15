package io.IOStream;

import java.io.*;

/**
 * Created by Ежище on 07.02.2017.
 */
public class FileWriterSimply {
    /* если файла нет, он создается - и из file, и по имени **/
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\java\\io\\IOStream\\1.txt");
//        file.createNewFile(); // можно создать файл и так
        System.out.println(file.exists());
        System.out.println(file.getName());
        FileWriter fw = new FileWriter(file, false);
        System.out.println(file.exists());
        fw.write("hello", 0, 4);
        fw.write("\nno, hello!".toCharArray());
        fw.flush(); // TODO: NB: без опорожнения буфера запись не производится!
        FileReader fr = new FileReader(file);
//        fr.mark(5);
        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }
//        fr.reset();
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }

        fw = new FileWriter("src\\main\\java\\io\\IOStream\\2.txt", false);
        fr = new FileReader("src\\main\\java\\io\\IOStream\\2.txt");
        fw.write("\nku\noh, ku!");
        fw.flush();
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }

    }
}
