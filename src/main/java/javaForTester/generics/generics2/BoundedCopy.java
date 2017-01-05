package javaForTester.generics.generics2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 05.01.2017.
 */
public class BoundedCopy {
    static <T extends Product> void copy(List<T> src, List<T> dest) { // а так не получаеся:
        // List<? extends Product> dest - в dest определяется конкретный тип Product, а не capture<? super Product>
        // Но почему-то не получается и так:
//        static void copy (List<? extends Product> src, List<? super Product> dest) {
//        for (Product p: src)
//            dest.add(p);
//    } // - в этом случае в main в качестве второго аргумента требует List<Product>, а не List<? extends Product>
        for (T p : src)
            dest.add(p);
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Camera> cameras = new ArrayList<>();
        Camera a = new Camera();
        Camera b = new Camera();
        Camera c = new Camera();
        cameras.add(a);
        cameras.add(b);
        cameras.add(c);
        List<Camera> store = new ArrayList<>();
        copy(cameras, store);
        for (Product p : store)
            System.out.println(p.getClass().getSimpleName());
        List<Phone> phones = new ArrayList<>();
        for (int i = 3; i > 0; i--)
            phones.add(new Phone());
//        copy(cameras, phones); // хо-хо! телефоны не залазят!
    }
}

class Product {
}

class Camera extends Product {
}

class Phone extends Product {
}