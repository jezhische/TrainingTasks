package javaFromTkach.collections.map_2;

import garbage.trash.enumProbes.Unit;

import java.io.PrintStream;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import static javaFromTkach.collections.map_2.EnumMapInstance.Unit.*;

/**
 * Created by Ежище on 08.01.2017.
 */
public class EnumMapInstance {
    // ключи - элементы enumProbes, а значения хранятся в массиве.
    enum Mapable {
        KILOMETER, METER,  // объекты класса Mapable, доступные статически, фактически синглтоны
        // - это объекты, образованные с помощью пустого конструктора по умолчанию, фактически KILOMETER() или, более
        // развернуто: Mapable KILOMETER = new Mapable () (хотя такую форму записи компилятор не позволяет), например:
        MILLIMETER();
    }
    enum simpleUnit {
        KILOMETER(1e3),
        METER(1),
        MILLIMETER(1e-3);
        simpleUnit() {}
        double length;
        simpleUnit (double length) {this.length = length;}
    }
//    simpleUnit si = new simpleUnit(); // Enum types cannot be instantiated  - т.е. получить образец класса enumProbes или
//     //его потомка simpleUnit напрямую невозможно, можно только воспользоваться готовыми образцами, уже созданными в
//     //классе.
    public static void printAll (PrintStream out) {
        for (simpleUnit u1 : simpleUnit.values()) {
            for (simpleUnit u2 : simpleUnit.values()) {
            out.println(String.format("There are %.3f %sS in one %s",u2.length/u1.length, u1, u2));}
        }
    }

    enum Unit {
        METER {public double getLength() {return 1;}},
        KILOMETER {public double getLength() {return 1e3;}}, // получаем существующие в единственном экземпляре (подобно
        // singleton) экземпляры вложенных классов Units.KILOMETER и т.д.
        MILLIMETER {public double getLength() {return 1e-3;}};
        abstract double getLength();
    }

    static EnumMap<Unit, String> stringEnumMap = new EnumMap<>(Unit.class);


    public static void main(String[] args) {
//        System.out.println(Mapable.class.getSuperclass());
//        double a = 1e-3;System.out.println(a);
//        System.out.print(Mapable.KILOMETER + "; ");
//        System.out.println(Mapable.KILOMETER.getClass());
//        System.out.println(Unit.class + ":::" + Unit.class.getSuperclass() + ":::" + Unit.KILOMETER.getClass() +
//        "\n:::" + Unit.KILOMETER.getClass().getSuperclass() + ":::" + Unit.KILOMETER.getClass().getSuperclass().
//                getSuperclass());
//        System.out.println(simpleUnit.KILOMETER.length);
//
//        printAll(System.out);

        stringEnumMap.put(Unit.values()[0], METER.toString()); // короткая запись благодаря тому, что я сделал
        // import static javaFromTkach.collections.map_2.EnumMapInstance.Unit.*;
        System.out.println("stringEnumMap.containsKey(METER): " + stringEnumMap.containsKey(METER));
        System.out.println("stringEnumMap: " + stringEnumMap);
        System.out.println("stringEnumMap.get(Unit.values()[0]): " + stringEnumMap.get(Unit.values()[0]));
        System.out.println("stringEnumMap.get(Unit.values()[1]): " + stringEnumMap.get(Unit.values()[1]));

        System.out.println();
        Set<Map.Entry<Unit, String>> entries = stringEnumMap.entrySet();
        for (Map.Entry<Unit, String> entry: entries) {
            System.out.println(String.format("key = %s, value = %s", entry.getKey(), entry.getValue()));
            entry.setValue("shifted");
            System.out.println(String.format("key = %s, value = %s", entry.getKey(), entry.getValue()));
        }

        stringEnumMap.put(Unit.values()[2], MILLIMETER.toString());
        System.out.println();
        for (Map.Entry<Unit, String> entry: entries) {
            System.out.println(String.format("key = %s, value = %s", entry.getKey(), entry.getValue()));
        }

    }
}
