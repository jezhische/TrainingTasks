package io.IOStream.newProbes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ежище on 10.08.2017.
 */
public class SequensIStream {

    public void writeFile(String fileName, String text, boolean continued) {
        try(FileOutputStream output = new FileOutputStream(fileName, continued)) {
            byte outBytes[] = text.getBytes();
            output.write(outBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void combineFiles(String outputFileName, boolean continued, String... fileNames) {
        Vector<InputStream> vector = null;
        ArrayList<String> fileNameList = null;
        SequenceInputStream sequence = null;
        FileOutputStream output = null;
        int readed = 0;
        try {
            vector = new Vector<>();
            fileNameList = new ArrayList<>(Arrays.asList(fileNames));
            vector.add(new StringBufferInputStream(String.format("Files record started at %s\n",
                    new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z").format(new Date()))));
            for (int i = 0; i < fileNameList.size(); i++) {
                vector.add(new StringBufferInputStream( String.format("\nBegin of file %d at %s%s",
                        i + 1, new SimpleDateFormat("HH:mm:ss z").format(new Date()), "\n ")));
                vector.add(new FileInputStream(fileNameList.get(i)));
                vector.add(new StringBufferInputStream( String.format("\nEnd of file %d at %s%s",
                        i + 1, new SimpleDateFormat("HH:mm:ss z").format(new Date()), "\n ")));
            }
            vector.add(new ByteArrayInputStream((String.format("\nFiles record finished at %s\n",
                    new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z").format(new Date()))).getBytes()));

            Enumeration<InputStream> enumer = vector.elements();

            sequence = new SequenceInputStream(enumer);
            output = new FileOutputStream(outputFileName, continued);
            readed = sequence.read();

            while (readed != -1) {
                output.write(readed);
                readed = sequence.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                output.close();
                sequence.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SequensIStream instance = new SequensIStream();
        String outputFileName = "src\\main\\java\\io\\IOStream\\newProbes\\dataSource\\output.txt";
        String file1 = "src\\main\\java\\io\\IOStream\\newProbes\\dataSource\\file1.txt";
        String file2 = "src\\main\\java\\io\\IOStream\\newProbes\\dataSource\\file2.txt";
        String file3 = "src\\main\\java\\io\\IOStream\\newProbes\\dataSource\\file3.txt";
        String text1 = "vector.add(new StringBufferInputStream(String.format(\"Files record finished at %s\\n\",\n" +
                "                    new SimpleDateFormat(\"yyyy.MM.dd G 'at' HH:mm:ss z\").format(new Date()))));\n" +
                "\n" + "            Enumeration<InputStream> enumer = vector.elements();";
        String text2 = "        } catch (IOException e) {\n" +
                "            System.out.println(e.getMessage());\n" +
                "        }";
        String text3 = "И хватит.";

        instance.writeFile(file1, text1, false);
        instance.writeFile(file2, text2, false);
        instance.writeFile(file3, text3, false);
        instance.combineFiles(outputFileName, false, file1, file2, file3);
    }
}
