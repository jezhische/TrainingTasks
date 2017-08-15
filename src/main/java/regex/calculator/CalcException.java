package regex.calculator;

/**
 * Created by WORK_x64 on 02.02.2017.
 */
public class CalcException extends Exception {
    CalcException(String message) {
        super(message);
    }
    CalcException(String message, Throwable cause) {
        super(message, cause);
    }
}
