package garbage.modifierProbe;

import java.util.Random;

/**
 * Created by Ежище on 28.11.2016.
 */
public class Garb1 {
    public static void main(String[] args) {
        Random randomizer = new Random();
        for (int i = 0; i < 20; i++)
            System.out.print(randomizer.nextInt(3) + " ");
    }
}
