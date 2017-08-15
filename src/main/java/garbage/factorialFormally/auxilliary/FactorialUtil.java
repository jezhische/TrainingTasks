package garbage.factorialFormally.auxilliary;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Ежище on 01.01.2017.
 * https://habrahabr.ru/post/113128/
 */
public class FactorialUtil {
    static HashMap<Integer,BigInteger> cache = new HashMap<Integer,BigInteger>();

    public static BigInteger factorial(int n)
    {
        BigInteger ret;

        if (n == 0) return BigInteger.ONE;
//        if (null != (ret = cache.get(n))) return ret;
        ret = BigInteger.valueOf(n).multiply(factorial(n-1));
//        cache.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

}
