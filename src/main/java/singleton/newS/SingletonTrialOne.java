package singleton.newS;

public class SingletonTrialOne {
    private static final SingletonTrialOne INSTANCE = new SingletonTrialOne();
    private int number;

    private SingletonTrialOne() {}

    public static SingletonTrialOne getINSTANCE() {
        return INSTANCE;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
