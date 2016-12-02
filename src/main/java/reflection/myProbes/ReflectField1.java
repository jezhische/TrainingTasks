package reflection.myProbes;

import java.lang.reflect.Field;

/**
 * Created by Ежище on 26.11.2016.
 */
public class ReflectField1 {
    Origin1 origin1 = new Origin1();
    Class cl = origin1.getClass();

    public Integer getDeclaredInt(String name) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field field = cl.getDeclaredField(name);
        field.setAccessible(true);
        return (Integer) field.getInt(origin1);
    }
    // что-то пока непонятно, как получить String:
    public String getString(String name) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        Field field = cl.getDeclaredField(name);
        field.setAccessible(true);
        return field.toString();
    }



    public void setDeclaredInt(String name, int value) throws NoSuchFieldException, IllegalAccessException,
            IllegalArgumentException {
        Field field = cl.getDeclaredField(name);
        field.setAccessible(true);
//        field.setInt((Integer) field.getInt(origin1),value);
        field.setInt(getDeclaredInt(name),value); // что-то никак не получается...
    }

    public static void main(String[] args) {
        ReflectField1 reflectField1 = new ReflectField1();
        try {
            System.out.println(reflectField1.getDeclaredInt("a"));
//            System.out.println(reflectField1.getDeclaredInt("d"));
//            System.out.println(reflectField1.getDeclaredInt("aaaa"));
            System.out.println(reflectField1.getDeclaredInt("b"));
            System.out.println(reflectField1.getDeclaredInt("c"));
            System.out.println(reflectField1.getDeclaredInt("a"));
            System.out.println(reflectField1.origin1.d);

            reflectField1.setDeclaredInt("f", 55);
            System.out.println(reflectField1.getDeclaredInt("f"));

            System.out.println(reflectField1.getString("hor"));
            System.out.println(reflectField1.getString("a"));

        } catch (NoSuchFieldException e) {
            System.out.println("Field with such name is absent in the current instance: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Access denied: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The field with such argument cannot be reached with this method: " + e.getMessage());
        }
    }

}
