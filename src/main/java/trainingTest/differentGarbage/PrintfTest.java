package trainingTest.differentGarbage;

/**
 * Created by Ежище on 05.07.2016.
 */
public class PrintfTest {
    static String name = "War and Peace";
    static String author = "Толстой";
    static int year = 1870;

    static public void Info () {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году \n", name, author, year);
    }
    public static void main(String[] args) {
        PrintfTest.Info();
    }

}
