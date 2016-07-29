package logging;

import java.util.logging.Logger;

/**
 * Created by uaTex_32 on 29.07.2016.
 */
public class SomeClass {
    // https://habrahabr.ru/post/130195/
    private static Logger log = Logger.getLogger(SomeClass.class.getName());

    public void someMethod()
    {
        log.info("Some message");
    }
}
