package string.newS;

public class StringSubSequence {
    public static void main(String[] args) {
        String origin = "gchgfdh lknnn.xml";
        String trimmed = origin.subSequence(0, origin.length() - 2) + "sd";
        System.out.println(trimmed);
        trimmed = origin.substring(0, origin.length() - 2) + "sd";
        System.out.println(trimmed);
    }
}
