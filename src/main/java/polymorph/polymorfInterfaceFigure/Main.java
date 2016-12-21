package polymorph.polymorfInterfaceFigure;

/**
 * Created by Ежище on 20.12.2016.
 */
public class Main {
    public static void main(String[] args) throws ClassCastException {
        Rectangle rect = new Rectangle(5, 10);
        Circle circ = new Circle(5, 10);
        Triangle tri = new Triangle(5, 10);
        Relatable relRect = new Rectangle(5, 10);

        System.out.println("rect.compare(circ) = " + rect.compare(circ));
        System.out.println("circ.compare(rect) = " + circ.compare(rect));

        System.out.println("relRect.compare(circ) = " + relRect.compare(circ));
        System.out.println("circ.compare(relRect) = " + circ.compare(relRect));

        System.out.println("circ.compare(circ) = " + circ.compare(circ));
        System.out.println("relRect.compare(rect) = " + relRect.compare(rect));

        System.out.println("circ.compare(tri) = " + circ.compare(tri));
        System.out.println("tri.compare(circ) = " + tri.compare(circ));
    }
}
