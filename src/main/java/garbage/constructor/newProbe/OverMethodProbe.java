package garbage.constructor.newProbe;

/**
 * Created by WORK_x64 on 17.08.2017.
 */
public class OverMethodProbe {
    private void acceptAA(AA aa) {
        aa.print();
    }

    public static void main(String[] args) {
        OverMethodProbe over = new OverMethodProbe();
        over.acceptAA(new AA());
        over.acceptAA(new BB());

        AA aa = new BB();
        BB bb = new BB();
        over.acceptAA(aa);
        over.acceptAA(bb);

        System.out.println(new AA().s);
        System.out.println(aa.s);
    }
}

class AA {
    public void print() {
        System.out.print("AA!");
    }

    public String s = "AUAU";
}

class BB extends AA {
    @Override
    public void print() {
        System.out.println();
        super.print();
        System.out.println("No, BB!");
    }
    {super.s = "BUBU";}
}
