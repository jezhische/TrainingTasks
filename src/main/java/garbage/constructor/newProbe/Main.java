package garbage.constructor.newProbe;

/**
 * Created by WORK_x64 on 17.08.2017.
 */
public class Main {
    public static void main(String[] args) {

        Child child = new Child("ohoho");
    }
}

class Parent {
    public String s;

    Parent (String s) {
        System.out.println(this.s);
        this.s = s;
        System.out.println(this.s);

    }
}

class Child extends Parent {
    Child () {
        super("jj");
    }
    Child (String s) {
        super("jj");
        System.out.println(s);
    }
    public int a = 5;
}