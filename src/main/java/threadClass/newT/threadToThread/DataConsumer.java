package threadClass.newT.threadToThread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataConsumer implements Runnable {
    private final DataProvider dataProvider;
    private final List<String> idList;
    public static final Logger log = LogManager.getLogger();

    public DataConsumer(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        idList = new ArrayList<>();
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public List<String> getIdList() {
        return idList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(990);
            } catch (InterruptedException e) {
                return;
            }
            idList.add(dataProvider.getUserId());
            log.error(dataProvider.getUserId());
        }
    }
}
