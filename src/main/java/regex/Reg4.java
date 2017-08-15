package regex;

import java.util.regex.*;

/**
 * Created by Ежище on 20.02.2017.
 */
public class Reg4 {
    public static void main(String[] args) {
        String s = "213oij 56/ l<Lvv12.23mlk 23.89 +";
        StringBuilder sb = new StringBuilder();
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pat.matcher(s);
        while(matcher.find())
            sb.append(matcher.group()).append("; ");
        System.out.println(sb);

        String k = "ugf hhjb65vd321sdv";
        k = k.subSequence(2, k.length()).toString();
        k = k.substring(0, 16);
        System.out.println(k);

        String kk = "" + 5;
        Integer i = 7;
        kk = kk.concat(""+i);
        System.out.println(kk);
        System.out.println(i);

    }
}
