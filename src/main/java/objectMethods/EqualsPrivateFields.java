package objectMethods;

import java.util.Objects;

/**
 * Created by Ежище on 17.06.2017.
 */
public class EqualsPrivateFields {
    private String name;
    private Integer number;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;

        EqualsPrivateFields that = (EqualsPrivateFields) o;

        if (name != null? !name.equals(that.name) : that.name != null) return false;
        return Objects.equals(number, that.number);
    }

    public static void main(String[] args) {
        EqualsPrivateFields ep = new EqualsPrivateFields();
        ep.setName("name");
        ep.setNumber(5);
        EqualsPrivateFields epp = new EqualsPrivateFields();
        epp.setName("name");
        epp.setNumber(5);

        System.out.println(ep.equals(epp));
    }
}
