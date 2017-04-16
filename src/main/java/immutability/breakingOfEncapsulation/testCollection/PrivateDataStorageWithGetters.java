package immutability.breakingOfEncapsulation.testCollection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ежище on 16.04.2017.
 */
public class PrivateDataStorageWithGetters {
    private List<String> privateStringList = new LinkedList<>();
    private final List<String> privateFinalStringList = new LinkedList<>();
    private static final List<String> PRIVATE_STATIC_FINAL_STRING_LIST = new LinkedList<>();
    private List<String> forReadingOnly;
    private List<String> immutableList;

    /** Dynamic initialization block */
    {
        privateStringList.add("privateStringList");
        privateFinalStringList.add("privateFinalStringList");
        PRIVATE_STATIC_FINAL_STRING_LIST.add("PRIVATE_STATIC_FINAL_STRING_LIST");
        /** And this is the way to made objects of List immutable
         * http://stackoverflow.com/questions/22636575/unmodifiablemap-java-collections-vs-immutablemap-google */
        /** NB: list forReadingOnly  is NOT IMMUTABLE: we cannot modify it directly, but we have access to its
         * "inner" list privateStringList, and if we change it, the "outer" list is changing too.
         * So this list with access "reading only", but it can be modified.*/
        forReadingOnly = Collections.unmodifiableList(privateStringList);
        /** On the contrary, here we use LinkedList that is the COPY of our origin privateStringList; we haven't
         * access to this LinkedList and we are not able to modify unmodifiableList directly;
         * so this is really IMMUTABLE list, and we cannot modify it after its creation. */
        immutableList = Collections.unmodifiableList(new LinkedList<>(privateStringList));
        try {
            forReadingOnly.add("forReadingOnly");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: cannot change unmodifiableList \"forReadingOnly\": " +
                    e.getMessage());
        }
        try {
            immutableList.add("immutableList");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: cannot change unmodifiableList \"immutableList\": " +
                    e.getMessage());
        }
    }

    /**
     * Getters
     */
    public List<String> getPrivateStringList() {
        return privateStringList;
    }

    public List<String> getPrivateFinalStringList() {
        return privateFinalStringList;
    }

    public static List<String> getPrivateStaticFinalStringList() {
        return PRIVATE_STATIC_FINAL_STRING_LIST;
    }

    public List<String> getForReadingOnly() {
        return forReadingOnly;
    }

    public List<String> getImmutableList() {
        return immutableList;
    }
}
