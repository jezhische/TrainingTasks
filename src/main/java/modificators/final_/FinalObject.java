package modificators.final_;

public class FinalObject {
    int ou;

    public static void main(String[] args) {
        final FinalObject finalObject = new FinalObject();
        finalObject.ou = 5;
        finalObject.ou = 10;
//        finalObject = new FinalObject(); // cannot assign a value to final variable
    }
}
