package trainingTest.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 21.06.2016.
 */
public class CatchSimpleException {
    //    public void printEx()
    public static void main(String[] args) {
//    try {
//        ThrowSimpleException exc = new ThrowSimpleException();
//       String answer = exc.helloMessage(null);
//    }

        List<String> list = new ArrayList<>();
        list.add(0, "nya");
        list.add(1, null);
        list.add(2, "bdr");
        try {
            ThrowSimpleException tSE = new ThrowSimpleException();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(tSE.helloMessage(list.get(i)));
            }
        }
        catch (SimpleException e) {
            System.out.println(e.getMessage());
        }
                try {
            int i = 1 / 0;
            String ex = String.valueOf(i);
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("error in ex: " + ex.getMessage());
        }

    }
}
