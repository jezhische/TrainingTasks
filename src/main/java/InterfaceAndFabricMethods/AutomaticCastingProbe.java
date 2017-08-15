package InterfaceAndFabricMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 18.12.2016.
 */
public class AutomaticCastingProbe {
    List list = new ArrayList();
    {
        list.add(1, 9);
        list.add(1, 20);
        list.add(1, "ddd");
        list.add(1, "fff");
    }

    public static void main(String[] args) {
        AutomaticCastingProbe acp = new AutomaticCastingProbe();
//        int i = acp.list.get(2) + acp.list.get(3); // не прокатывает
    }
}
