package io.streamRedirect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleOutputCapturerMain {
    public static void main(String[] args) {
//         просто несколько проб
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(106);
        baos.write(105);
        System.out.println(baos);
        PrintStream printStream = new PrintStream(baos);
        printStream.write(107);
        System.out.println(baos);
        System.out.println("-------------------------------------------------");

        System.out.println(System.console());
        System.out.println("-------------------------------------------------");

        Logger rootLogger = LogManager.getRootLogger();
        ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();
        capturer.start();
        System.out.println("zhozho");
        rootLogger.error("rootLogger giving error message!");
        System.out.println(capturer.stop());
        System.out.println("gugu");

        System.out.println(System.console());

        System.out.println("-----------------------------------------------------");

    }
}
