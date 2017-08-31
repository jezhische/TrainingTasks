package inheritanceThisSuper.newConstructorSimple;

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

    //    @Override // todo: Статический метод не переопределяется!!!!
    static void test1() { // todo: Если static в классе A, то должен быть static и в классе B, иначе это расценивается
        // как попытка переопределения/ Здесь модификатор static означает, что мы всего лишь ПРЯЧЕМ метод класса-родителя,
        // todo: это СОКРЫТИЕ МЕТОДОВ (hiding methods), см.:
        // http://info.javarush.ru/translation/2014/04/15/10-%D0%B7%D0%B0%D0%BC%D0%B5%D1%82%D0%BE%D0%BA-%D0%BE-
        // %D0%BC%D0%BE%D0%B4%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D0%B5-Static-%D0%B2-Java.html
// todo: это потому, что определение типа, откуда берется static метод, происходит НЕ в runtime (late binding), а при
// СОЗДАНИИ КЛАССА компилятором ("статические методы связываются [получают связь с типом] во время компиляции, в отличие
// от связывания виртуальных или не статических методов, которые связываются во время исполнения на реальном объекте")
        System.out.println("B.test1");
    }

    static void test2() {
//        super.test2(); // todo: из СТАТИЧЕСКОГО контекста НЕЛЬЗЯ обратиться к ИНСТАНСУ суперкласса
    }

    @Override
    void test3() {
        System.out.println("B.test3");
    }


    @Override
    public String toString() {
        return super.toString() + ". Here: B.toString() is worked.";
    }

    public void print() {
        System.out.println("The only B class method print() is worked here.");
    }
}
