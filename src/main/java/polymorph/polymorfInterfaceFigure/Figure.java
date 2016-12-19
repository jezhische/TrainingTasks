package polymorph.polymorfInterfaceFigure;

/**
 * Created by WORK_x64 on 19.12.2016.
 */
public class Figure implements Relatable {
    @Override
    public int compare(Relatable other) {
        try {
            Areable otherFigure = (Areable) other;
        } catch (ClassCastException ex) {
            ex.getMessage();
        }
        return 0;
    }
}
