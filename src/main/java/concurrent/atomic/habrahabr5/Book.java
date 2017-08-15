package concurrent.atomic.habrahabr5;

/**
 * Created by WORK on 29.11.2016.
 * https://habrahabr.ru/post/108016/
 */
public class Book {
        private String name;

    public Book() {}

    public Book( String name ) {
            this.name = name;
        }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
