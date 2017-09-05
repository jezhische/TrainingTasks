package statements;

public class IfStat {
    static void t(int i) {
        if (i == 0)
            System.out.println("t: zero!");
        System.out.println("t: non-zero!"); // 1
    }

    static void tt(int i) {
        if (i == 0)
            System.out.println("tt: zero!");
        else System.out.println("tt: non-zero!"); // 2
    }

    static int ttt(int i) {
        if (i == 0) {
            System.out.println("ttt: zero!");
            return i;                           // 3
        }
        System.out.println("ttt: non-zero!");
        return i;
    }

    public static void main(String[] args) {
        t(0);
        tt(0);
        ttt(0);
    }
}
