package regex.briefReview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ежище on 01.02.2017.
 */
public class ReplaceRegex {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();

        Pattern regexp = Pattern.compile("<[a-zA-Z0-9 ]+>");
        Matcher m = regexp.matcher("<a><b-><1><cvb nO0 ><d/>");
        while (m.find())
            m.appendReplacement(buffer, "text");
        m.appendTail(buffer);
//        String result = buffer.toString();

        System.out.println(buffer);
    }
}
