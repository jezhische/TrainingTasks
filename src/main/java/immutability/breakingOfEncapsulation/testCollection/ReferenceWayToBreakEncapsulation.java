package immutability.breakingOfEncapsulation.testCollection;

import java.util.List;

/**
 * Created by Ежище on 16.04.2017.
 */
public class ReferenceWayToBreakEncapsulation {
    /** objects of classes implementing List are mutable, so we can change them receiving the reference
     * even if they are final */
    public static void main(String[] args) {
        PrivateDataStorageWithGetters pData = new PrivateDataStorageWithGetters();
        System.out.println("before breaking");
        System.out.println(pData.getPrivateStringList() + " " + pData.getPrivateFinalStringList() + " "
                + PrivateDataStorageWithGetters.getPrivateStaticFinalStringList() + " " +
        pData.getForReadingOnly() + " " + pData.getImmutableList());

        List<String> ps = pData.getPrivateStringList();
        ps.set(0, "privateStringList is broken");
        List<String> pfs = pData.getPrivateFinalStringList();
        pfs.set(0, "privateFinalStringList is broken");
        List<String> psfs = PrivateDataStorageWithGetters.getPrivateStaticFinalStringList();
        psfs.set(0, "PRIVATE_STATIC_FINAL_STRING_LIST is broken");
        List<String> fro = pData.getForReadingOnly();
        List<String> il = pData.getImmutableList();
        /** we cannot change both of following lists directly */
        try {
            fro.add("forReadingOnly");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: cannot change unmodifiableList \"forReadingOnly\": " +
                    e.getMessage());
        }
        try {
            il.add("immutableList");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: cannot change unmodifiableList \"immutableList\": " +
                    e.getMessage());
        }
        System.out.println("after breaking");
        System.out.println(pData.getPrivateStringList() + " " + pData.getPrivateFinalStringList() + " "
                + PrivateDataStorageWithGetters.getPrivateStaticFinalStringList() + " " +
                pData.getForReadingOnly() + " " + pData.getImmutableList());
    }
}
