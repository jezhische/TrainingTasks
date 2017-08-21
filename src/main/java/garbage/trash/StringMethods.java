package garbage.trash;

public class StringMethods {
    public static void main(String[] args) {
        System.out.println(String.valueOf('\n'));
        System.out.println(String.valueOf((char) 85));
        System.out.println("ou" + '\n' + "uo" + 5);
        System.out.println(Character.getNumericValue('\n')); //If the character does not have a numeric value,
        // then -1 is returned.
    }
}
