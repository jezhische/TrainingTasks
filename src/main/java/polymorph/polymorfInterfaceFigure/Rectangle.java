package polymorph.polymorfInterfaceFigure;

/**
 * Created by WORK_x64 on 19.12.2016.
 */
public class Rectangle extends Figure implements Areable {
    Rectangle (int w, int h) {super(w, h);}

    @Override
    public double area(int w, int h) {
        return w * h;
    }
}
