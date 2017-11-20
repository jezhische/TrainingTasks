package quizfulAndSoOn.checkup;

public class Probe3 {
    public static void main(String args[]) {
        A a = new B();
        a.m(34);
    }
}

class A {
    public void m(int k) {
        System.out.println("class A, method m : " + ++k);
    }

    static /*final*/ void hou() { // несмотря на то, что для статиков происходит hiding, а не override, это тоже
        // вариант переопределения, и от финального метода это будет невозможно
        System.out.println("A-kru!");
    }
}

class B extends A {
    //    public int m(int k) { // попытка переопределения с заменой типа возвращаемого значения
//        System.out.println("class B, method m : " + k++);
//        return k;
//    }
    static final void hou() {
        System.out.println("B-kru!");
    }
}