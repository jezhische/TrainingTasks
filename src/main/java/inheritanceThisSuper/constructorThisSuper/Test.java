package inheritanceThisSuper.constructorThisSuper;

/**
 * Created by Ежище on 19.12.2016.
 */
class A {
    A(){
        System.out.println("Конструктор без аргументов класса A");
    }

    A(String args){
        System.out.println("Конструктор с одним аргументом класса A: args " + args);
    }
}

class B extends A{

    B(){
        this("hhh"); // вызов конструктора с одним аргументом класса B
        System.out.println("Конструктор без аргументов класса B");
    }

    B(String args){
        super("kjkjkj"); // вызов конструктора с одним аргументом класса A
        System.out.println("Конструктор с одним аргументом класса B");
    }
}

// Тест-класс и вывод
public class Test {

    public static void main(String args[]) {
        B b = new B();
    }

}

