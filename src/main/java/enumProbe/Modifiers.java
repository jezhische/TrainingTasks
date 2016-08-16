package enumProbe;

/**
 * Created by WORK on 11.08.2016.
 */
public class Modifiers extends Enum {
    public static final int PUBLIC_ID = 1;
    public static final String PUBLIC_VIEW = "public";
    public static final Modifiers PUBLIC =
            new Modifiers(PUBLIC_ID, PUBLIC_VIEW);

    public static final int STATIC_ID = 2;
    public static final String STATIC_VIEW = "static";
    public static final Modifiers STATIC =
            new Modifiers(STATIC_ID, STATIC_VIEW);

    public static final int FINAL_ID = 3;
    public static final String FINAL_VIEW = "final";
    public static final Modifiers FINAL =
            new Modifiers(FINAL_ID, FINAL_VIEW);

    public static final Modifiers[] modifiers = new Modifiers[]{
            PUBLIC, STATIC, FINAL
    };

    private Modifiers(int id, String name) {
        super(id, name);
    }

    public static Modifiers getByView(String code) {
        return (Modifiers) getByName(modifiers, code);
    }

    public static Modifiers getById(int id) {
        return (Modifiers) getById(modifiers, id);
    }

}
