package classClass.newC.privateConstrucnorTypeInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrivateCreator {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("classClass.newC.privateConstrucnorTypeInstance.PrivateConstructorType");
//            PrivateConstructorType priv = (PrivateConstructorType)c.newInstance(); // так не выйдет -
            // приватный конструктор в PrivateConstructorType
            Constructor stringConst = c.getDeclaredConstructor(String.class);
            stringConst.setAccessible(true);
            PrivateConstructorType priv = (PrivateConstructorType)stringConst.newInstance("Wow!");
            System.out.println(priv.getOu());
//            System.out.println(priv);

            Constructor emptyConst = c.getDeclaredConstructor();
            emptyConst.setAccessible(true);
            PrivateConstructorType privEmpty = (PrivateConstructorType) emptyConst.newInstance();
            System.out.println(privEmpty.getOu());
            System.out.println(priv);
            System.out.println(privEmpty);
//            System.out.println(priv);
//            System.out.println(privEmpty);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
