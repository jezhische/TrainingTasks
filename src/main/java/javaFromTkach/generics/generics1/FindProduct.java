package javaFromTkach.generics.generics1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 05.01.2017.
 */
public class FindProduct {
    static boolean find (List<? extends Product> all, Product p) {
        for (Product sp : all) {
            if (sp.getClass().equals(p.getClass()))
                return true;
        }
        return false;
    }

    static <T extends Product> boolean findAgain (List<T> all, T p) {
        for (Product sp : all) {
            if (sp.getClass().equals(p.getClass()))
                return true;
        }
        return false;
    }
    static <T> boolean findAtLast (List<? extends T> all, T p) {
        for (T sp : all) {
            if (sp.getClass().equals(p.getClass()))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List <Camera> cameras = new ArrayList<>();
        List <Product> products = new ArrayList<>();
        cameras.add(new Camera()); // если список пустой, то null != new Camera.
        products.add(new Product());
        Camera cam = new Camera();
        Product p = new Product();
        System.out.println(find(cameras, cam));
        System.out.println(find(cameras, p));
        System.out.println(find(products, cam));
        System.out.println(find(products, p));
        System.out.println(findAtLast(products, new Phone()));
        System.out.println(findAtLast(cameras, new Phone()));

        System.out.println("\n" + findAgain(cameras, cam));
//        System.out.println(findAgain(cameras, p)); // упс! вот здесь компиляция не проходит...
        System.out.println(findAgain(products, cam));
        System.out.println(findAgain(products, p));
        System.out.println(findAtLast(products, new Phone()));
        System.out.println(findAtLast(cameras, new Phone()));

        System.out.println("\n" + findAtLast(cameras, cam));
        System.out.println(findAtLast(cameras, p)); // упс! вот здесь компиляция не проходит...
        System.out.println(findAtLast(products, cam));
        System.out.println(findAtLast(products, p));
        System.out.println(findAtLast(products, new Phone()));
        System.out.println(findAtLast(cameras, new Phone()));
    }
}
class Product {}
class Camera extends Product {}
class Phone extends Product {}