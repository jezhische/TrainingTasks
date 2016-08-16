package trainingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 25.07.2016.
 */
public class WhileBreakProbeForRace {
    private List<Vehicle> userCarsToRace = new ArrayList<>();
    List<String> oneLineArgs = new ArrayList<>(5);
    boolean verify = true;

    public void readUserData() {
        Pattern userGroupsPattern = Pattern.compile("(-)?\\w+(.\\w+)?");
        int k = 0;
        int i = 0;
//        List<String> oneLineArgs = new ArrayList<>(5);
//        Scanner scanUserCar = new Scanner(System.in);
//        String userCarFromScanner = scanUserCar.nextLine();
        boolean exitCycle = true;
//        boolean verify = true;
        while (exitCycle) {
            Scanner scanUserCar = new Scanner(System.in);
            String userCarFromScanner = scanUserCar.nextLine();
            Matcher userGroupsMatcher = userGroupsPattern.matcher(userCarFromScanner);
//            boolean verify = true;
            int j = 0;
            while (userGroupsMatcher.find()) {
                if (j > 4) {
                    System.out.println("Параметры автомобиля " + oneLineArgs.get(0) + " объявлены неверно: найден " +
                            "избыточный параметр. Автомобиль снят с гонки.");
//                        userCarFromScanner = null;
                    this.verify = false;
                    break;
                } else {
                    oneLineArgs.add(j, userGroupsMatcher.group()); // заносим очищенные аргументы в список oneLineArgs
                    j++;
                }
            }
//            exitCycle = false;
//            break;
            if (verify = false) {
                exitCycle = false;
                break;
            } else {
//               exitCycle = false;
            }
        }
    }

    public static void main(String[] args) {
        WhileBreakProbeForRace wb = new WhileBreakProbeForRace();
        wb.readUserData();
        for (String s : wb.oneLineArgs) {
            System.out.println(s);
        }
    }
}
