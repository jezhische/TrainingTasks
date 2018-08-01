package util.logging.log4j2.xmlBasedMyProbes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogXmlBasedProbe {
//    Based on src/main/resources/log4j2.xml
//    https://howtodoinjava.com/log4j2/log4j-2-properties-file-configuration-example/
//    https://logging.apache.org/log4j/2.x/manual/configuration.html
//    https://logging.apache.org/log4j/2.x/manual/appenders.html

//    DefaultConfiguration:
//    - A ConsoleAppender attached to the root defaultLevelLogger.
//    - A PatternLayout set to the pattern "%d{HH:mm:ss.SSS} [%t] %-5level %defaultLevelLogger{36} - %msg%n" attached to the ConsoleAppender.
//    For example:      06:48:33.276 [main] ERROR util.logging.log4j2.xmlBasedMyProbes.LogXmlBasedProbe - This is an error message

//    There is no explicit configuration for this logger:
    private static final Logger defaultLevelLogger = LogManager.getLogger(MessagePrinter.class);

//    There is a configuration in config file for this logger with 'level="TRACE"':
    private static final Logger traceLogger = LogManager.getLogger(LogXmlBasedProbe.class);

//  Т.е. для удобства в каждом классе создаем логгер с именем класса, а в конфигурации помечаем, что этот логгер
//  логгирует на таком-то уровне, с такими-то аппендерами, фильтрами и т.д.

    public static void main(String[] args) {
        MessagePrinter.performSomeTask(defaultLevelLogger);
        defaultLevelLogger.fatal("-----------------------------------------------------------");
        MessagePrinter.performSomeTask(traceLogger);
        defaultLevelLogger.fatal("-----------------------------------------------------------");
    }
}
