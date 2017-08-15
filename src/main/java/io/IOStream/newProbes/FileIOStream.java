package io.IOStream.newProbes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ежище on 09.08.2017.
 */
public class FileIOStream {
    public static void main(String[] args) {
        ArrayList<String> listToReading = new ArrayList<>(Arrays.asList("ghgfh", "jhjhjh", "qw1rerety"));
        char [] toWriting = new char[50];
        String fileName = "src\\main\\java\\io\\IOStream\\newProbes\\writedReaded.txt";

        try(FileInputStream input = new FileInputStream(fileName);
            FileOutputStream output = new FileOutputStream(fileName)) {
//            listToReading.spliterator()
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
