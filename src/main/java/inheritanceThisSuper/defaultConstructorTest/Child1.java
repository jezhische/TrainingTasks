package inheritanceThisSuper.defaultConstructorTest;

/**
 * Created by WORK_x64 on 06.02.2017.
 */
public class Child1 extends Parent {
    public Child1(int a) { // конструктора по умолчанию - без аргументов - уже нет, но почему-то он и не требуется.
        // Почему? TODO Потому что он автоматически реализуется в ЛЮБОМ конструкторе наследника, и пра-наследника,
        // даже если не указывать вызов super();!
        // Однако, в родителе либо не должно быть никакого конструктора (тогда конструктор без аргументов создается
        // неявно), либо явно д.б. создан конструктор без аргументов. Если этого нет, то наследника можно создавать
        // уже только с помощью какого-либо иного конструктора родителя, и с обязательным super вызовом этого конструктора.
        this.a = a;
        System.out.println("Child1 created with (int a) constructor only, without super() calling");
    }
    public Child1(String name) {
        System.out.println("Child1 created with (String name) constructor, but without super(name) calling");
    }
}
