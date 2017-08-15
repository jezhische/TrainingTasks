package fileClass;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ежище on 22.08.2016.
 */
public class CreateCheckFile {
    //NOTE: первый блок - проверка существующего файла - выполняется всегда. Второй болк - создание директории,
    // создание нового файла - только тогда, когда они создаются заново. Если они уже существуют, ВЕСЬ блок
    // не будет выполнен, поскольку не выполняются условия if(created).
    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\IMG_20150927_091607.jpg");
        if (file.exists()) {
            System.out.println("file exists");
            if (file.isFile()) {
                System.out.println("file name is " + file.getName());
                System.out.println("parent directory is " + file.getParent());
                System.out.println("file absolute path is " + file.getAbsolutePath());
                System.out.println("file length is " + file.length());
                if (file.canRead()) {
                    System.out.println("file is readable");
                } else {
                    System.out.println("file is not readable");
                }
                if (file.canWrite()) {
                    System.out.println("file is writable");
                } else {
                    System.out.println("file is not writable");
                }
            } else {
                System.out.println("file is not found");
            }
        } else {
            System.out.println("file is not found or doesn't exist");
        }

        File newDir = new File("src\\main\\resources\\newDir");
        boolean dirIsCreated = newDir.mkdir();
        if (dirIsCreated) {
            System.out.println("new directory is created");
            System.out.println("new directory name is " + newDir.getName());
        }
        File newFile = new File("src\\main\\resources\\newDir\\IMG_0.jpg");
        try {
            boolean fileIsCreated = newFile.createNewFile();
            if (fileIsCreated) {
                System.out.println("\nfile was created");
                if (file.isFile()) {
                    System.out.println("file name is " + newFile.getName());
                    System.out.println("parent directory is " + newFile.getParent());
                    System.out.println("file absolute path is " + newFile.getAbsolutePath());
                    System.out.println("file length is " + newFile.length());
                    if (newFile.canRead()) {
                        System.out.println("file is readable");
                    } else {
                        System.out.println("file is not readable");
                    }
                    if (newFile.canWrite()) {
                        System.out.println("file is writable");
                    } else {
                        System.out.println("file is not writable");
                    }
                } else {
                    System.out.println("file is not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
