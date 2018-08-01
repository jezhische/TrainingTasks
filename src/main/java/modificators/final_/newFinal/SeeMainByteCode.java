package modificators.final_.newFinal;

public class SeeMainByteCode {
    public static void main(String[] args) {
        System.out.println(T.x);
    }
}

class T {
    public static final int x = 341;

    static {
        System.out.println("see main bytecode!");
    }
}
