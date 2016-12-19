package garbage;

import java.util.Scanner;

/**
 * Created by Ежище on 17.12.2016.
 */
public class Calc {
    public void calc() {
//        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (true) {
            String[] line = scan.nextLine().split("\\ ");
            if (line.length%2 == 0) {
                System.out.println("Wrong input");
                System.exit(1);
            } else if (line.length == 0) {
                System.out.println("Exit");
                System.exit(1);
            } else {
                switch (line[1]) {
                    case "+":
                        System.out.println((double) Double.valueOf(line[0]) + (double) Double.valueOf(line[2]));
                        break;
                    case "-":
                        System.out.println((double) Double.valueOf(line[0]) - (double) Double.valueOf(line[2]));
                        break;
                    case "*":
                        System.out.println((double)Double.valueOf(line[0]) * (double)Double.valueOf(line[2]));
                        break;
                    case "/":
                        System.out.println((double)Double.valueOf(line[0]) / (double)Double.valueOf(line[2]));
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Calc().calc();
    }
}
