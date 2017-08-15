package io.IOStream.objectInputOutputStream;

import java.io.*;

/**
 * Created by Ежище on 05.02.2017.
 */
public class ObjectIOS {
    File file;
    String path;
    ObjectIOS(String path) {this.path = path;}
    public <T> T serialize(T obj) {
        file = new File(path + "\\" + obj.hashCode() + ".txt");
        T deserialized = null;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            oos.writeObject(obj);
            deserialized = (T) ois.readObject();
//            System.out.println(deserialized.hashCode());
//            System.out.println(obj.equals(deserialized));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return deserialized;
    }

    public static void main(String[] args) {
        ObjectIOS objectIOS = new ObjectIOS("src\\main\\java\\io\\IOStream\\objectInputOutputStream");
        Serial test = new Serial(100, "testS");
//        objectIOS.file = new File(objectIOS.path + "\\" + test.hashCode());
        Serial deserialized = objectIOS.serialize(test);
        test.printSerial("test");
        deserialized.printSerial("deserialized");
        Serial newOne = objectIOS.serialize(deserialized);
        newOne.printSerial("newOne");
    }
}
