package OOPprinciples.incapsulation.changingOuterCode;

public class Main {
    static Changeable setPersonId(Changeable person, String prefix, String surname, String name) {
        person.setPrefix(prefix);
        person.setSurname(surname);
        person.setName(name);
        return person;
    }
    public static void main(String[] args) {
        Changeable original = Main.setPersonId(new Original(), "Mr.", "Smith", "John");
        Changeable afterChanging = Main.setPersonId(new AfterChanging(), "Ms.", "Smith", "Diana");
        original.printInfo();
        afterChanging.printInfo();
        System.out.println();
        original.printPerson();
        afterChanging.printPerson();

    }
}
