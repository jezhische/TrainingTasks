package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 01.02.2017.
 */
public class Reg1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "5+* - /=62.3K";
        String[] seq = s.split(" ");
        for (String str : seq)
            System.out.print(str + "; ");
        System.out.println();

        Pattern digitPattern = Pattern.compile("\\d+(.\\d+)?");
        Matcher digitMatcher = digitPattern.matcher(s);
        while (digitMatcher.find())
            System.out.print(digitMatcher.group() + "; ");
        System.out.println();
        Pattern statementPattern = Pattern.compile("[+\\-*/]");
        Matcher statementMatcher = statementPattern.matcher(s);
        while (statementMatcher.find())
            System.out.print(statementMatcher.group() + "; ");
        System.out.println();

    }
}
