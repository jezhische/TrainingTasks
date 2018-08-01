package classClass.newC.privateConstrucnorTypeInstance;

public class PrivateConstructorType {
    private String ou;

    private PrivateConstructorType() {
    }

    private PrivateConstructorType(String ou) {
        this.ou = ou;
    }

    public String getOu() {
        return ou;
    }
}
