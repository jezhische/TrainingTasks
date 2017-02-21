package abstrct;

/**
 * Created by Ежище on 20.02.2017.
 */
public abstract class AbstrProbe {
    String s;
    int i;
    AbstrProbe(String s, int i) {
        this.s = s;
        this.i = i;
    }
    static {
        System.out.println("Go!");
    }
    {if(i == 5)
    i *= 2;} // не сработает - блок инициализации вызывается раньше конструктора
    void print() {
        System.out.println("Yes");
    }
//    public abstract int plus(int i);

}
class Test {
//    int a;
//    Test(){}
//    Test(int a) {this.a = a;}
//    {}
    AbstrProbe ab = new AbstrProbe("p", 5) {}; // если нет ни одного абстрактного метода, то можно и так

    public static void main(String[] args) {
        System.out.println(new Test().ab.i);

    }
}
