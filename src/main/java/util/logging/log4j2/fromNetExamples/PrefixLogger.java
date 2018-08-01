package util.logging.log4j2.fromNetExamples;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class PrefixLogger extends ExtendedLoggerWrapper {

//    https://www.programcreek.com/java-api-examples/index.php?api=org.apache.logging.log4j.Marker
//    https://www.programcreek.com/java-api-examples/?code=justor/elasticsearch_my/elasticsearch_my-master/core/src/main/java/org/elasticsearch/common/logging/PrefixLogger.java

    // we can not use the built-in Marker tracking (MarkerManager) because the MarkerManager holds
    // a permanent reference to the marker; however, we have transient markers from index-level and
    // shard-level components so this would effectively be a memory leak
    private static final WeakHashMap<String, WeakReference<Marker>> markers = new WeakHashMap<>();

    private final Marker marker;

    public String prefix() {
        return marker.getName();
    }

    PrefixLogger(final ExtendedLogger logger, final String name, final String prefix) {
        super(logger, name, null);

        final String actualPrefix = (prefix == null ? "" : prefix).intern();
        final Marker actualMarker;
        // markers is not thread-safe, so we synchronize access
        synchronized (markers) {
            final WeakReference<Marker> marker = markers.get(actualPrefix);
            final Marker maybeMarker = marker == null ? null : marker.get();
            if (maybeMarker == null) {
                actualMarker = new MarkerManager.Log4jMarker(actualPrefix);
                markers.put(actualPrefix, new WeakReference<>(actualMarker));
            } else {
                actualMarker = maybeMarker;
            }
        }
        this.marker = actualMarker;
    }

    @Override
    public void logMessage(final String fqcn, final Level level, final Marker marker, final Message message, final Throwable t) {
        assert marker == null;
        super.logMessage(fqcn, level, this.marker, message, t);
    }
}
