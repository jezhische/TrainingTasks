package garbage.factorialFormally.auxilliary;

import garbage.factorialFormally.FactorialAlgorithm;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ежище on 03.01.2017.
 */
public class CachedFactorialImplementation implements FactorialAlgorithm {
    static HashMap<Integer,BigInteger> cache = new HashMap<Integer,BigInteger>();

    @Override
    public BigInteger factorial(int n) {
        BigInteger ret;

        if (n == 0) return BigInteger.ONE;
        if (null != (ret = cache.get(n))) return ret;
        ret = BigInteger.valueOf(n).multiply(factorial(n - 1));
        cache.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        CachedFactorialImplementation cfi = new CachedFactorialImplementation();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++)
            System.out.print(cfi.factorial(5) + " ");
        long end = System.currentTimeMillis();
        for (Map.Entry <Integer, BigInteger> entry: cache.entrySet())
            System.out.printf("\nn: %d, v: %d", entry.getKey(), entry.getValue());
        System.out.println("\nexecution time = " + (end - start));
    }
}
