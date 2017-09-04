package static__.newS;

import javax.net.ssl.SSLContext;
import java.io.*;

/**
 * Created by WORK_x64 on 04.09.2017.
 */
public class StaticSerial implements Serializable {
    public static String s = "s-value!";
    private static String conS;
    public String nons, conNons;

    public StaticSerial(String conSV, String conNons) {
        conS = conSV;
        this.conNons = conNons;
    }

    @Override
    public String toString() {
        return String.format("s = %s, conS = %s, nons = %s, conNons = %s\n", s, conS, nons, conNons);
    }

    public void serial(String filename, StaticSerial staticSerial) {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(staticSerial);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StaticSerial deserial(String filename) {
        StaticSerial deserialized = null;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
            deserialized = (StaticSerial) input.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserialized;
    }

    public static void main(String[] args) {
        // УПС! Статики вполне возвращаются из сериализации
        StaticSerial original = new StaticSerial("conSV", "conNons");
        original.serial("src\\main\\java\\static__\\newS\\staticSerial.bin", original);
        StaticSerial restored = original.deserial("src\\main\\java\\static__\\newS\\staticSerial.bin");
        System.out.println(original);
        System.out.println(restored);
        // И так тоже:
        conS = "newValue";
        original.conNons = "newConNons";
        original.serial("src\\main\\java\\static__\\newS\\staticSerial.bin", original);
        restored = original.deserial("src\\main\\java\\static__\\newS\\staticSerial.bin");
        System.out.println(original);
        System.out.println(restored);
    }
}
