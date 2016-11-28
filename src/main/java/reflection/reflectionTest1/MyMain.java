package reflection.reflectionTest1;

import java.lang.reflect.Field;

/**
 * Created by Ежище on 25.11.2016.
 * http://www.quizful.net/interview/java/access-modifiers
 */
public class MyMain {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException {

        A obj = new A();
        Class c = obj.getClass(); // можно и так: Class c = new A().getClass(); - главное - получить объект типа Class,
        // который "represents the runtime class of this object", а метод getClass() как раз его и возвращает.
        // TODO: а можно и так: Class<? extends A> c = obj.getClass(); - ошибки компиляции не будет, все работает,
        // см.фразу (2 строчки) из джава-документации в конце
        Field nameField = c.getDeclaredField("temp");
        nameField.setAccessible(true);
        int i = (Integer) nameField.getInt(obj);
        System.out.println(i);

        nameField = c.getDeclaredField("etern");
        nameField.setAccessible(true);
        System.out.println((Integer)nameField.getInt(obj));


        MyMain my = new MyMain();
        my.printClassName(my.n);
        String str = "something";
        my.printClassName(str);
        String nstr = "what?";
        if (str.getClass().equals(nstr.getClass()))
            System.out.println(true);
        else
            System.out.println(false);
        if (str.getClass().equals(String.class))
            System.out.println(true);
        else
            System.out.println(false);

        // пример записи:
        Number nnn = 0;
        Class<? extends Number> cl = nnn.getClass();
        System.out.println(cl);
        // можно и так:
        Integer as = 3; // но не int, и переменная д.б. инициализирована.
        // Почему? Определяется класс ИМЕННО ЧИСЛА 3, а не переменной as? getClass() можно вызвать только для образца
        // какого-либо класса, но не для класса, например: TODO: Class clla = Integer.getClass(); - не прокатывает,
        // "getClass() не-статический метод и на него нельзя ссылаться из статического содержания"
        Class<? extends Number> cll = as.getClass();
        System.out.println(cll);
        // вот исключения для String:
        Class<String> cla = String.class;
        System.out.println(cla);
        Class claa = String.class;
        System.out.println(claa);
        Class ccl = "jhhj".getClass();
        System.out.println(ccl);
//        Class clla = 5.getClass(); // а вот так - нет. Если писать просто 5 - это все равно что вызвать класс Integer,
//        // а не образец этого класса, если я правильно понимаю, а метод getClass() не-статический, во всяком случае,
//        об этом написано в сообщении об ошибке

    }
    Number n = 0;
    // использование методов Class:
    void printClassName(Object obj) {
        System.out.println("The class of " + obj +
                " is " + obj.getClass().getName());
    }
}
