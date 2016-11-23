package singleton;

/**
 * Created by Ежище on 23.11.2016.
 * http://info.javarush.ru/translation/2013/09/14/%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-Singleton-%D0%BE%D0%B4%D0%B8%D0%BD%D0%BE%D1%87%D0%BA%D0%B0-%D0%BD%D0%B0%D0%B8%D0%B1%D0%BE%D0%BB%D0%B5%D0%B5-%D1%80%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8-%D0%B2-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80%D0%B0%D1%85-.html
 * (Билл Пью)
 * Когда основной Singleton класс загружен, класс SingletonHelper еще не загружен в память, и только когда кто-то
 * вызовет метод getInstance, этот класс подгружается и создает экземпляр Singleton класса.
 * Т.о. всегда будет получен неизменный экземпляр синглтона без синхронизации. Самый простой и удобный метод.
 */
public class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }


}
