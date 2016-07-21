package InterfaceAndFabricMethods;

/**
 * Created by uaTex_32 on 20.07.2016.
 */
public class ObjectInheritanceProbe {
//    Object karas = new Fish();
//    Object duza = new Medusa();

    public void getName(Object object) {
        if (object instanceof Fish) {
            System.out.println("Это рыба!");
        } else if (object instanceof Medusa) {
            System.out.println("Это птица!");
        } else
            System.out.println("Это хрень какая-то!");
    }

    public static void main(String[] args) {
        Fish karas = new Fish(new Medusa(), 5);
        Medusa duza = new Medusa();
        ObjectInheritanceProbe obj = new ObjectInheritanceProbe();
        obj.getName(karas);
        obj.getName(new Medusa());
        obj.getName(new Object());

        SeaAnimals slise = new Medusa();
        SeaAnimals shark = new Fish(duza, 1);
        shark.printVictim("собачку");
        System.out.println("");
        slise.printVictim("кошечку");

        System.out.println(SeaAnimals.printCondition());

    }

}

class Fish implements SeaAnimals {
    @Override
    public void printVictim(String victim) {
        System.out.printf("Я рыба, я %s съел!", victim);
    }

    Fish(Medusa medusa, int number) {
    }

    Fish fish() {
        return this;
    }
}

class Medusa implements SeaAnimals {
    @Override
    public void printVictim(String victim) {
        System.out.printf("А я медуза, я %s съела!", victim);

    }
    Medusa madusa() {
        return this;
    }
}
