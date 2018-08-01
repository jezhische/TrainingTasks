package io.recursiveSearch;

import java.io.File;
import java.io.FilenameFilter;

public class Search {

    public static final String FILE_DIR = "E:\\STORAGE";
    public static final String FILE_EXT = ".jpg";


    public void listFile(String folder, String extension) {
        File dir = new File(folder);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Directory doesn't exist");
            return;
        }

        GenericExtFilter filter = new GenericExtFilter(extension);


//        String[] searchResult = dir.list(filter);
//        for (String s : searchResult) {
//            System.out.println(s);
//        }


        File[] filelist = dir.listFiles();
        if (filelist != null) {
            for (int i = 0; i < filelist.length; i++) {
                if (filelist[i].isDirectory()) listFile(filelist[i].getPath(), extension);
                else if (filelist[i].getName().endsWith(extension))
                    System.out.println(indent(i) + filelist[i].getPath());
            }
        }


    }

    private String indent(int indentCount) {
        StringBuilder stringBuilder = new StringBuilder("   ");
        for (int i = 0; i < indentCount; i++) {
            stringBuilder.append("");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new Search().listFile(FILE_DIR, FILE_EXT);
    }



    public class GenericExtFilter implements FilenameFilter {

        private String ext;

        public GenericExtFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

}
