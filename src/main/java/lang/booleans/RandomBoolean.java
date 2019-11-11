package lang.booleans;

import java.util.Random;

public class RandomBoolean {

    private static boolean ranBool() {
        int coin = new Random().nextInt(2);
        return coin % 2 == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(ranBool());
        }
    }
}
