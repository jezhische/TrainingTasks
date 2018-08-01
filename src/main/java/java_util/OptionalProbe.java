package java_util;

import java.util.Arrays;
import java.util.Optional;

public class OptionalProbe {
    public static void main(String[] args) {
        Optional<String> optString1 = Optional.of("fff");
        System.out.println(optString1.get());
        System.out.println(optString1.orElse("ku"));

        Optional<String> optString2 = Optional.empty();
        System.out.println(optString2.orElse("ku"));
//        optString2.map()
        System.out.println(optString1.map(string -> Arrays.asList(string, string, string)).get());
    }
}
