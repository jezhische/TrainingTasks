package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;

public class MinuteSeconds {
    public static int parseTimeToSeconds(double formattedTime) {
        int integer = (int)formattedTime;
        double fraction = Double.valueOf(String.format(Locale.ENGLISH, "%.3f", formattedTime - integer)) * 100;
        int parsedFraction = (int) fraction;
        return integer * 60 + parsedFraction;
    }
    public static int summ(double... values) {
        int summ = 0;
        for (double value : values) {
            summ += parseTimeToSeconds(value);
        }
        return summ;
    }
    public static void printTime(int seconds) {
        int hours = (seconds - seconds % 3600) / 3600;
        int remains = seconds - hours * 3600;
        int minutes = (remains - remains % 60) / 60;
        int secondsRemain = remains % 60;

        System.out.printf("%d : %d : %d", hours, minutes, secondsRemain);
    }
    public static void main(String[] args) {

        int seconds = summ(3.53,0.17,3.24,1.09,0.34,2.24,1.39,0.18,1.52,1.09,2.5,2.55,3.46,1.59,2,3.05,0.12,2,
                0.2,4.3,0.3,1.3,1.12,2,2,0.12,2,1.3,3,2.56);
        System.out.println(seconds);
        printTime(seconds);
    }
}
