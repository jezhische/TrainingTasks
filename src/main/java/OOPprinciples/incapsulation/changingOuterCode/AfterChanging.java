package OOPprinciples.incapsulation.changingOuterCode;

public class AfterChanging implements Changeable {
    private String[] personId;

    public AfterChanging() {
        personId = new String[3];
    }

//    public AfterChanging(String prefix, String name, String surname) {
//        personId = new String[3];
//        personId[0] = prefix;
//    .......................
//    }


    public String getPrefix() {
        return personId[0];
    }

    public void setPrefix(String prefix) {
        personId[0] = prefix;
    }

    public String getName() {
        return personId[2];
    }

    public void setName(String name) {
        personId[2] = name;
    }

    public String getSurname() {
        return personId[1];
    }

    public void setSurname(String surname) {
        personId[1] = surname;
    }
}
