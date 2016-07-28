package printlnInOutProbe.userInputSimulation;

import java.io.*;
import java.util.Scanner;

/**
 * Created by uaTex_32 on 28.07.2016.
 */
public  class IntegerAsker { // в оригинале было public static class IntegerAsker
    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }

    // дальше мое творчество:
    public static void main(String[] args) {
        ByteArrayInputStream bais = new ByteArrayInputStream("проба записи".getBytes());
        try (PrintStream ps = new PrintStream(new File("src\\main\\resources\\Probe4.txt"))) {
            IntegerAsker ia = new IntegerAsker(bais, ps);
            ia.ask("25");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
