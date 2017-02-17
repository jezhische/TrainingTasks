package io.IOStream;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by WORK_x64 on 16.02.2017.
 */
public class SequenceIOStream {
    static Vector<InputStream> vector;
    static Enumeration<InputStream> enumer;

    static File file2 = new File("src\\main\\java\\io\\IOStream\\IOTest2");

    public static void toDo(String text) {
        vector = new Vector<InputStream>();
        enumer = vector.elements();
        /* NB: если создаем  FileWriter с конструктором без append или append = false, то файл каждый раз будет
        * перезаписываться заново. Информация в файле СТИРАЕТСЯ ПРИ СОЗДАНИИ FileWriter!!! **/
        try(FileWriter file2Writer = new FileWriter("src\\main\\java\\io\\IOStream\\IOTest2", false);
        BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream("src\\main\\java\\io" +
                "\\IOStream\\IOTest"));
            BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream("src\\main\\java\\io" +
                    "\\IOStream\\IOTest2"));) {

            file2.createNewFile();
            file2Writer.write(text);
//            file2Writer.flush(); // TODO: NB!!! без flush запись не завершается, и прочесть ничего невозможно!
//            file2Writer.close(); // либо же нужно закрыть поток, тогда flush происходит автоматически.
            FileInputStream fis2 = new FileInputStream("src\\main\\java\\io" +
                    "\\IOStream\\IOTest2");
//            while (fis2.available() != 0)
//                System.out.print((char) fis2.read());


            vector.add(new StringBufferInputStream("Beginning of the IOTest:_________ "));
            vector.add(bis1);
            vector.add(new ByteArrayInputStream(("__________End of the IOTest2\n_____border_____\nBeginning of the " +
                    "IOTest2:_________ ").getBytes()));
            vector.add(bis2);
            vector.add(new ByteArrayInputStream(("__________End of the IOTest2\n And one more time with " +
                    "FileInputStream:\n").getBytes()));
            vector.add(fis2);

            SequenceInputStream sqis = new SequenceInputStream(enumer);
            int c = -1;
            while ((c = sqis.read()) != -1)
                System.out.print((char) c);

            System.out.println("\nAnd now with FileReader:\n");
            FileReader fir2 = new FileReader("src\\main\\java\\io\\IOStream\\IOTest2");
            c = fir2.read();
            while (c != -1) {
                System.out.print((char) c);
                c = fir2.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        toDo("сюда запишем что-нибудь по-русски\n");
    }
}
