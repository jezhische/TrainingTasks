package static__.staticImport;

/**
 * Created by Ежище on 17.04.2017.
 */
public class StaticResource {
    public static String string;
    public static final int INT = 25;

    public static String message(int other) {
        return string + String.valueOf(other + INT);
    }
}
