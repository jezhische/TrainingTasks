package io.zipIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Ежище on 19.02.2017.
 */
public class ZipIn { //fixme: что-то пока ничего не вышло...
    public static void main(String[] args) {
        String filename = "src\\main\\java\\io\\zipIOStream\\11.txt",
                filename2 = "src\\main\\java\\io\\zipIOStream\\12.txt";
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream( "src\\main\\java\\io\\" +
                "zipIOStream\\output.zip")); FileOutputStream fos = new FileOutputStream(filename)) {
            ZipEntry entry;
            while((entry = zis.getNextEntry()) != null) {
                System.out.println("name: " + entry.getName() + ", modified: " + entry.getLastModifiedTime());
                fos.write(entry.getExtra());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
