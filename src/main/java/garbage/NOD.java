package garbage;

/**
 * Created by Ежище on 06.12.2016.
 * (наибольший общий делитель)
 * https://habrahabr.ru/sandbox/60131/
 */
public class NOD {
    public static int gcd(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(30, 180));
        System.out.println(30%180);

    }
}
