package scanners;

import java.util.Scanner;

/**
 * Created by WORK on 24.08.2016.
 */
public class ConsoleScannerProbe {
    Scanner scan = new Scanner(System.in);
    StringBuilder builder = new StringBuilder();
    String consoleContent = builder.toString();

    public void readConsole(String message) {
        System.out.println(message); // что-то не читает оно уже отпечатанное. потому что это не поток уже.
        consoleContent = scan.next();
        System.out.println(consoleContent);
    }

    public static void main(String[] args) {
        ConsoleScannerProbe cs = new ConsoleScannerProbe();
        cs.readConsole("dfdgf");
    }
}
