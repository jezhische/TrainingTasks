package lang;

public class IntToCharKeyboardKeys {
    public static void main(String[] args) {
        for (int i = 0; i < 125; i++) {
            System.out.println(i + ": " + (char) i);
        }
        System.out.println((int) 'а');
    }
}
