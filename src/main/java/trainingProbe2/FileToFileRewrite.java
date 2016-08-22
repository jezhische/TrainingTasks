package trainingProbe2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ежище on 20.08.2016.
 */
public class FileToFileRewrite {
    public void rewrite() {
        try(FileInputStream fis = new FileInputStream("src\\main\\resources\\Probe4.txt"); FileOutputStream fos =
        new FileOutputStream("src\\main\\resources\\testSupport\\output.txt", false)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
//            while(fis.read() != -1) {
//                fos.write(fis.read()); // а если я пишу вот так, то что с циклом, что без - получается какая-то хрень
//            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileToFileRewrite ftfr = new FileToFileRewrite();
        ftfr.rewrite();
    }
}
