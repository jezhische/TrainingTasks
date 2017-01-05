package javaForTester.generics.generics2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 05.01.2017.
 */
public class BoundedSuperCopy {
        static void copy (List<? extends Product> src, List<? super Product> dest) { // но можно и
            // List<? super Object> dest. Суть в том, что мы будем камеры складывать в контейнер с продуктами - разными,
            // там будут и телефоны, так что контейнер для приема ("OUT") должен быть шире, чем для выдачи ("IN").
            // Т.е. IN (sources) = extends (ограничение снизу, все, что "не больше, чем продукты" ("продукты" тоже можно)),
            // а   OUT (destination) = super (ограничение сверху, все,что "продукты или больше" ("продукты" тоже можно)).
        for (Product p: src)
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
        copy(cameras, products);
        for (Product p : products)
            System.out.println(p.getClass().getSimpleName());

        List<Phone> phones = new ArrayList<>();
        for (int i = 3; i > 0; i--)
            phones.add(new Phone());
//        copy(cameras, phones); // хо-хо! телефоны не залазят!
        copy(phones, products);
        System.out.println();
        for (Product p : products)
            System.out.println(p.getClass().getSimpleName());

        List<Product> newProducts = new ArrayList<>();
        for (int i = 3; i > 0; i--)
            newProducts.add(new Product());
        newProducts.add(new Camera());
        newProducts.add(new Phone());
        copy(newProducts, products);
        System.out.println();
        for (Product p : products)
            System.out.println(p.getClass().getSimpleName());

    }
}
