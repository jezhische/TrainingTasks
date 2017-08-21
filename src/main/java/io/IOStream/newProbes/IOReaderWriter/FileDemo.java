/** http://www.intuit.ru/studies/courses/16/16/lecture/27133?page=4 */
package io.IOStream.newProbes.IOReaderWriter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintStream;

public class FileDemo {
    public static void findFiles(File file, FileFilter filter,
                                 PrintStream output) throws IOException {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (int i=list.length; --i>=0;) {
                findFiles(list[i], filter, output);
            }
        } else {
            if (filter.accept(file))
                output.println("\t" + file.getCanonicalPath());
        }
    }
    public static void main(String[] args) {
//        class NameFilter implements FileFilter {
//            private String mask;
//            NameFilter(String mask) {
//                this.mask = mask;
//            }
//            @Override
//            public boolean accept(File file){
//                return (file.getName().indexOf(mask)!=-1)?true:false;
//            }
//        }
//        File pathFile = new File(".");
//        String filterString = ".java";
//        try {
//            FileFilter filter = /*new NameFilter(filterString)*/ file -> file.getName().contains(filterString);
//            findFiles(pathFile, filter, System.out);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("work finished");

        try {
            findFiles(new File("."), (someFile -> someFile.getName().contains(".java")),
                    System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
