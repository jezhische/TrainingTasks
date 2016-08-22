package fileClass;

import java.io.File;

/**
 * Created by Ежище on 22.08.2016.
 */
public class AbsolutePath {
    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\Probe4.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.lastModified());
        System.out.println("isDirectory = " + file.isDirectory());
//        file.renameTo(new File("src\\main\\resources\\testSupport\\Probe5.txt")); //работает, файл переносится
    }
}
