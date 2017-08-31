package string.newS;

public class StringCharProbe {
    public static void main(String[] args) {
        System.out.println("goije".charAt(3));
        System.out.println("goije".codePointAt(3));
        System.out.println(Character.getNumericValue("goije".codePointAt(3)));
        System.out.println(Character.getNumericValue("goije".charAt(3)));
        System.out.println(Character.toChars(106));
        System.out.println(Character.codePointAt("goije", 3));

        Object obj = new Object();
        Object str = "hororo";
        System.out.println(obj);
        System.out.println(str);
        System.out.println(str.toString());
    }
}
