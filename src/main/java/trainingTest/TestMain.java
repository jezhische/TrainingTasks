package trainingTest;

/**
 * Created by WORK on 15.09.2016.
 */
public class TestMain {

        public static void main(String[] args) {
//            args[0] = "kjhkj";
            if(args.length > 0)  //если через консоль были введены аргументы
                System.out.println(args[0]);  //то вывести на консоль первый элемент из массива

            else {  //иначе —
                TestMain obj = new TestMain(); //создать объект
                obj.main(); //и использовать обычный метод с названием main()
            }
        }

        public static void main() {  //это обычный метод с названием main()
            System.out.println("it's usual main method without String[] args!");
        }
}
