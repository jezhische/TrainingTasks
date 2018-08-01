package garbage;

public class MultyEquality {

//    НЕ РАБОТАЕТ
    public static int a;

    static {
        if (a == 0 || a == 1 || a == 2) {
            try {
                throw new AException();
            } catch (AException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((a == 0 && a == 1 && a == 2));
    }
}

class AException extends Exception {
    public AException() {
        MultyEquality.a++;
    }
}

