package javaForTester.generics.generics3;

/**
 * Created by WORK_x64 on 05.01.2017.
 */
public class Camera extends Product<Camera> {

    int pixels;
    @Override
    public boolean subCompare(Camera p) {
        if (p != null)
            return pixels > p.pixels;
        return false;
    }
}
