package regex.briefReview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 01.02.2017.
 */
public class SearchRegexp {
    public static void main(String[] args) {
        Pattern regexp = Pattern.compile("<[a-z]+>");
        Matcher m = regexp.matcher("<a><b-><1><c><d/>");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
