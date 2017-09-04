package innerOuterClasses.newIOK;

public class StaticClassProbe {

    // в общем, пока не получилось
    public static  <T> T staticProbe() {
        return ((T) new Object()).getClass().equals(String.class)? (T) "hou": null;
        /*T t = new Function(){

            @Override
            public T apply(Object o) {
                return new T();
            }
        };*/

//        /*static abstract*/  class T { // локальный класс не может быть static, но может быть abstract
//            private int ou;
//
//            public T(int ou) {
//                this.ou = ou;
//            }
//            /*static*/ class Kobyshto extends T { // в данном случае inner classes cannot have static declaration (?)
//                Kobyshto() {
//                    super(ou);
//                }
//            }
//
//        }
//        T t = new T(5);
//        T.Kobyshto kob = new T(5).new Kobyshto();
    }

    public static void main(String[] args) {
        String s = staticProbe();
        System.out.println(s);
        System.out.println((String)staticProbe());
        System.out.println((Integer)staticProbe());
    }
}
