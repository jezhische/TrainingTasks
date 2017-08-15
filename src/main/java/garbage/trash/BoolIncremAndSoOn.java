package garbage.trash;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ежище on 19.02.2017.
 */
public class BoolIncremAndSoOn {
//    public int a = 0;
    public boolean postfix(int a) {return a++ == a++;} // метод только для теста в пакете test
    public static void main(String[] args) {
        int a = 0;
        /* (todo:) Although both var++ and ++var increment the variable they are applied to,
        (todo:) the result returned by var++ is the value of the variable before incrementing,
        (todo:) whereas the result returned by ++var is the value of the variable after the increment is applied.
        (http://stackoverflow.com/questions/6175316/the-difference-between-var-and-var)**/
        System.out.println((a++ == a++) + ", " + a); // false, 2 :здесь 0 == 1, т.е. результат левой части выражения
        // равен 0 (a = 0), затем происходит инкрементирование и a становится 1, результат правой части равен 1,
        // и только затем происходит инкрементирование до a = 2
        System.out.println((++a == a++) + ", " + a); // true, 4 (3 == 3)
        System.out.println((++a == ++a) + ", " + a); // false, 6 (5 == 6)
    }
    int a = 0;
    @Test
    public void simpleIncrem() {
        Assert.assertFalse(a++ == a++);
        boolean b = a++ == a++;
        Assert.assertTrue(a == 4 && !b);
    }
}
