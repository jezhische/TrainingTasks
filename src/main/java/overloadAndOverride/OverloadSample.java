package overloadAndOverride;

import java.util.Arrays;

public class OverloadSample {
    // "новый метод не обязан выполнять контракт перегружаемого метода" -
    // http://www.jdymora.com/%D0%BF%D1%80%D0%BE%D0%B3
    // %D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5/java/9-java-%D0%BF%D0%B5%D1%80%D0%B5%D0
    // %BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%BF%D0%B5%D1%80%D0%B5%D0%B3%D1%80%D1%83
    // %D0%B7%D0%BA%D0%B0-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4/

    public void print(String s) {
        System.out.println(s + ": String s");
    }
    // меняем количество аргументов:
    public void print(String... s) {
        System.out.println(Arrays.toString(s) + ": String... s");
    }
    // меняем тип и количество аргументов, модификатор доступа, тип связи (static), финализируем:
    private static final void print(String s, int i) {
        System.out.println(s + i + ": String s, int i");
    }
    // меняем порядок расположения и количество аргументов:
    public void print(int i, String... s) {
        System.out.println(i + Arrays.toString(s) + ": int i, String... s");
    }
    // меняем количество аргументов, бросаем Exception:
    void print(int i, String s) throws Exception {
        System.out.println(i + s + ": String s, int i");
    }

    //----------------------------------------------------------------------------------
    // меняем ТИП ВОЗВРАЩАЕМОГО ЗНАЧЕНИЯ, тип и количество аргументов:
    int print(String s, int... i) {
        System.out.println(s + Arrays.toString(i) + ": String s, int... i:");
        return i[0];
    }

    //----------------------------------------------------------------------------------


    public static void main(String[] args) {
        OverloadSample over = new OverloadSample();
        over.print("ho");
        over.print("ho", "ho");
        over.print("ho", 15);
        try {
            over.print(15, "ho");
        } catch (Exception e) {
            e.printStackTrace();
        }
        over.print(15, "ho", "ho");
        System.out.println(over.print("ho", 15, 25));
        OverloadSample.print("ho", 15);

    }

}
