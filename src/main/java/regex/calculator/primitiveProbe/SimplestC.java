package regex.calculator.primitiveProbe;

import java.io.Console;
import java.util.Scanner;

public class SimplestC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = null;
        double first = 0;
        double second = 0;

        while (true) {
            System.out.println("Print expression");
            line = in.nextLine().split(" ");
            if (line[0].equalsIgnoreCase("esc")) System.exit(0);
            if (line.length != 3) System.out.println("Wrong input");
            else {
                try {
                    first = Double.valueOf(line[0]);
                    second = Double.valueOf(line[2]);
                    switch (line[1]) {
                        case "+":
                            System.out.println(" = " + (first + second));
                            break;
                        case "-":
                            System.out.println(" = " + (first - second));
                            break;
                        case "*":
                            System.out.println(" = " + (first * second));
                            break;
                        case "/":
                            System.out.println(" = " + (first / second));
                            break;
                        default:
                            System.out.println("Wrong input: wrong statement");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input: " + e.getMessage());
                }
            }
        }

    }
}
