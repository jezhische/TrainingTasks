package InterfaceAndFabricMethods;

/**
 * Created by WORK on 16.09.2016.
 */
public interface Inter {

    interface K { // static!!! по умолчанию для inner interface, неважно, где он создается - в интерфейсе или классе
        static void print() {System.out.println("");}
        int go();
    }
    int minus(int a, int b);// public abstract по умолчанию
    int A = 10; // public static final по умолчанию
    int B = 15; // public static final по умолчанию
    void print(String s); // public abstract по умолчанию

    static int plus(int a, int b){
        return a + b;
    } // public по умолчанию
    default int plus(int a) {return a + a;} // public по умолчанию
}
