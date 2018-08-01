package util.logging.log4j2.fromApacheTutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Bar {
    static final Logger logger = LogManager.getLogger(Bar.class.getName());
    //  Создаем маркеры, которые затем будут использованы MarkerFilter:
    private static final Marker parentBarMarker = MarkerManager.getMarker("PBAR");

    public boolean doIt() {
        logger.traceEntry();
        logger.error(parentBarMarker,"Did it again! (from bar.doIt(): 'logger.error(...)')");
        return logger.traceExit(false);
    }
}
