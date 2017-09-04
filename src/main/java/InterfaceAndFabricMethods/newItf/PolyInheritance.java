package InterfaceAndFabricMethods.newItf;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class PolyInheritance implements Function, Consumer {


    @Override
    public void accept(Object o) {

    }

    @Override
    public Object apply(Object o) {
        return null;
    }

    public interface Case extends Function, Consumer {} // а вот и множественное наследование
}
