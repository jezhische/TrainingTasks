package objectMethods;

import java.awt.*;

/**
 * Created by WORK_x64 on 24.12.2016.
 */
public class EqualsMethod {
    boolean equalsToObj (Object obj1, Object obj2) {
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        Point p1=new Point(2,3);
        Point p2=new Point(2,3);
        System.out.println(p1.equals(p2)); // идет сравнение по значению, а не по ссылке, поскольку equals
        // переопределен в классе Point:
//        public boolean equals(Object obj) {
//            if (obj instanceof Point) { // если сравниваемые объекты - instanceof Point, то они
//          // сравниваются по координатам
//                Point pt = (Point)obj;
//                return (x == pt.x) && (y == pt.y);
//            }
//            return super.equals(obj);
//        } // если сравниваемые объекты - не instanceof Point, то идет перенаправление в суперкласс Point2D, а там -
//          // в суперкласс Object.
        System.out.println(p1 == p2); // а вот это сравнение по ссылке, а ссылки разные
        // А вот если попробовать воспользоваться методом equals из класса Object, то также сравнение по значению?:
        System.out.println(new EqualsMethod().equalsToObj(p1, p2));
        // А если то же самое, но с другого бока - через обращение к супер-методу в переопределении equals в Point:
        System.out.println((Object)p1.equals(p2)); // упс! а так:
        System.out.println((Object)p1.equals((Object)p2));
        // надо это дело исследовать:
        System.out.println((Object)p1.getClass().toString());
    }
}
