package printlnInOutProbe;

import java.io.*;

/**
 * Created by Ежище on 27.07.2016.
 */
public class PrintlnMethodProbe {
    public  static void print (File file) {
//        File file = new File("resources.Probe4.txt");
try(BufferedReader buf = new BufferedReader(new FileReader(file))) {
    System.setOut(new PrintStream(file)); //не работает
//    buf.out.println();
    System.out.println(buf); // не работает
    while (!buf.equals(null)) {
        String str = buf.readLine();
        PrintStream pStream = new PrintStream(str);
//        System.setOut(new PrintStream(str)); // не работает
        System.out.println(pStream); // не работает
    }
} catch (IOException e) {
    e.getCause();
}
    }

    public static void main(String[] args) {
        print(new File("resources.Probe4.txt"));
    }
}
