package static__.staticImport;

import static static__.staticImport.StaticResource.INT;
// NB: 
import static static__.staticImport.StaticResource.message;
import static static__.staticImport.StaticResource.string;

/**
 * Created by Ежище on 17.04.2017.
 */
public class StaticImport {
    public static void main(String[] args) {
        string = String.format("calculation result with INT = %d", INT);
        System.out.print(string);
        System.out.println(message(6));
    }
}
