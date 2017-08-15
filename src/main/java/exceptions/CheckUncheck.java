package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by WORK on 21.02.2017.
 */
public class CheckUncheck {
    /* проверка, будет ли выполняться программа дальше, если брошен отслеженный checked exception и отслеженный
      * unchecked exception **/
    static int doThenCalc(int x) {
        FileReader file = null;
        try {
            file = new FileReader("C:\\test\\a.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException is thrown");;
        }

        int a = 10;
        try{
            a = 1 / x;
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }

        int b = 5;
        return a * b;
    }
    public static void main(String[] args) {
        System.out.println(doThenCalc(0));
        System.out.println(doThenCalc(1));
    }
}
