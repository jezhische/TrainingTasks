package inheritanceThisSuper.constructorSimple;

public class B extends A {
    // default конструктора нет, поэтому создание конструктора со ссылкой super обязательно

    // Инициализация какого-либо поля (например, int i) до того, как отработал конструктор super(int i), невозможна.
    // Соответственно, ни одно поле не может быть передано из класса-наследника в конструктор super(int i). Необходимо
    // либо создать конструктор, который будет получать в качестве параметров эту необходимую i и передавать ее в
    // конструктор super(int i) для создания образца родителя например, это public B(int i)  {super(int i);}, либо
    // еще возможный вариант - создать статическое поле, которое будет инициализировано при создании класса (если
    // значение не указано, то оно будет инициализировано 0 или null):
    private static int i;

    public B() {
        super(i);
    }

    @Override
    public String toString() {
        return super.toString() + ". Here: B.toString() is worked.";
    }

    public void print() {
        System.out.println("The only B class method print() is worked here.");
    }
}
