package io.IOStream.newProbes.IOReaderWriter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintStream;

public class FileRecursiveSearchMyProbe {
    public static void search(File file, FileFilter filter, PrintStream output) throws IOException {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++)
                search(list[i], filter, output);
        } else if (filter.accept(file)) {
            output.println(file.getPath());
        }
    }

    public static void main(String[] args) {
        try {
            search(new File("."), (someFile -> someFile.getName().contains(".bin")),
                    System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
