package polymorph.polymorfInterfaceFigure;

/**
 * Created by Ежище on 19.12.2016.
 */
public class Circle extends Figure implements Areable {
    Circle (int w, int h) {super(w, h);}

    @Override
    public double area(int w, int h) {
        return Math.PI * w * w / 4;
    }
}
