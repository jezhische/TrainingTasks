package regex.calculator;

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
     * всегда только левый оператор. oldGenerationStatement  - оператор, оставленный от прошлого вычисления,
     * может понадобиться, если будет нажат просто Enter (это буфер операторов) **/
    private String leftStatement, rightStatement, oldGenerationStatement;

    /* промежуточный или конечный результат вычислений, и предыдущий правый или единственный операнд (буфер операндов) **/
    private double result, oldGenerationOperand;

    /* необходимо, чтобы начальные значения операндов были равны 0 **/
    public Calc3() {
        operands = new ArrayList<>(2);
        for (int i = 0; i < 2; i++)
            operands.add(0d);
        parsedDataIndex = new ArrayList<>();
        System.out.println("to exit press e+Enter or Space+Enter");
    }

    private void parse() {
        /* сканируем введенную строчку и определяем, есть ли там какое-либо значение **/
        Scanner lineInScanner = new Scanner(System.in);
        /* сюда записывается результат сканирования **/
        String data = null;
        if (lineInScanner.hasNextLine())
            data = lineInScanner.nextLine();
        /* если нет - выход **/
        if (/*data.equals("")*/ data.matches("[ e]")) {
            System.out.println("Exit");
            System.exit(0);
        }
        /* почистим список индексов элементов отсканированного выражения и список операндов от предыдущих значений **/
        parsedDataIndex.clear();
        operands.clear();
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
        Pattern statementPattern = Pattern.compile("[+\\-*/]|^$"); // "один из символов + * - / или же пустая строка
        // (только начало и конец)"
        Matcher statementMatcher = statementPattern.matcher(data);
        /* если пользователь ввел несколько операторов, то учитываться будет последний из стоящих между операндами,
         * или последний, стоящий перед единственным операндом, или последний, если есть операторы только после
          * единственного операнда, или последний, если операндов нет. **/
        oldGenerationStatement = leftStatement == null? rightStatement : leftStatement; // чтобы использовать, если
        // будет нажата просто Enter; что касается буфера операндов, то он меняет значение в методе calculate,
        // поскольку для ситуации "нет операндов в выражении" он приобретает значение предыдущего result
        leftStatement = null;
        rightStatement = null;
            /* ситуация, когда есть оба операнда: **/
        if (i == 2) {
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
        /* ситуация с двумя операндами **/
        if (operands.size() == 2) {
            oldGenerationOperand = operands.get(1); // (чтобы использовать, если будет нажата просто Enter)
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
//                System.out.println("calculation failed: " + e.getCause());
                try {
                    throw new CalcException("calculation failed: ", e);
                } catch (Exception ce) {
                    System.out.println(ce.getMessage() + ce.getCause());
                }
            }
        } else if (operands.size() == 1) {
            /* 1 операнд, оператор слева **/
            if (rightStatement == null) {
                oldGenerationOperand = operands.get(0);
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
                /* 1 операнд, оператор справа **/
            } else if (leftStatement == null) {
                oldGenerationOperand = operands.get(0);
                try {
                    switch (rightStatement) {
                        case "+":
                            result = operands.get(0) * 2;
                            System.out.println(operands.get(0) + " + " + operands.get(0) + " = " + result);
                            break;
                        case "-":
                            result = 0;
                            System.out.println(operands.get(0) + " - " + operands.get(0) + " = " + result);
                            break;
                        case "*":
                            result = operands.get(0) * operands.get(0);
                            System.out.println(operands.get(0) + " * " + operands.get(0) + " = " + result);
                            break;
                        case "/":
                            result = 1;
                            System.out.println(operands.get(0) + " / " + operands.get(0) + " = " + result);
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
            /* 0 операндов **/
        } else if (operands.size() == 0) {
            double previousResult = result;
            try {
                switch (rightStatement) {
                    case "+":
                        oldGenerationOperand = result;
                        result = previousResult * 2;
                        System.out.println(previousResult + " + " + previousResult + " = " + result);
                        break;
                    case "-":
                        oldGenerationOperand = result;
                        result = 0;
                        System.out.println(previousResult + " - " + previousResult + " = " + result);
                        break;
                    case "*":
                        oldGenerationOperand = result;
                        result = previousResult * previousResult;
                        System.out.println(previousResult + " * " + previousResult + " = " + result);
                        break;
                    case "/":
                        oldGenerationOperand = result;
                        result = 1;
                        System.out.println(previousResult + " / " + previousResult + " = " + result);
                        break;
                    case "":
                        calculateOldGeneration();
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
        calculate();
    }
    private void calculateOldGeneration() {
        double previousResult = result;
        try {
            switch (oldGenerationStatement) {
                case "+":
                    result += oldGenerationOperand;
                    System.out.println(previousResult + " + " + oldGenerationOperand + " = " + result);
                    break;
                case "-":
                    result -= oldGenerationOperand;
                    System.out.println(previousResult + " - " + oldGenerationOperand + " = " + result);
                    break;
                case "*":
                    result *= oldGenerationOperand;
                    System.out.println(previousResult + " * " + oldGenerationOperand + " = " + result);
                    break;
                case "/":
                    result /= oldGenerationOperand;
                    System.out.println(previousResult + " / " + oldGenerationOperand + " = " + result);
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

    public static void main(String[] args) {
        Calc3 calc = new Calc3();
         calc.calculate();
    }

}
