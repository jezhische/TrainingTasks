package OOPprinciples.incapsulation.changingOuterCode;

import java.lang.reflect.Field;

public interface Changeable {
    default void printInfo() {
        Class clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder personId = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                personId.append(field.getName() + ": " + field.get(this) + ";  ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(personId.toString());
    }

    default void printPerson() {
        System.out.println(this.getPrefix() + " " + this.getSurname() + " " + this.getName());
    }

    void setPrefix(String prefix);
    void setSurname(String surname);
    void setName(String name);
    String getPrefix();
    String getSurname();
    String getName();
}
