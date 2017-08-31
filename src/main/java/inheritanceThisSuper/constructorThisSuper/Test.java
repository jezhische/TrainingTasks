package inheritanceThisSuper.constructorThisSuper;
/**
 * Created by Ежище on 19.12.2016.
 */
class A {
    final int o(){return 0;}
    private int oo(){return 0;}
    A(){
        System.out.println("Конструктор без аргументов класса FileWriterSimply");
    }

    A(String args){
        System.out.println("Конструктор с одним аргументом класса FileWriterSimply: args " + args);
    }
}

class B extends A{
//    int o(){return 0;} // cannot override

//    @Override // метод ниже создать можно, но он doe's not override method of it's superclass
    private int oo(){return 0;}
    B(){
        this("hhh"); // вызов конструктора с одним аргументом класса B
        System.out.println("Конструктор без аргументов класса B");
    }

    B(String args){
        super("kjkjkj"); // вызов конструктора с одним аргументом класса FileWriterSimply
        System.out.println("Конструктор с одним аргументом класса B");
    }
}

// Тест-класс и вывод
public class Test {
    public static void main(String args[]) {
        A a = new A();
        B b = new B();

        System.out.println(b.getClass().isInstance(A.class));
        System.out.println(b.getClass().equals(A.class));
        System.out.println(b instanceof A);
        System.out.println(a.getClass().isInstance(B.class));
        System.out.println(b.getClass().equals(A.class));
        System.out.println(a instanceof B);

        a = b; // восходящее преобразование, b приобретает тип A 
        b = (B) a; // нисходящее преобразование, приведение должно быть указано явно, поскольку у B может быть
        // функционал и поля, которых нет у A
    }

}

