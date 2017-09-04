package innerOuterClasses.newIOK;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * http://www.javenue.info/post/7
 */
public class Anonimous {
    public static void main(String[] args) {
        Runnable staticAnonym = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t\t" + "staticAnonym\t\t" + this.getClass().toGenericString()); // выполнение метода покажет, что это static class!
            }
        };
        new Thread(staticAnonym).start();
        // еще один экземпляр анонимного класса. Такое создание возможно потому, что класс объявлен в статическом блоке
        // (main(...), следовательно, класс СТАТИЧЕСКИЙ. Нестатический класс создан ниже):
        Runnable staticAnonym2 = null;
        try {
            staticAnonym2 = staticAnonym.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        new Thread(staticAnonym2).start();
        System.out.println("имя анонимного класса staticAnonym: " + staticAnonym.getClass().getName()); // но
        // getSimpleName() ничего не выведет

        // просто проверка, ясно показывающая, что Anonimous$2 - это ИМЯ анонимного класса (forName()):
        try {
            System.out.println("разные методы получения объекта Class: "
                    + Class.forName("innerOuterClasses.newIOK.Anonimous$2").equals(new Anonimous().anonym.getClass()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("список конструкторов класса staticAnonym: " + Arrays.toString(staticAnonym.getClass()
                .getDeclaredConstructors())); // только 1 пустой конструктори

        // обращение к нестатическому анонимному классу:
        new Thread(new Anonimous().anonym).start();
        // и создаем копию этого класса:
        new Thread(new Anonimous().nonStaticMethod()).start();
    }

    // Создание нестатического экземпляра класса в теле класса или в нестатическом методе:
    private Runnable anonym = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "\t\t" + "non-static anonym\t\t"
                    + this.getClass().toGenericString());
        }
    };

    // создание второго экземпляра класса anonym - необходимо передать в его конструктор ссылку на ОБРАМЛЯЮЩИЙ класс,
    // чтобы не получить InstantiationException. new Runnable () имеет пустой конструктор, но в него д.б. передана
    // ссылка на объект обрамляющего класса:
    public Runnable nonStaticMethod() {
        Constructor[] constructors = anonym.getClass().getDeclaredConstructors();
        // массив параметров для загрузки в аргументы конструктора - хотя вообще-то там vararg, и можно было просто
        // передать туда аргументы через запятую, или так: return (Runnable) constructors[0].newInstance(this);:
        Object[] params = new Object[1];
        params[0] = this;
        try {
            return (Runnable) constructors[0].newInstance(params);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
