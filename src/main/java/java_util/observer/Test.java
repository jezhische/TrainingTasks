package java_util.observer;

public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        Test test = new Test();
        TestObservable to = new TestObservable("Observable");
        TestObserver o1 = new TestObserver("Observer 1");
        TestObserver o2 = new TestObserver("Observer 2");
        to.addObserver(o1);
        to.addObserver(o2);
        to.modify();
        to.notifyObservers("Notify argument");
    }
}
