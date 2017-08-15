package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ежище on 15.01.2017.
 * https://habrahabr.ru/post/260767/
 */
public class StringString {
    String sa;
    {sa += "o";}
    String a = "jhhj";
    String hhh() {
        return a.concat("sss").concat(" ").concat("hjjk");
    }
    private static String message(boolean b) {
        return "Your char had" + (b ? " " : "n't ") + "been found!";
    }
    static String string;

    public static void main(String[] args) {
        StringString s = new StringString();
        System.out.println(s.hhh());

        String habr = "habrahabr";
        char searchChar = 'h';
        boolean isFound = false;
        for(int i = 0; i < habr.length(); i++)
            if (habr.charAt(i) == searchChar) {
                isFound = true;
                break;
            }
        System.out.println(message(isFound));
        string += "habrahabr";
        System.out.println(string);

        String hello = "Hello";
        String habrr = "habrahabr";
        String delimiter = ", ";

        System.out.println(String.join(delimiter, hello, habr));
// или так
        System.out.println(String.join(delimiter, new ArrayList<CharSequence>(Arrays.asList(hello, habrr))));

        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly"); // так не пройдет:
        // ArrayList<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        ArrayList<String> al = new ArrayList<>(stooges);
        ArrayList<CharSequence> chl = new ArrayList<>(al); // можно и от stooges
        System.out.println(chl);
        System.out.println(chl.get(1));
    }
}
