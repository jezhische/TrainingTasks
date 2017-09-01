package enumProbe.newE;

import java.util.Arrays;

public class EnumAsArray {

    // enum, созданный как array - на самом деле, как вложенный (nested) static  класс - именно поэтому он
    // не может быть локальным:
    enum Season {
        WINTER, SPRING, SUMMER, AUTUMN
    }

    ; // enum всегда будет static


    public static Season init(int initial) {
        return initial == 5 ? Season.WINTER : Season.AUTUMN;
    }

    public static void main(String[] args) {

        System.out.println(Season.SPRING);
        Season season = null;
        season = init(5);
        switch (season) {
            case WINTER:
                System.out.println(Season.WINTER);
                break;
            case SPRING:
                System.out.println(Season.SPRING);
                break;
            default:
                System.out.println("hoss...");
        }
        System.out.println(Arrays.toString(Season.values()).concat(" - this is Season enum"));
    }
}
