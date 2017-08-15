package regex.briefReview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 01.02.2017.
 * http://www.javenue.info/post/43
 */
public class TestRegexp {
    public static final Pattern pattern = Pattern.compile
            ("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");
    /* Последовательность вида [a-zA-Z] указывает на множество, в нашем случае это множество латинских символов
    в верхнем и нижнем регистрах. {n} говорит о том, что некоторый символ должен встретится n раз,
    а {n,m} - от n до m раз. Символ \d указывает на множество цифр. "\u002E" и "\u005F" - это символы точки и
    подчеркивания соответсвенно. Знак плюс после некоторой последовательности говорит о том, что она должна встретится
    один или более раз. "|" - представление логического "или".

    Полное описание всех конструкций можно найти в Java API.

    В нашем примере под Pattern будут подходить те e-mail адреса, которые начинаются с буквы, содержат буквы, цифры,
    точку и подчеркивание до символа "@" и находятся в доменах com, net, org (не более третьего уровня). **/

    public static void doMatch(String word) {
        Matcher matcher = pattern.matcher(word);
        System.out.println("Validation for " + word +
                (matcher.matches() ? " passed." : " not passed."));
    }

    public static void main(String[] args) {
        doMatch("c0nst@money.simply.net");
        doMatch("Name.Sur_name@gmail.com");
        doMatch("useR33@somewhere.in.the.net");
    }
}
