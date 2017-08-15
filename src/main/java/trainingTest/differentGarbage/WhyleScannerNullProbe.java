package trainingTest.differentGarbage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ежище on 07.08.2016.
 */
public class WhyleScannerNullProbe {
    ArrayList<Vehicle> userCarsToRace = new ArrayList<>();
    int errorCount = 0;
    boolean CycleIsRunning = true;
    String message = null;

    private String handleNullLine() { //выдает сообщения на нулевую строчку и увеличивает счетчик ошибочных вводов,
        // после определенного количества нулевых вводов выкидывает из цикла через CycleIsRunning = false
        String message = null;
        if (errorCount <= 1) {
            message = "Введите параметры автомобиля либо напечатайте esc и нажмите Enter " +
                    "для перехода на следующий этап.";
            errorCount++;
        } else if (errorCount == 3) {
            message = "Ввод данных прерван. Пожалуйста, запустите программу снова.";
            CycleIsRunning = false;
        } else if (errorCount == 2) {
            message = "После следующей неправильной попытки ввода программа будет завершена.";
            errorCount++;
        }
        return message;
    }

    public boolean breakDataInputWithEsc(String userInputFromScanner) {
        if (errorCount > 0 && userInputFromScanner.equals("esc")) {
            CycleIsRunning = false;
            message = "Вы закончили ввод данных. Если вы хотите начать гонку, введите RUN и нажмите Enter." +
                    "\nЕсли вы хотите также добавить готовый список автомобилей из файла, введите 2 и нажмите Enter.";
            return true;
        } else if (errorCount == 0 && userInputFromScanner.equals("esc")) {
            message = "Имя esc зарезервировано как команда для перехода на следующий этап.";
            errorCount++;
            return true;
        }
        return false;
    }

    void scan() {
        while (CycleIsRunning) {
            Scanner scanUserInput = new Scanner(System.in);
            String userInputFromScanner = scanUserInput.nextLine(); // отсканированная (еще не очищенная) строчка
            // ставим условие возвращения цикла в начало или выхода из цикла, если отсканированная строчка нулевая:
            if (userInputFromScanner.equals("")) {
                System.out.println(handleNullLine());
                continue;
            }
            if (breakDataInputWithEsc(userInputFromScanner)) {
                System.out.println(message);
                continue;
            }
        }
    }

    public static void main(String[] args) {
        WhyleScannerNullProbe wh = new WhyleScannerNullProbe();
        wh.scan();
    }

}
