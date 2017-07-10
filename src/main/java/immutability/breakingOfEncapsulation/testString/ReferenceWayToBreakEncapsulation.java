package immutability.breakingOfEncapsulation.testString;

/**
 * Created by Ежище on 16.04.2017.
 */
public class ReferenceWayToBreakEncapsulation {
    /** objects of String class are immutable, so we cannot change them receiving the reference */
    public static void main(String[] args) {
        PrivateDataStorageWithGetters pData = new PrivateDataStorageWithGetters();
        System.out.println(pData.getPrivateString() + " " + pData.getPrivateFinalString() + " "
                + PrivateDataStorageWithGetters.PUBLIC_STATIC_FINAL_STRING);
        /** Here we can get reference to all the private Strings with the help od getters. But we cannot change
         * these Strings, 'cause when we give them the new value, we get the reference on the new object.
         * So String is immutable */
        String pS = pData.getPrivateString();
        pS = "broken";
        String pFS = pData.getPrivateFinalString();
        pFS = "broken";
        String pSFS = PrivateDataStorageWithGetters.PUBLIC_STATIC_FINAL_STRING;
        pSFS = "broken";
        System.out.println(pData.getPrivateString() + " " + pData.getPrivateFinalString() + " "
                + PrivateDataStorageWithGetters.PUBLIC_STATIC_FINAL_STRING);
    }
}
