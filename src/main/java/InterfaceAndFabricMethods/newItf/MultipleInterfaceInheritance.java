package InterfaceAndFabricMethods.newItf;

import java.text.NumberFormat;

/**
 * Created by WORK_x64 on 05.09.2017.
 */
public class MultipleInterfaceInheritance {
    public static void main(String[] args) {

        WowWowWow w = new WowWowWow() {
            @Override
            public void a() {

            }
        };
        w.a();
//        ((WowWow) w).c(); // todo: static method may be invoked on containing interface class only
//        WowWowWow.c(); // статического метода с() просто нет в интерфейсе WowWowWow
        WowWow.c(); // !!! а здесь - есть
        class Wau implements WowWowWow {

            @Override
            public void a() {
                System.out.println(WowWowWow.class);
                System.out.println(WowWowWow.class.getSuperclass());
                Object[] objects = WowWowWow.class.getSigners();
                if (objects != null) {
                for (Object o :objects) {
                    System.out.println(o);
                }
                } else System.out.println("NULL");

            }
        }
//        ((WowWow)new Wau()).c(); // static method may be invoked on containing interface class only
        new Wau().a();
        new Wau().b();
        new Wau().d();


    }
}

interface Wow {
    void a();
    default void b() {
        System.out.println("Wow");
    }
    static void c() {System.out.println("Wow");}
}

interface WowWow {
    void a();
//    default void b() { // todo: с тем же именем - не пропустит компилятор при множественном наследовании
//        System.out.println("WowWow");
//    }
    default void d() {
        System.out.println("WowWow");
    }
static void c() {System.out.println("WowWow");}
}

interface WowWowWow extends Wow, WowWow {
    @Override
    void a();
}
