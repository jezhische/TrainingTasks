package garbage.trash;

public class StackOver {
//    public StackOver stackOver = new StackOver(); // StackOverflowError
    public static StackOver stackOver = new StackOver(); // NB: если это static, все будет хорошо! Поскольку static
    // создается не в момент создания объекта, а при создании класса, так что он не вызовет бесконечную рекурсию.

    public static void main(String[] args) {
        StackOver stackOver = new StackOver();
        System.out.println(stackOver.stackOver);
        System.out.println(StackOver.stackOver);
        String[] so = {"ku", "hru"};
//        StackOver.main(so); // StackOverflowError
    }
}
