package InterfaceAndFabricMethods.parametricDriver;

/**
 * Created by Ежище on 18.12.2016.
 */
public class ParametricDriver<T> implements Driverable {
    T data;
    ParametricDriver (T data) {
        this.data = data;
    }

    @Override
    public <T> T drive(T t) {
//        if (t.getClass().equals(String.class))
//        return (String)t+(String)t;
        return null;
    }
}
