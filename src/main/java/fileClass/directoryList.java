package fileClass;

import java.io.File;

/**
 * Created by Ежище on 22.08.2016.
 */
public class directoryList {
    public static void main(String[] args) {
        File dir = new File("src\\main\\java\\javaFromTkach");
        if (dir.isDirectory()) {
            for (File item: dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "\tdirectory");
                } else {
                    System.out.println(item.getName() + "\tfile");
                }
            }
        }
    }
}
