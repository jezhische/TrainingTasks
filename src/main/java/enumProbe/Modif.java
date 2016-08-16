package enumProbe;

/**
 * Created by WORK on 11.08.2016.
 */
public enum Modif {
    PUBLIC(1, "kjlk"), STATIC(2, "jk"), FINAL(3, "jkjkjkjkkk");

    protected int id;
    protected String name;

    Modif() {}

    Modif(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
//    public Modif getInstance() {
//        return this;
//    }

    public static void main(String[] args) {
        System.out.println(PUBLIC.getName());

    }
}
