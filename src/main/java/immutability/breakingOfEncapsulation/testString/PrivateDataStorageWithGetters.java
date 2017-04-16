package immutability.breakingOfEncapsulation.testString;

/**
 * Created by Ежище on 16.04.2017.
 */
public class PrivateDataStorageWithGetters {
    private String privateString = "privateString";
    private final String privateFinalString = "privateFinalString";
    // if following field is private, I cannot access it even with getter:
    public static final String PUBLIC_STATIC_FINAL_STRING = "PUBLIC_STATIC_FINAL_STRING";

    public String getPrivateString() {
        return privateString;
    }
    public String getPrivateFinalString() {
        return privateFinalString;
    }
    public static String getPrivateStaticFinalString() {
        return PUBLIC_STATIC_FINAL_STRING;
    }
}
