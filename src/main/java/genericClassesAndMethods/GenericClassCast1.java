package genericClassesAndMethods;

/**
 * Created by Ежище on 22.07.2016.
 */
public class GenericClassCast1<T> {
    private T fish;

    GenericClassCast1(T fish) {
        this.fish = fish;
    }

    public T getFish() {
        return fish;
    }
}

class InheritedGenericClass<T> extends GenericClassCast1<T> {
    private T bird;

    InheritedGenericClass(T bird) {
        super(bird);
    }
}

class Main {
    public static void main(String[] args) {
//        GenericClassCast1<String> shark = new GenericClassCast1<>("fish");
        InheritedGenericClass<String> blackbird = new InheritedGenericClass<>("this is bird");
        GenericClassCast1<String> shark = (GenericClassCast1<String>)blackbird;
        String s = (String)blackbird.getFish();
        System.out.println(s);
    }
}
