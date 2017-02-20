package io.zipIOStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Ежище on 19.02.2017.
 * http://www.javenue.info/post/35
 */
public class ZipUtil {
    public static void main(String[] args) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("src\\main\\java\\io\\zipIOStream\\" +
                "archive.zip"));
        File file = new File("src\\main\\java\\io\\zipIOStream");
        doZip(file, out);
        out.close();
    }

    private static void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getName())); // было: f.getPath()
                write(new FileInputStream(f), out);
            }
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
}
