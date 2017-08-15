package heapOfGarbage.exception;

/**
 * Created by Ежище on 31.12.2016.
 */
public class RecursiveFactorial {

    public long getFactorial(int number) {
        try {
        if (number == 0)
            return 1;
        else if (number < 0) {
                throw new NegativeArgumentException();
            }
            return number * getFactorial(number - 1);
        } catch (NegativeArgumentException e) {
            System.out.print(e.getMessage() + " : result is ");
        }
        return 0;
    }

    public static void main(String[] args) {
        RecursiveFactorial f = new RecursiveFactorial();
        System.out.println(f.getFactorial(0));
        System.out.println(f.getFactorial(1));
        System.out.println(f.getFactorial(10));
        System.out.println(f.getFactorial(-5));
        System.out.println(f.getFactorial(20));
        System.out.println(f.getFactorial(30));
    }
}
