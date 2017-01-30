package reference;

/**
 * Created by Ежище on 28.01.2017.
 */
public class FinalReference {
    /* Что показано в данном примере: финальную ссылку нельзя переопределить (нельзя переписать ее значение),
    но поля объекта, на который она указывает, можно менять: **/
    int i = 5;
    public static FinalReference createInstance() {
        final FinalReference instance = new FinalReference();
        return instance;
    }

    public static void main(String[] args) {
        FinalReference instance = createInstance();
        FinalReference test = new FinalReference();
        test.i = 25;
        instance = test; // мнэээ... ???? ага: можно получить не-финальную копию финальной ссылки, например:
        // test = finalTest; (см. ниже), что я и сделал при создании instance. Т.е. instance - не-финальная ссылка.
        System.out.println(instance.i);

        final FinalReference finalTest = new FinalReference();
//        test = finalTest; // так можно
//        finalTest = test; // угу, так нельзя
        /* финальную ссылку нельзя переопределить, но поля объекта, на который она указывает, можно менять: **/
        finalTest.i = 48;
        System.out.println(finalTest.i);
    }
}
