package garbage.trash.trashtrash;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Ежище on 17.12.2016.
 */
public class Calc2 {
    Double result = 0.0;
    LinkedList dataList = new LinkedList<>();
    private double calcTwoValues(LinkedList resultList) {
        switch ((String)resultList.get(1)) {
            case "+":

                break;
            case "-":

                break;
            case "*":

                break;
            case "/":

                break;
        }
        return result;
    }
    public void calc() {
//        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine().trim();
            String[] splitLine = line.split("\\ ");
            if (line.equals("")) {
                System.out.println("Exit");
                System.exit(0);
            } else if (splitLine.length%2 == 0) {
                System.out.println("Wrong input");
                System.exit(0);
            } else {
                try {
                    System.out.println(Double.parseDouble(splitLine[0]));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }


//                switch (splitLine[1]) {
//                    case "+":
//                        System.out.println((double) Double.valueOf(splitLine[0]) + (double) Double.valueOf(splitLine[2]));
//                        break;
//                    case "-":
//                        System.out.println((double) Double.valueOf(splitLine[0]) - (double) Double.valueOf(splitLine[2]));
//                        break;
//                    case "*":
//                        System.out.println((double)Double.valueOf(splitLine[0]) * (double)Double.valueOf(splitLine[2]));
//                        break;
//                    case "/":
//                        System.out.println((double)Double.valueOf(splitLine[0]) / (double)Double.valueOf(splitLine[2]));
//                        break;
//                }
            }
        }
    }

    public static void main(String[] args) {
        new Calc2().calc();
    }
}
