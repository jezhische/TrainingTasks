package singleton.newS;

public class TryToUseSingletgoneOne {
    public static void main(String[] args) {
        SingletonOne one = SingletonOne.getInstance();
        SingletonOne.Zu zu = one.getZu();
        System.out.println(zu.getName());
        zu.setName("zuza");
        System.out.println(zu.getName());
        SingletonOne two = SingletonOne.getInstance();
        SingletonOne.Zu zuu = two.getZu();
        System.out.println(zuu.getName());
        zuu.setName("shrink!");
        System.out.println(zu.getName());
        System.out.println(one.getZu().getName());
    }
}
//------------------------------------
class SingletonOne {
//    private static SingletonOne instance;
    private SingletonOne() {}
    private static class SBuilder {
        private static final SingletonOne INSTANCE = new SingletonOne();
    }
    public static SingletonOne getInstance() {
        return SBuilder.INSTANCE;
    }
    public interface Zu {
        String getName();
        void setName(String name);
    }
//    private final Zu zu = new Zu() {
//        private String name;
//        @Override
//        public String getName() {
//            return name;
//        }
//        @Override
//        public void setName(String name) {
//            this.name = name;
//        }
//    };
//
//    public Zu getZu() {
//        return zu;
//    }
        private Zu zu;
    public Zu getZu() {
        if (zu == null) {
            zu = new Zu() {
        String name;
        @Override
        public String getName() {
            return name;
        }
        @Override
        public void setName(String name) {
            this.name = name;
        }
    };
        }
        return zu;
    }
}