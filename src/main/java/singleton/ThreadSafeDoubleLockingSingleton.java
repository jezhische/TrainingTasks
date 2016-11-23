package singleton;

/**
 * Created by Ежище on 23.11.2016.
 * http://info.javarush.ru/translation/2013/09/14/%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-Singleton-%D0%BE%D0%B4%D0%B8%D0%BD%D0%BE%D1%87%D0%BA%D0%B0-%D0%BD%D0%B0%D0%B8%D0%B1%D0%BE%D0%BB%D0%B5%D0%B5-%D1%80%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5-%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8-%D0%B2-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80%D0%B0%D1%85-.html
 * Дополнительная проверка для гарантии, что будет создан только один экземпляр класса Singleton.
 */
public class ThreadSafeDoubleLockingSingleton {

    private static ThreadSafeDoubleLockingSingleton instance;

    private ThreadSafeDoubleLockingSingleton(){}

    public static synchronized ThreadSafeDoubleLockingSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeDoubleLockingSingleton();
                }
            }
        }

        return instance;
    }

}
