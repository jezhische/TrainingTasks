package singleton.newS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SingletonDiversity {
}
//https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#static-block-initialization
//todo: NB: все синглтоны можно объявлять final class, поскольку конструктор приватный, и класс невозможно унаследовать:
// http://www.javenue.info/post/2#singleton-example
//todo: когда instance синглтона первый раз создан, то покольку он static, обращение getInstance() будет возвращать тот же
//образец,, а не создавать новый
//----------------------------------------------------------------eager:
final class EagerInitializedSingleton {
// здесь образец создается 1 раз при загрузке класса, а потом только возвращается
    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();
    private EagerInitializedSingleton() {
    }
    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
//------------------------------------------------eager for exception handling:
class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    private StaticBlockSingleton() {}
    //static block initialization for exception handling
    static {
        try {
            instance  = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
//-------------------------------------------------------lazy initialization:
class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    private LazyInitializedSingleton() {}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) instance = new LazyInitializedSingleton();
        return instance;
    }
}
//---------------------------------------------------------thread safe - чтобы не создать несколько экземпляров класса
// Singleton в нескольких потоках, поскольку экземпляр д.б. только один.
// the same, but public static synchronized ThreadSafeSingleton getInstance(){...}
//----------------------------------------------------------thread safe with double checked locking:
class ThreadSafeSingleton {
// todo: NB volatile https://habrahabr.ru/post/129494/
    private static volatile ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }
}
//----------------------------------------------------------------Bill Pugh Singleton Implementation
class BillPughSingleton {
    private BillPughSingleton() {}
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
//----------------------------------------------------------------Using Reflection to destroy Singleton Pattern
class ReflectionSingletonTest {
    public static void main(String[] args) {
        BillPughSingleton instanceOne = BillPughSingleton.getInstance();
        BillPughSingleton instanceTwo = null;

        Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
        for (Constructor constructor: constructors) {
            constructor.setAccessible(true);
            try {
                instanceTwo = (BillPughSingleton) constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            break;
        }
        System.out.println(instanceOne);
        System.out.println(instanceTwo);
    }
}
//-----------------------------------------------------------Enum Singleton
enum EnumSingleton {
    INSTANCE;
    public static void doSomething(){
        //do something
    }
}
//--------------------------------------------------------Serialized Singleton
class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;
    private SerializedSingleton() {}
    private static class SingletonHelper {
        private static final SerializedSingleton INSTANCE = new SerializedSingleton();
    }
    public static SerializedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
//-----------------------------------------------------------practic example
// http://www.javenue.info/post/2#singleton-example - здесь гарантируется, что всякий раз, как я вызываю файл
// конфигурации, это будет тот же самый файл
class Configuration {
    private static Configuration _instance = null;

    private Properties props = null;

    private Configuration() {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                    new File("src/main/java/singleton/newS/props.txt"));
            props.load(fis);
        } catch (Exception e) {
            // обработайте ошибку чтения конфигурации
            System.out.println("Hey! Where is the text file?");
        }
    }

    public synchronized static Configuration getInstance() {
        if (_instance == null)
            _instance = new Configuration();
        return _instance;
    }

    // получить значение свойства по имени
    public synchronized String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
        else {
            // сообщите о том, что свойство не найдено
        }
        return value;
    }
}

//----------------------------Configuration implementation:
class ConfigImplement {
    public static void main(String[] args) {
        System.out.println(Configuration.getInstance().getProperty("ye"));
    }
}