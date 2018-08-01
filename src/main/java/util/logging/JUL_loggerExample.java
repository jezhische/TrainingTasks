package util.logging;

import java.io.Console;
import java.io.IOException;
import java.util.logging.*;

public class JUL_loggerExample {
    public static final Logger LOG = Logger.getLogger(JUL_loggerExample.class.getSimpleName());
    static {
// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
//      java.util.Formatter - Format String Syntax:
//todo:      %[argument_index$][flags][width][.precision]conversion
// https://docs.oracle.com/javase/7/docs/api/java/util/logging/SimpleFormatter.html
//      SimpleFormatter().format(LogRecord record) syntax template:
//todo:      String.format(format, date, source, defaultLevelLogger, level, message, thrown);
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] (%2$s) %5$s %6$s%n");
        LOG.setLevel(Level.FINEST);
//        Добавляем обработчик для записи в файл:
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("src/main/resources/JUL_loggers/aroundAdviceONLYAspectMessages.log", true);
        } catch (IOException e) {
            LOG.severe(e.getMessage());
        }
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getMessage().startsWith("ASPECT: ");
            }
        });
        LOG.addHandler(fileHandler);
//        Еще один обработчик:
        FileHandler fileHandler2 = null;
        try {
            fileHandler2 = new FileHandler("src/main/resources/JUL_loggers/aroundAdviceSEVEREAspectMessages.log", true);
        } catch (IOException e) {
            LOG.severe(e.getMessage());
        }
        fileHandler2.setFormatter(new SimpleFormatter());
        fileHandler2.setFilter(record -> record.getLevel().equals(Level.SEVERE));
        LOG.addHandler(fileHandler2);
//        И еще один:
        FileHandler fileHandler3 = null;
        try {
            fileHandler3 = new FileHandler("src/main/resources/JUL_loggers/aroundAdviceAspectALLMessages.log", true);
        } catch (IOException e) {
            LOG.severe(e.getMessage());
        }
        fileHandler3.setFormatter(new SimpleFormatter());
        LOG.addHandler(fileHandler3);
    }
}
// Использование логгера:
class LoggerUseProbe {
    public static void main(String[] args) {
        JUL_loggerExample.LOG.info("info logging");
        JUL_loggerExample.LOG.info("ASPECT: logging");
        JUL_loggerExample.LOG.severe("severe logging");
    }
}
