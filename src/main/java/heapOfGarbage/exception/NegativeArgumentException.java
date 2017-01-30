package heapOfGarbage.exception;

/**
 * Created by Ежище on 31.12.2016.
 */
public class NegativeArgumentException extends Exception {
    NegativeArgumentException (){
        super ("Factorial can not be calculated for negative numbers");
    }
}
