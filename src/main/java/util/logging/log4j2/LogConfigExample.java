package util.logging.log4j2;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//https://www.journaldev.com/7128/log4j2-example-tutorial-configuration-levels-appenders
public class LogConfigExample {
    public static void main( String[] args ) throws FileNotFoundException, IOException {

        // Get instance of configuration configurationFactory; your options are default ConfigurationFactory, XMLConfigurationFactory,
        // 	YamlConfigurationFactory & JsonConfigurationFactory
        ConfigurationFactory configurationFactory = XmlConfigurationFactory.getInstance();

        // Locate the source of this configuration, this located file is dummy file contains just an empty configuration Tag
        ConfigurationSource configurationSource = new ConfigurationSource(new FileInputStream(new File(
                "src/main/resources/log4j2/dummyConfiguration.xml")));

        // Get context instance
        LoggerContext context = new LoggerContext("JournalDevLoggerContext");

        // Get a reference from configuration
        Configuration configuration = configurationFactory.getConfiguration(context, configurationSource);

        // Create default console appender
        ConsoleAppender appender = ConsoleAppender.createDefaultAppenderForLayout(PatternLayout.createDefaultLayout());

        // Add console appender into configuration
        configuration.addAppender(appender);

        // Create loggerConfig
//        NB: additive = false
        LoggerConfig loggerConfig = new LoggerConfig("com", Level.FATAL,false);

        // Add appender
        loggerConfig.addAppender(appender,null,null);

        // Add defaultLevelLogger and associate it with loggerConfig instance
        configuration.addLogger("com", loggerConfig);
//
//        // Get context instance
//        LoggerContext context = new LoggerContext("JournalDevLoggerContext");

        // Start logging system
        context.start(configuration);

        // Get a reference for defaultLevelLogger
        Logger logger = context.getLogger("com");

        // LogEvent of DEBUG message
        logger.log(Level.FATAL, "Logger Name :: "+logger.getName()+" :: Passed Message ::");

        // LogEvent of Error message for Logger configured as FATAL
        logger.log(Level.ERROR, "Logger Name :: "+logger.getName()+" :: Not Passed Message ::");

        // LogEvent of ERROR message that would be handled by Root
        logger.getParent().log(Level.ERROR, logger.getName() + "Root Logger :: Passed Message As Root Is Configured For ERROR Level messages");

//        Поскольку логгер с именем com.journaldev не был создан, у нас этого логгера не будет, но поскольку в имени
// присутствует com, то аддитивно сообщение выводится через логгер с именем com (если установлено additive = true!):
        Logger nameWithComLogger = context.getLogger("com.journaldev");
        nameWithComLogger.log(Level.ERROR, logger.getName() + ": nameWithComLogger ERROR");
        nameWithComLogger.log(Level.FATAL, logger.getName() + ": nameWithComLogger FATAL");
        nameWithComLogger.getParent().log(Level.INFO, logger.getName() + ": nameWithComLogger parent log");
        nameWithComLogger.getParent().log(Level.FATAL, logger.getName() + ": nameWithComLogger parent log, level fatal");

//        а вот здесь выводим, по идее, сообщение аддитивно через корневой логгер, но непонятно, почему у него имя com:
        Logger abracadabra = context.getLogger(": abracadabra");
        abracadabra.log(Level.ERROR, logger.getName() + ": abracadabra ERROR");
        abracadabra.log(Level.FATAL, logger.getName() + ": abracadabra FATAL");
        abracadabra.getParent().log(Level.ERROR, logger.getName() + ": abracadabra parent ERROR");



    }
}
