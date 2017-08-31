package java_util.observer;

import java.util.Observable;

/** An observable object can have one or more observers.
 * An observer may be any object that implements interface Observer. */
public class TestObservable extends Observable {
    private String name = "";
    public TestObservable(String name) {
        this.name = name;
    }

    public void modify() {
        setChanged();
    }

    public String getName() {
        return name;
    }

}
