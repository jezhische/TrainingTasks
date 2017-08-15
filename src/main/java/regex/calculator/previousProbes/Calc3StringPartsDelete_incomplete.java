package regex.calculator.previousProbes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 31.01.2017.
 */
public class Calc3StringPartsDelete_incomplete {
    /* хранилище операндов выражения **/
    private ArrayList<Double> operands;
    /* хранилище оператора **/
    private String statement;
    /* промежуточный или конечный результат вычислений **/
    private double result;
    /* место операндов и оператора в выражении **/
    private int startFirstOperand, startSecondOperand, startStatement;

    /* необходимо, чтобы начальные значения операндов были равны 0 **/
    public Calc3StringPartsDelete_incomplete() {
        operands = new ArrayList<>(2);
        for (int i = 0; i < 2; i++)
            operands.add(0d);
    }

    private void scan() {
        /* сканируем введенную строчку и определяем, есть ли там какое-либо значение **/
        Scanner lineInScanner = new Scanner(System.in);
        String data = null;
        if (lineInScanner.hasNextLine())
            data = lineInScanner.nextLine();
        /* если нет - выход **/
        if (data.equals("")) {
            System.out.println("Exit");
            System.exit(0);
        }
        /* если в просканированной строчке есть значение, создаем StringBuilder из прочитанной строчки,
        * с ним удобнее работать **/
        StringBuilder dataBuild = new StringBuilder(data);

        /* и начинаем обрабатывать его regex-ом. Вначале поиск первого операнда: **/
        Pattern operandsPattern = Pattern.compile("\\d+(\\.\\d+)?"); // "цифры и (факультативно) группа из точки и цифр"
        Matcher operandsMatcher = operandsPattern.matcher(dataBuild);
        String firstOperand = null;
        if (operandsMatcher.find()) { // NB!!!!!!!! я сделал здесь if, а не while, так что как только матчер нашел
            // соответствие, дальше он не работает.
            firstOperand = operandsMatcher.group();
            /* записываем значение операнда, если оно есть, первым элементом хранилища операндов **/
            operands.set(0, Double.valueOf(firstOperand));
            /* затем определяем индекс первого операнда, и по индексу удаляем его из билдера **/
            startFirstOperand = operandsMatcher.start();
            int end = operandsMatcher.end();
            dataBuild.delete(startFirstOperand, end);
            System.out.println(dataBuild.toString());
        }
        /* TODO: другой способ: определяем индекс первого операнда, если он есть, и по индексу удаляем его из билдера **/
//        int firstOperandIndex = dataBuild.indexOf(firstOperand);
//        System.out.println(data.indexOf(firstOperand));
//        dataBuild.delete(firstOperandIndex, (firstOperandIndex + firstOperand.length()));
//        System.out.println(dataBuild.toString());

        /* ищем второй операнд **/
        String secondOperand = null;
        if (operandsMatcher.find()) {
            secondOperand = operandsMatcher.group();
            /* записываем значение операнда, если оно есть, вторым элементом хранилища операндов **/
            operands.set(0, Double.valueOf(firstOperand));
        }
        /* теперь поиск оператора **/
        Pattern statementPattern = Pattern.compile("[+\\-*/]");
        Matcher statementMatcher = statementPattern.matcher(dataBuild);

    }
    public double calculate() {

        return 0;
    }

    public static void main(String[] args) {
        Calc3StringPartsDelete_incomplete calc = new Calc3StringPartsDelete_incomplete();
        calc.scan();

        for (double operand: calc.operands)
            System.out.println(operand);
        System.out.println("size = " + calc.operands.size());
    }

}
