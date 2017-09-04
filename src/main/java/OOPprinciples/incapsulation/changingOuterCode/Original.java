package OOPprinciples.incapsulation.changingOuterCode;

public class Original implements Changeable {
    private String prefix, name, Surname;

    public Original() {
    }

//    public Original(String prefix, String name, String surname) {
//        this.prefix = prefix;
//        this.name = name;
//        Surname = surname;
//    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
