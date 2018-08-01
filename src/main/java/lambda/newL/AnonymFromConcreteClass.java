package lambda.newL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AnonymFromConcreteClass {

    static class Concrete {
        int summ(int a, int b) {return a + b;}
    }

    // todo: Здесь я создаю объект конкретного класса (не абстрактного, не интерфейса), переопределяя его конкретный метод
//        Concrete newLambdaConcrete = (a, b) -> a - b; // не выходит
    static Concrete newAnonymConcrete = new Concrete(){
        @Override
        public int summ(int a, int b) { // NB: я могу расширять доступ, но не сужать (not weaker access privileges),
// иначе в полиморфизме может возникнуть ситуация, когда я работал с родительским объектом, у которого этот метод доступен,
// а в рантайме поставил на его место дочерний объект, у которого метод недоступен.
            return a - b;
        }
    };

//----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println(newAnonymConcrete.summ(5, 3)); // todo: OK, все получилось, результат = 2
    }
// Далее просто исследование эквивалентности----------------------------------------------------------------------------

    @Test
    public void equiv() {
        assertTrue(newAnonymConcrete instanceof Concrete);

        Class<Concrete> concreteClass = Concrete.class;
        Class<? extends Concrete> newConcreteClass = new Concrete().getClass();
        assertEquals(concreteClass, newConcreteClass);

//        Class<Concrete> anonymConcreteClass = newAnonymConcrete.getClass(); // вот так не проходит, поскольку объект
// создается в рантайме, и класс у него может быть уже новый, унаследованный. Как далее и случилось:
        Class<? extends Concrete> anonymConcreteClass = newAnonymConcrete.getClass();
        assertNotEquals(concreteClass, anonymConcreteClass);
    }
}
