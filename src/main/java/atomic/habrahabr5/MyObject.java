package atomic.habrahabr5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by WORK on 29.11.2016.
 * https://habrahabr.ru/post/108016/
 * @author shaines
 */
public class MyObject {
    private volatile Book whatImReading;

    private static final AtomicReferenceFieldUpdater<MyObject,Book> updater =
            AtomicReferenceFieldUpdater.newUpdater(MyObject.class, Book.class, "whatImReading");

    public Book getWhatImReading() {
        return whatImReading;
    }

    public void setWhatImReading( Book whatImReading ) {
        //this.whatImReading = whatImReading;
        updater.compareAndSet( this, this.whatImReading, whatImReading );
    }
}
