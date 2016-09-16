package InterfaceAndFabricMethods;

/**
 * Created by WORK on 16.09.2016.
 */
public interface Inter {
    static int plus(int a, int b){
        return a + b;
    }
    int minus(int a, int b);
    int A = 10;
    int B = 15;

    void print(String s);
}
