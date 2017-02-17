package string;

/**
 * Created by Ежище on 29.01.2017.
 */
public class StringSomeMethods {
    public static void main(String[] args) {
        String a = "kobo ro".replace('o', 'k');
        System.out.println(a);
        a += " berytkdjaoohojh";
        a = a.concat("+125");
        System.out.println(a);
        System.out.println("oj".codePointAt(1));
        System.out.println(Character.codePointAt("j", 0));
        System.out.println((int)'j');
        int i = a.indexOf("j");
        int ii = a.indexOf((int)'j', 5);
        System.out.println(i + Integer.toString(ii));
    }
}
