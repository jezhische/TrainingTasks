package io.IOStream.newProbes.IOReaderWriter;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderWriter {

    private String data = "Some data to be written and read.\n";

    public void writeFile(String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        for (int i = (int)(Math.random() * 10); --i >= 0 ;) {
            bufferedWriter.write(data);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void readFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
//        CharBuffer charBuffer = CharBuffer.allocate(9000);
//        charBuffer.append("row: 1, read: ");
//        int count = 0, i = 0;
//        while ((i = bufferedReader.read(charBuffer)) != -1) {
//            if ((char) i == '\n')
//                charBuffer.put(((char) i + "row: " + ++count + ", read: ").toCharArray());
//            charBuffer.append(
//                    (char) i);
//        }
//        bufferedReader.close();
//        String result = String.valueOf(charBuffer.array());
//        System.out.println(result);

//        ____________________________________ это так, чепуха:
//        System.out.println(Stream.of(bufferedReader).count());
//        List<Integer> list = Arrays.asList(5, 8, 18, 25, 4);
//        System.out.println(list.getClass());
//        System.out.println(Stream.of(list).count());
//        Stream.of(list).forEach(System.out::print);
//        Stream.of(bufferedReader).forEach(System.out::print);
//        System.out.println("\n\n");
//        ________________________________________________


        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append("row: " + ++count + ", read: " + line + '\n');
        }
        bufferedReader.close();
        String result = stringBuilder.toString();
        System.out.println(result);
    }

    public static void main(String[] args) {
        FileReaderWriter frw = new FileReaderWriter();
        String fileName = "src\\main\\java\\io\\IOStream\\newProbes\\IOReaderWriter\\frw.bin";
        try {
            frw.writeFile(fileName);
            frw.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
