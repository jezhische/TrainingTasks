package util.logging.log4j2.xmlBasedMyProbes;


import org.apache.logging.log4j.Logger;

public class MessagePrinter {
    public static void performSomeTask(Logger logger){
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }
}
