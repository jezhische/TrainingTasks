package io.IOStream.newProbes.serialization;

import java.io.*;

public class ObjectIOStream {
    public void writeObject(ForTest test, String filename) {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOut.writeObject(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ForTest readObject(String filename) {
        ForTest test = null;
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filename))) {
            test = (ForTest) objectIn.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return test;
    }
}

//class Test implements Serializable {
//    private int r = 25, q;
//    private String string;
//
//    public Integer ret(Integer i) {
//        return i * 10;
//    }
//
//    public int exceptionCheck(String notNull) {
//        try {
//            return 1 / Integer.valueOf(notNull) + 1;
//        } catch (NumberFormatException | ArithmeticException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getClass().getSimpleName());
//
//        } /*catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        }*/
//        return 0;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Test that = (Test) obj;
//        if (r != that.r) return false;
//        if (string != null ? !string.equals(that.string) : that.string != null) return false;
//        return q == that.q;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = r;
//        result = 31 * result + q;
//        result = 31 * result + (string != null? string.hashCode() : 0);
//        return result;
//    }
//}

class Main {
    public static void main(String[] args) {
        ForTest test = new ForTest(9);
        ObjectIOStream io = new ObjectIOStream();
        String filename = "src\\main\\java\\io\\IOStream\\newProbes\\serialization\\dataFiles\\readTest.bin";
        io.writeObject(test, filename);
        ForTest newTest = io.readObject(filename);
        System.out.println(test.ret(5) + ", " + newTest.ret(5));
        System.out.println(test.equals(newTest));
        System.out.println((Object) test.equals((Object) newTest)); // благодаря отложенному выполнению, java определит
        // класс этого объекта как ForTest
        System.out.println((Object) test.equals(newTest)); // и даже так
        System.out.println(newTest.getClass());
        System.out.println((Object) newTest.getClass()); // в обоих случаях определяется Test, а не Object
        System.out.println(test.hashCode());
        System.out.println(newTest.hashCode());
        ForTest compare = new ForTest(9);
        System.out.println(compare.hashCode()); // если hashCode() не будет переопределен, результаты будут разными


        System.out.println(test.exceptionCheck("5"));
        System.out.println(test.exceptionCheck("si"));
        System.out.println(test.exceptionCheck(""));
        System.out.println(test.exceptionCheck(null));
        System.out.println(test.exceptionCheck("0"));

    }
}
