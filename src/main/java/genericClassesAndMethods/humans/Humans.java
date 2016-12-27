package genericClassesAndMethods.humans;

/**
 * Created by WORK_x64 on 27.12.2016.
 */
public abstract class Humans <T> {
    T limbs;
    T sex;
    T soul;

    protected Humans (T limbs, T sex, T soul) {
        this.limbs = limbs;
        this.sex = sex;
        this.soul = soul;
    }
    protected Humans (T something) {}
//    protected Humans (T sex) {
//        this.sex = sex;
////    }
//    protected Humans (T soul) {
//        this.soul = soul;
//    }


//    protected Humans () {}
//    protected Humans (I limbs, B sex, S soul) {
//        this.limbs = limbs;
//        this.sex = sex;
//        this.soul = soul;
//    }
//    protected Humans (I limbs) {
//        this.limbs = limbs;
//    }
//    protected Humans (B sex) {
//        this.sex = sex;
//    }
//    protected Humans (S soul) {
//        this.soul = soul;
//    }

}
