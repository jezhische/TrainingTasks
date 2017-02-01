package regex;

/**
 * Created by Ежище on 01.02.2017.
 */
public class Reg2String {
    public static void main(String[] args) {
        String s = "abcbd";
        System.out.println(s.matches("[bcd]*"));
        System.out.println(s.matches("[abcbd]*"));
    }
}
