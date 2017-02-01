package garbage.trash.trashtrash;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 31.01.2017.
 */
public class Calc1 {
    public double first, second;
    private ArrayList<Double> operands;
    private String statement;

    public Calc1() {
        operands = new ArrayList<>(2);
        for (int i = 0; i < 2; i++)
            operands.add(0d);
    }

    private void scan() {
        Scanner lineInScanner = new Scanner(System.in);
        String data = null;
        if (lineInScanner.hasNextLine())
            data = lineInScanner.nextLine();

        Pattern operandsPattern = Pattern.compile("\\d+(\\.\\d+)?");
        assert data != null;
        Matcher operandsMatcher = operandsPattern.matcher(data);
        if (operandsMatcher.find()) // NB!!!!!!!! я сделал здесь if, а не while, так что как только матчер нашел
            // соответствие, дальше он не работает!!!!!!
            operands.set(0, Double.valueOf(operandsMatcher.group()));
//        Scanner operandsScanner = new Scanner(data);
//        if (operandsScanner.hasNext(operandsPattern))
//            operands.set(0, Double.valueOf(operandsScanner.next(operandsPattern)));



//        String data = null;
//        if (scanner.hasNext(pattern)) {
//            data = scanner.next(pattern);
//        }
//        Matcher
        System.out.println();
    }
    public double calculate() {

        return 0;
    }

    public static void main(String[] args) {
        Calc1 calc = new Calc1();
        calc.scan();

        for (double operand: calc.operands)
            System.out.println(operand);
        System.out.println("size = " + calc.operands.size());
    }

}
