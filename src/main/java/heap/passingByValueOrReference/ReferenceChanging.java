package heap.passingByValueOrReference;

/**
 * Created by WORK_x64 on 25.01.2017.
 */
public class ReferenceChanging {
    public int a, b;
    public String c;
    public ReferenceChanging(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static ReferenceChanging tryToChangeReference(ReferenceChanging rech) { // попытка поменять ссылку: сделать так,
        // чтобы значение ссылки rech переписалось на newRech, соответственно, rech уже будет указывать на новый
        // объект, на который ссылается newRech
        ReferenceChanging newRech = new ReferenceChanging(666, 888, "hororo");
        rech = newRech;
        return rech;
    }

    public static void main(String[] args) {
        ReferenceChanging rech = new ReferenceChanging(5, 3, "ku");
        System.out.printf("Before changing: a, b, c:                 %d, %d, %s", rech.a, rech.b, rech.c);
        tryToChangeReference(rech);
        System.out.printf("\nAfter attempt to change: a, b, c:         %d, %d, %s", rech.a, rech.b, rech.c);
        rech = tryToChangeReference(rech);
        System.out.printf("\nAfter changing with equaling: a, b, c:    %d, %d, %s", rech.a, rech.b, rech.c);
        ReferenceChanging hhh = rech;
        rech.a = 598632;
        hhh.b = 874545455;
        System.out.printf("\nrech: a, b, c:                 %d, %d, %s", rech.a, rech.b, rech.c);
        System.out.printf("\nhhh: a, b, c:                 %d, %d, %s", rech.a, rech.b, rech.c);

    }
}
