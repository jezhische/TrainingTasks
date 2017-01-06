package javaForTester.generics.generics3;

/**
 * Created by WORK_x64 on 05.01.2017.
 */
public abstract class Product <T extends Product<T>> implements Comparable <T>{
    // - это РЕКУРСИВНОЕ расширение типа
    double price;
    String s;
    @Override
    public int compareTo(Product o) {
        if (price < o.price)
            return -1;
        if (price > o.price)
            return 1;
        return 0;
    }
    // возможный вариант:
//    @Override
//    public int compareTo(T o) {
//        Product oo = o;
//        if (price < ((Product)o).price)
//            return -1;
//        if (price > oo.price)
//            return 1;
//        return 0;
//    } - но в этом случае уже нельзя будет в наследниках сравнить камеру с телефоном по цене

    public abstract boolean subCompare(T p); // - а вот здесь можно будет сравнить только камеру с камерой
    // или телефон с телефоном



    // Остальное неважно, просто забавы
    public void setPrice(double price) {
        this.price = price;
    }
    public void setS(String s) {
        this.s = s;
    }
    @Override
    public boolean equals (Object o) {
        if (o instanceof javaForTester.generics.generics3.Product) {
            Product product = (Product)o;
            return (price == product.price && s.equals(product.s));
        }
        return super.equals(o);
    }

    @Override
    public String toString() {
//        return super.toString();
        return getClass().getSimpleName();
    }

    // main применим, если убрать абстрактный метод subCompare(Product p) и абстрактный класс
    public static void main(String[] args) {
//        Product a = new Product();
//        Product b = new Product();
//        Product c = new Product();
//        a.price = 0.88;
//        b.price = 0.88;
//        c.price = 5.84;
//        a.s = "ku";
//        b.s = "ku";
//        c.s = "bubu";
//        System.out.println(a.compareTo(b));
//        System.out.println(a.compareTo(c));
//        System.out.println(a.equals(b));
//        System.out.println(a.equals(c));
//        System.out.println(a);
//
//        Camera cam = new Camera();
//        System.out.println(new Product().compareTo(cam));
//        Product d = new Product();
//        d.s = "";
////        d.price = 0;
//        cam.setS("");
////        cam.setPrice(0);
//        System.out.println(d.equals(cam));
//        System.out.println(cam instanceof Product);

    }
}
