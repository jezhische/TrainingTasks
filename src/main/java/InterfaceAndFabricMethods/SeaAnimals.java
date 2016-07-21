package InterfaceAndFabricMethods;

/**
 * Created by uaTex_32 on 20.07.2016.
 */
public interface SeaAnimals {
    void printVictim(String victim);
//    {
//        System.out.printf("А я %s съел", victim);
//    }
    static String printCondition() {
        return "\nИ все довольны.\n";
    }
}
