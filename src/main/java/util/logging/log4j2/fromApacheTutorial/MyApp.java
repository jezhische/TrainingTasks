package util.logging.log4j2.fromApacheTutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;

import java.io.PrintStream;
import java.util.Arrays;

public class MyApp {
    // Define a static myAppLogger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger myAppLogger = LogManager.getLogger(MyApp.class);
    private static final Logger barChildLogger = LogManager.getLogger(Bar.class.getName() + ".child");

    private static final Logger rootLogger = LogManager.getRootLogger();

    public static void printLog4jDebugToFile() {
//        Programmatically add new Appender in log4j2:
//        https://stackoverflow.com/questions/37578164/programmatically-add-new-appender-in-log4j2
//        LoggerContext ctx = (LoggerContext)LogManager.getContext(true);
//        Configuration config = ctx.getConfiguration();
// недописано

        PrintStream old = System.out;
//        System.setOut(new PrintStream());
    }

    //  Создаем маркеры, которые затем будут использованы MarkerFilter (маркер PBAR создан в классе Bar):
    private static final Marker childBarMarker = MarkerManager.getMarker("ChBAR");

    public static void main(final String... args) {
//        System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY, "src/main/resources/log4j2forSystemSetProperties.xml");
//        System.setProperty("log4j.configurationFile","log4j2.properties");
//        Создаем системную переменную LOG4J_CONFIGURATION_FILE со значением
// C:\STORAGE\programming\my examples\aaa\TrainingTasks\src\main\resources\log4j2forSystemProperties.xml
//        myAppLogger.fatal(System.getProperty("log4j.configurationFile"));
//   Но почему-то не работает.Нужно смотреть механизм ServiceLoader в Java SE

//todo: -Dlog4j.configurationFile=src/main/resources/log4j2forSystemSetProperties.xml in the VM options - will be used
// appropriate config file.


        // Set up a simple configuration that logs on the console.
// NB: если логгер не определен в конфигурации, то он конфигурируется по умолчанию как корневой. То есть, если логгеры
// с именами MyApp.class (точнее, "util.logging.log4j2.fromApacheTutorial.MyApp")
// и Bar.class.getName() ("util.logging.log4j2.fromApacheTutorial.Bar")
// не прописаны в конфигурации, то по уолчанию они будут выдавать только сообщения уровня ERROR.

// Далее: по умолчанию, additivity = true. Поскольку в конфигурации для логгера с именем Bar указано
// "<AppenderRef ref="Console"/>", то он выдаст сообщение в консоль, а затем корневой логгер (его родитель) также
// выдаст в консоль сообщение, поскольку для корневого логгера также указан вывод в консоль. Таким образом, сообщение
// повторится дважды. Если убрать оба указания "<AppenderRef ref="Console"/>", то сообщение не будет выведено ни разу.
// Если добавить в какой-то логгер в цепочке 'additivity="false"', то на нем передача сообщений наверх прервется, и ни
// один логгер выше сообщение выводить не будет.

        myAppLogger.trace("Entering application (from MyApp.main()).");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            myAppLogger.error("Didn't do it ( !bar.doIt() return false, as return = \"return myAppLogger.exit(false))\".");
        }
        barChildLogger.info(childBarMarker,"barChildLogger speaks: info!");
        barChildLogger.error(childBarMarker,"barChildLogger speaks: error!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                myAppLogger.error(e + ": " + stackTraceElement);
            }
        }

        try {
            throw new NullPointerException("Exception is thrown");
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(msg ->  myAppLogger.error(e + ": " + msg));
        }

        myAppLogger.trace("Exiting application (from MyApp.main() if ).");
    }
}
