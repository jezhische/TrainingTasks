package properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemProperties {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        prop.list(System.out);

//        prop.setProperty("user.dir", "D:\\Ёжж\\прогграммирование\\мои примеры\\aaa");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src\\main\\java\\properties\\propTextData\\systemProperties.xml");
            prop.storeToXML(fos, "comments");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
