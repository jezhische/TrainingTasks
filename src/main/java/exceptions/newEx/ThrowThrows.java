package exceptions.newEx;

public class ThrowThrows {
    public void t() { // не обязательно в сигнатуру метода вставлять throws, когда используешь throw, если есть catch
        try {
            throw new IllegalAccessException("ou");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void f() { // здесь throws не помечен, хотя exception не отловлено, потому что это RuntimeException
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("this is RTE, baby!");
        }
    }

    public static void main(String[] args) {
        new ThrowThrows().t();
        try {
            ThrowThrows.f();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        ThrowThrows.f();
    }

}
