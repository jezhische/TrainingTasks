package immutability.breakingOfEncapsulation.garbage;

public class ImmRefProbe {
    public static void main(String[] args) {
        String s = "hhh";
        String a = s;
        System.out.printf("s = %s, a = %s\n", s, a);
        s = "orrr";
//        a = "gurr";
        System.out.printf("s = %s, a = %s\n", s, a);

        O gyrr = new O("gyrr");
        O murr = new O("murr");
        gyrr = murr;
        System.out.printf("gyrr = %s, murr = %s\n", gyrr.name, murr.name);
        murr.name = "ouhh";
        System.out.printf("gyrr = %s, murr = %s\n", gyrr.name, murr.name);

        // immutable class Ho:
//        Ho hnyrr = new Ho("hnyrr"); // не выйдет - private конструктор
        Ho hnyrr = Ho.getInstance("hnyrr");
        Ho hmurr = Ho.getInstance("hmurr");
        hnyrr = hmurr;
        System.out.printf("hnyrr = %s, hmurr = %s\n", hnyrr.getName(), hmurr.getName());
        hnyrr = hnyrr.updateName("oyuyu");
        System.out.printf("hnyrr = %s, hmurr = %s\n", hnyrr.getName(), hmurr.getName());

        final int u = 6;
//        u = 8; // не выйдет
        final O uh =new O("bbb");
//        uh = new O("guh"); // тоже не выйдет
        uh.name = "brra!"; // а вот так - пожалуйста
        System.out.println(uh.name);

        // поэтому можно вот так:
        final Ho ha = Ho.getInstance("bytry");
        final Ho hi = Ho.getInstance("bytry");
        System.out.println("ha: " + ha + "; hi: " + hi);
        System.out.println("ha.equals(hi): " + ha.equals(hi));
//        ha = Ho.getInstance("drrg"); // так нельзя из-за final
        String newName = ha.getName();
        newName = "ghj"; // так можно, но без толку, поскольку name - это String и immutable
//        ha.o = new O("grrdj"); // так нельзя из-за final
        ha.o.name = "bordjjo!"; // а вот так - можно!
        System.out.println("ha: " + ha + "; hi: " + hi);
        System.out.println("ha.equals(hi): " + ha.equals(hi));
    }
}
class O {
    protected String name;

    public O(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass() || o == null) return false;
        O that = (O) o;
        return name != null? name.equals(that.name): that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null? name.hashCode(): 0;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Ho {

    private final String name;
    final O o = new O("gug");

    private Ho(String name) {
        this.name = name;
    }

    public static Ho getInstance(String name) {
        return new Ho(name);
    }

    public Ho updateName(String newName) {
        return new Ho(newName);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;

        Ho ho = (Ho) o1;

        if (name != null ? !name.equals(ho.name) : ho.name != null) return false;
        return o != null ? o.equals(ho.o) : ho.o == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (o != null ? o.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", o=" + o;
    }
}