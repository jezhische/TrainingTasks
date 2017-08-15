package trainingTest.differentGarbage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WORK on 13.09.2016.
 */
public class SomeGarbage {
    public static void main(String[] args) {
//        String a = "1"+"2"+""+"3"+"    "+"4";
//        System.out.print("1");
//        System.out.print("2");
//        System.out.print("");
//        System.out.println("3");
//        String [] b = {"1", "2", "","","3"};
//        System.out.println(b.length);
//        String c = b[2];
//        System.out.println(c);
        String forRegex = "The gray  wolf jumped over the grey wall.";
        Pattern pattern = Pattern.compile("gr[ae]y\\s*\\S+?[\\s\\p{P}]");
        Matcher matcher = pattern.matcher(forRegex);
        while (matcher.find()) {
            System.out.print(matcher.group());

//            string pattern = @"gr[ae]y\s\S+?[\s\p{P}]";
//            string input = "The gray wolf jumped over the grey wall.";
//            MatchCollection matches = Regex.Matches(input, pattern);
//            foreach (Match match in matches)
//            Console.WriteLine(match.Value);
        }


    }
}
