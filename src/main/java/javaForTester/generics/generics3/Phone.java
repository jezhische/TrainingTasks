package javaForTester.generics.generics3;

/**
 * Created by WORK_x64 on 05.01.2017.
 */
public class Phone extends Product<Phone> {
    public String model;
    Phone () {} // компилятор не требует создания пустого конструктора, даже если есть только конструктор Phone (String model)
    // хотя в классе-родителе имеется только пустой конструктор. Почему?
    Phone (String model) {this.model = model;}
    @Override
    public boolean subCompare(Phone p) {
        if (p != null)
            return model.compareTo(p.model) > 0;
        return false;
    }

    public static void main(String[] args) {
        Phone zoo = new Phone("Zoo");
        Phone nokia = new Phone("Nokia");
        System.out.println(zoo.subCompare(nokia));
        String s = "Z";
        System.out.println(Character.getNumericValue(s.charAt(0)));
        s = "N";
        System.out.println(Character.getNumericValue(s.charAt(0)));

        Camera nikon = new Camera();
        Camera fuji = new Camera();
        nokia.setPrice(12.8); nikon.setPrice(25); fuji.setPrice(79.18);
        System.out.println(nikon.compareTo(nokia));
    }
}
