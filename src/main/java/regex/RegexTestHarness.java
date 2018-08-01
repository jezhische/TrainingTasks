package regex;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html
public class RegexTestHarness {
    public static void main(String[] args){
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("%nEnter your regex: ");
            Pattern pattern =
                    Pattern.compile(scanner.nextLine());

            System.out.println("Enter input string to search: ");
            Matcher matcher =
                    pattern.matcher(scanner.nextLine());

            boolean found = false;
            while (matcher.find()) {
//                console.format("I found the text" +
//                                " \"%s\" starting at " +
//                                "index %d and ending at index %d.%n",
//                        matcher.group(),
//                        matcher.start(),
//                        matcher.end());
                System.out.printf("I found the text \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
//                console.format("No match found.%n");
                System.out.println("No match found: " + " default was ^(jezh*)");
            }
        }
    }
}
