package io.IOStream.newProbes.serialization;


import java.io.Serializable;

public class ForTest implements Serializable {
    // либо суперкласс этого класса должене имплементировать Serializable, либо
    // у суперкласса д.б. доступный конструктор без параметров (а не у самого сериализуемого класса), и с помощью
    // этого конструктора и происходит сериализация http://www.intuit.ru/studies/courses/16/16/lecture/27133?page=3
    // В данном случае, видимо, суперкласс - это Object
    public ForTest(int q) {
        this.q = q;
    }

    private int r = 25, q;
    private String string;

    public Integer ret(Integer i) {
        return i * 10;
    }

    public int exceptionCheck(String notNull) {
        try {
            return 1 / Integer.valueOf(notNull) + 1;
        } catch (NumberFormatException /*| ArithmeticException*/ e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());

        } /*catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }*/
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ForTest that = (ForTest) obj;
        if (r != that.r) return false;
        if (string != null ? !string.equals(that.string) : that.string != null) return false;
        return q == that.q;
    }

    @Override
    public int hashCode() {
        int result = r;
        result = 31 * result + q;
        result = 31 * result + (string != null? string.hashCode() : 0);
        return result;
    }
}
