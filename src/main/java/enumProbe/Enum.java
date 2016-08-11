package enumProbe;

/**
 * Created by WORK on 11.08.2016.
 */
public abstract class Enum {
    protected int id;
    protected String name;

    protected Enum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Enum)) return false;
        final Enum enumer = (Enum) o;
        return (id == enumer.id);
    }

    public int hashCode() {
        return id;
    }

    public String toString() {
        return getClass().getName() + "[id=" + id
                + ", name=" + name + "]";
    }

    protected static Enum getByName(Enum[] enums, String name) {
        if (name != null) {
            for (int i = 0; i < enums.length; i++) {
                if (enums[i].name.equalsIgnoreCase(name)) {
                    return enums[i];
                }
            }
        }
        return null;
    }

    protected static Enum getById(Enum[] enums, int id) {
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].id == id) {
                return enums[i];
            }
        }
        return null;
    }
}
