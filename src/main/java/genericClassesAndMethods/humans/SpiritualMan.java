package genericClassesAndMethods.humans;

/**
 * Created by WORK_x64 on 27.12.2016.
 */
public class SpiritualMan<T> extends Humans<T> {
//    SpiritualMan(I limbs, B sex, S soul) {
//        super (limbs, sex, soul);
//    }
    SpiritualMan(T soul) {
        super (soul);
        super.soul = soul;
    }
}
