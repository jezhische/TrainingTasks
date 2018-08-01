package garbage;

import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;

public class NotNullJetbrainsProbe {

    private String printNull(String value) {
        return value;
    }
    @NotNull
    private String dontPrintNull(String value) {
        return value;
    }

    public static void main(String[] args) {
        NotNullJetbrainsProbe n = new NotNullJetbrainsProbe();
        System.out.println(n.printNull("hu"));
        System.out.println(n.printNull(null));
        System.out.println(n.dontPrintNull("yo"));

        try {
            System.out.println(n.dontPrintNull(null));
        } catch (IllegalStateException ilse) {
            LogManager.getRootLogger().error("@NotNull throws IllegalStateException");
        }
    }
}
