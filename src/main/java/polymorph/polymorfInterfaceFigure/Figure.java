package polymorph.polymorfInterfaceFigure;

/**
 * Created by WORK_x64 on 19.12.2016.
 */
public class Figure implements Relatable {
    public int width, height;

    Figure (int w, int h) {
        width = w;
        height = h;
    }

    @Override
    public int compare(Relatable other) {
        try {
            Areable first = (Areable) this;
            Areable otherFigure = (Areable) other;

            if (first.area(width, height) < otherFigure.area(width, height))
                return -1;
            else if (first.area(width, height) > otherFigure.area(width, height))
                return 1;
            else
                return 0;
        } catch (ClassCastException ex) {
            System.out.println(ex.getMessage());
            return -10;
        }
    }
}
