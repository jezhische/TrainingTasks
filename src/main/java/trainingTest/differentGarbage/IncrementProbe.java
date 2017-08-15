package trainingTest.differentGarbage;

/**
 * Created by Ежище on 06.08.2016.
 */
public class IncrementProbe {
    int errorCount = 0;
    boolean CycleIsRunning = true;

    private boolean nullLineValidator() { //если юзер ничего не ввел, и если breakOut = true, происходит break,
        // а если b8reakOut = false, то continue.
        boolean breakOut = false;
        if (errorCount <= 1) {
            System.out.println("Введите параметры автомобиля либо напечатайте esc и нажмите Enter " +
                    "для перехода на следующий этап.");
            errorCount++;
        }
        else if (errorCount == 3) {
            System.out.println("Ввод данных прерван. Пожалуйста, запустите программу снова.");
            breakOut = true;
            CycleIsRunning = false;
        }
        else if (errorCount == 2) {
            System.out.println("После следующей неправильной попытки ввода программа будет завершена.");
            errorCount++;
//                continueCycle = true;
        }
//        errorCount++;
//                continueCycle = true;
        return breakOut;
    }

    public static void main(String[] args) {
        IncrementProbe in = new IncrementProbe();
        System.out.println(in.errorCount);
        System.out.println("CycleIsRunning = " + in.CycleIsRunning);
        in.nullLineValidator();
        System.out.println(in.errorCount);
        System.out.println("CycleIsRunning = " + in.CycleIsRunning);
        in.nullLineValidator();
        System.out.println(in.errorCount);
        System.out.println("CycleIsRunning = " + in.CycleIsRunning);
        in.nullLineValidator();
        System.out.println(in.errorCount);
        System.out.println("CycleIsRunning = " + in.CycleIsRunning);
        in.nullLineValidator();
        System.out.println(in.errorCount);
        System.out.println("CycleIsRunning = " + in.CycleIsRunning);
        in.nullLineValidator();
        System.out.println(in.errorCount);
        System.out.println("CycleIsRunning = " + in.CycleIsRunning);
    }
}
