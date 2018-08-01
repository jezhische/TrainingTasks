package threadClass.newT.threadToThread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadToThread {
// Задача: получить в один поток данные из другого потока
// https://ru.stackoverflow.com/questions/417868/%D0%9A%D0%B0%D0%BA-%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D1
// %80%D0%B5%D0%B7%D1%83%D0%BB%D1%8C%D1%82%D0%B0%D1%82-%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D0%BE%D0%B9-%D0
// %B8%D0%B7-%D0%B4%D1%80%D1%83%D0%B3%D0%BE%D0%B3%D0%BE-%D0%BF%D0%BE%D1%82%D0%BE%D0%BA%D0%B0
    public static void main(String[] args) throws InterruptedException {
        DataProvider dataProvider = new DataProvider();
        DataConsumer dataConsumer = new DataConsumer(dataProvider);
        Logger log = LogManager.getLogger(DataConsumer.class);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(dataProvider);
        executor.execute(dataConsumer);
// Если этой строчки нет, то я получу что-нибудь вроде ...threadClass.newT.threadToThread.DataConsumer: null... и т.д.
// Это произойдет потому, что main выполнит команду executor.shutdownNow() раньше, чем успеют отработать запущенные
// потоки. С другой стороны, если я использую executor.shutdown(), то executor будет выполнять потоки до тех пор, пока
// они полностью не отработают, а они не отработают никогда, поскольку у них в методе run() записано while(true){...}
// Так что выход - усыпить на какое-то время main, а потом насильно закрыть потоки с помощью executor.shutdownNow().
        Thread.sleep(4000);
        executor.shutdownNow();
        log.fatal(dataConsumer.getDataProvider().getUserId());
        log.error(dataProvider.getUserId());
        log.fatal(dataConsumer.getIdList());
    }
}
