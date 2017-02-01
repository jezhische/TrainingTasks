package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 01.02.2017.
 */
public class Reg3 {
    public static void main(String[] args) {
        Pattern regex = Pattern.compile("[/*+-]");
        Matcher lastMatch = regex.matcher("+-**/-*-+= fbfgb1 55 -");

        String result = null;
        while (lastMatch.find())
            result = lastMatch.group();
        System.out.println(result);

        String resultInCertainPosition = null;
        while (lastMatch.find())
            resultInCertainPosition = lastMatch.group(5); // TODO:разобраться с номером позиции
        System.out.println(resultInCertainPosition);
    }
}
