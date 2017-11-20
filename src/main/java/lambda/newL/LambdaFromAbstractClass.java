package lambda.newL;

import java.util.Collection;

public class LambdaFromAbstractClass {

    abstract /*static*/ class Abs {
        abstract void print();
    }

//    Abs lambda = () -> System.out.println("Lambda!") // Target type of a lambda conversion must be an interface

    /*static*/ Abs anonym = new Abs() { // если этот static, то и класс Abs д.б. static, или же должен создаваться
        // где-то снаружи, иначе статическое поле anonym пытается создаться при создании класса LambdaFromAbstractClass,
        // а класс Abs будет создан только при инстанциировании (создании объекта) класса LambdaFromAbstractClass
        @Override
        void print() {
            System.out.println("anonym only");
        }
    };

    public static void main(String[] args) {
        new LambdaFromAbstractClass().new Abs() {
            @Override
            void print() {
                System.out.println("anonym-anonym!");
            }
        }.print();

        new LambdaFromAbstractClass().anonym.print();
    }
}
