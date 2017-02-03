package garbage.trash.trashtrash;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 31.01.2017.
 */
public class Calc3 {
    /* хранилище индексов операндов и операторов для определения их взаимного расположения **/
    private ArrayList<Integer> parsedDataIndex;
    /* хранилище операндов выражения **/
    private ArrayList<Double> operands;
    /* хранилище оператора с учетом, что если операнд единственный, то нужно определить, слева от него находится
    * оператор или справа; если операндов нет, то это всегда правый оператор; если операндов два, то используется
     * всегда только левый оператор. Ну... пожалуй, пока что оставим для удобства просто "оператор" :**/
    private String leftStatement, rightStatement, statement;
//    int leftStatementIndex = 0, rightStatementIndex = 0; // что касается индекса оператора, то его знать уже
//    // необязательно, поскольку уже знаем, левый это оператор или правый

    /* промежуточный или конечный результат вычислений **/
    private double result;
    /* индексы операндов и оператора в выражении **/
//    private int startFirstOperand, startSecondOperand, statementIndex;

    /* необходимо, чтобы начальные значения операндов были равны 0 **/
    public Calc3() {
        operands = new ArrayList<>(2);
//        for (int i = 0; i < 2; i++)
//            operands.add(0d);
        parsedDataIndex = new ArrayList<>();
    }

    private void parse() {
        /* сканируем введенную строчку и определяем, есть ли там какое-либо значение **/
        Scanner lineInScanner = new Scanner(System.in);
        /* сюда записывается результат сканирования **/
        String data = null;
        if (lineInScanner.hasNextLine())
            data = lineInScanner.nextLine();
        /* если нет - выход **/
        if (data.equals("")) { // TODO: здесь нужно добавить ситуацию, когда сделано предыдущее действие, например,
            // + 2, то нажатие Enter при пустой строчке приравнивается к =, т.е должна выполняться снова операция +2.
            // Так что для выхода нужно придумать иную комбинацию.
            System.out.println("Exit");
            System.exit(0);
        }
//        /* если в просканированной строчке есть значение, создаем StringBuilder из прочитанной строчки,
//        * с ним удобнее работать **/
//        StringBuilder dataBuild = new StringBuilder(data);
        /* почистим список индексов элементов отсканированного выражения и список операндов от предыдущих значений **/
        parsedDataIndex.clear();
        operands.clear();
//        for (int i = 0; i < 2; i++)
//            operands.add(0d);
        /* и начинаем обрабатывать выражение regex-ом. Вначале поиск операндов и определение их индекса в выражении: **/
        Pattern operandsPattern = Pattern.compile("\\d+(\\.\\d+)?"); // "цифры и (факультативно) группа из точки и цифр"
        Matcher operandsMatcher = operandsPattern.matcher(data);
        int i = 0; // счетчик операндов
        while (operandsMatcher.find()) {
            parsedDataIndex.add(i, operandsMatcher.start());
            operands.add(i, Double.valueOf(operandsMatcher.group()));
            i++;
        }
        /* если найдено больше двух операндов: **/
        if (i > 2) {
            try {
                throw new CalcException("data input failure: too much operands");
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

        /* теперь поиск оператора и определение его индекса **/
        Pattern statementPattern = Pattern.compile("[+\\-*/]"); // "один из символов + * - /"
        Matcher statementMatcher = statementPattern.matcher(data);
        /* если пользователь ввел несколько операторов, то учитываться будет последний из стоящих между операндами,
         * или последний, стоящий перед единственным операндом, или последний, если есть операторы только после
          * единственного операнда, или последний, если операндов нет. **/
        leftStatement = null;
        rightStatement = null;
            /* ситуация, когда есть оба операнда: **/
        if (i == 2) {
            System.out.println("if (i == 2)"); //TODO
            while (statementMatcher.find()) {
                int key = 0;
                if ((key = statementMatcher.start()) < parsedDataIndex.get(1) && key > parsedDataIndex.get(0)) // к
                    // сожалению, здесь есть условие нерешенное: если есть оператор между двумя операндами и есть
                    // оператор перед первым операндом, то его этот парсер не заметит; если это "-", выходит
                    // нехорошо. Условие: первое отрицательное число выполнять через выражение с одним операндом
                    // (например, -645, а не -645*25)
                    leftStatement = statementMatcher.group();
            }
//                statement = leftStatement;

                /* ситуация, когда есть только один операнд **/
        } else if (i == 1) {
            System.out.println("if (i == 1)"); //TODO
            boolean statementKey = true;
            while (statementMatcher.find()) {
                        /* если найден оператор слева от операнда: **/
                if (statementMatcher.start() < parsedDataIndex.get(0)) {
                    leftStatement = statementMatcher.group();
                    statementKey = false;
                            /* если первый найденный оператор находится справа от операнда: **/
                } else if (statementKey)
                    rightStatement = statementMatcher.group();
            }
//                statement = statementKey? rightStatement : leftStatement;

                /* ситуация, когда нет ни одного операнда **/
        } else if (i == 0) {
            System.out.println("if (i == 0)"); //TODO
            while (statementMatcher.find()) {
                rightStatement = statementMatcher.group();
            }
//                statement = rightStatement;
        }
            /* условие ниже нужно, чтобы учесть ситуацию, когда есть два операнда и есть хотя бы один
            * оператор, но он стоит после второго операнда, или когда оператор вовсе пропущен: **/
        if (leftStatement == null && rightStatement == null) {
            try {
                throw new CalcException("data input failure: wrong statement position or there is no statement");
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void calculate() {
        parse();
        if (operands.size() == 2) {
            try {
                switch (leftStatement) {
                    case "+":
                        result = operands.get(0) + operands.get(1);
                        System.out.println(operands.get(0) + " + " + operands.get(1) + " = " + result);
                        break;
                    case "-":
                        result = operands.get(0) - operands.get(1);
                        System.out.println(operands.get(0) + " - " + operands.get(1) + " = " + result);
                        break;
                    case "*":
                        result = operands.get(0) * operands.get(1);
                        System.out.println(operands.get(0) + " * " + operands.get(1) + " = " + result);
                        break;
                    case "/":
                        result = operands.get(0) / operands.get(1);
                        System.out.println(operands.get(0) + " / " + operands.get(1) + " = " + result);
                        break;
                    default:
                        System.out.println("unknown failure");

                }
            } catch (Exception e) {
                try {
                    throw new CalcException("calculation failed: ", e);
                } catch (Exception ce) {
                    System.out.println(ce.getMessage() + ce.getCause());
                }
            }
        } else if (operands.size() == 1) {
            if (rightStatement == null) {
                double previousResult = result;
                try {
                    switch (leftStatement) {
                        case "+":
                            result += operands.get(0);
                            System.out.println(previousResult + " + " + operands.get(0) + " = " + result);
                            break;
                        case "-":
                            result -= operands.get(0);
                            System.out.println(previousResult + " - " + operands.get(0) + " = " + result);
                            break;
                        case "*":
                            result *= operands.get(0);
                            System.out.println(previousResult + " * " + operands.get(0) + " = " + result);
                            break;
                        case "/":
                            result /= operands.get(0);
                            System.out.println(previousResult + " / " + operands.get(0) + " = " + result);
                            break;
                        default:
                            System.out.println("unknown failure");

                    }
                } catch (Exception e) {
                    try {
                        throw new CalcException("calculation failed: ", e);
                    } catch (Exception ce) {
                        System.out.println(ce.getMessage() + ce.getCause());
                    }
                }
            }
        }
        calculate();

//        return result = 0;
    }

    public static void main(String[] args) {
        Calc3 calc = new Calc3();
//        calc.parse();

//        for (double operand : calc.operands)
//            System.out.println(operand);
////        System.out.println("statement = " + calc.statement);
//        System.out.println("rightStatement = " + calc.rightStatement);
//        System.out.println("leftStatement = " + calc.leftStatement);
//        System.out.println("size = " + calc.operands.size());

        calc.calculate();
    }

}
