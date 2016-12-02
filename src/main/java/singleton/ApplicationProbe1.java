package singleton;

/**
 * Created by Ежище on 02.12.2016.
 */
public class ApplicationProbe1 {
    public static void main(String[] args) {
//        EagerInitializedSingleton eager = new EagerInitializedSingleton(); // не прокатывает - здесь приватный конструктор
        EagerInitializedSingleton eager = EagerInitializedSingleton.getInstance();
    }
}
