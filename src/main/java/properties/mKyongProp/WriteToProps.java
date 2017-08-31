package properties.mKyongProp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/** https://www.mkyong.com/java/java-properties-file-examples/ */
public class WriteToProps {
    public static void main(String[] args) {

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            // чтобы в дальнейшем прочесть файл с помощью classLoader, нужно поместить его в classPath root folder:
            output = new FileOutputStream("src\\main\\resources\\configProbe.properties");

            // set the properties value
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "mkyong");
            prop.setProperty("dbpassword", "password");

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
