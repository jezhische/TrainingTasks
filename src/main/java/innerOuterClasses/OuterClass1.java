package innerOuterClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by WORK on 12.09.2016.
 */
public class OuterClass1 {

    interface Ku {
        int plus(int a, int b);

    }

        private int outerField;

        void methodWithLocalClass(final int finalParameter) {
            int notFinalVar = 0;
            notFinalVar++;
            class InnerLocalClass {
                void getOuterField() {
//                    int a = notFinalVar; // эта строчка кода приведёт к ошибке компиляции. no-final переменные вне контекста недоступны.
                    int b = OuterClass1.this.outerField; // эта строчка кода демонстрирует обращение члену обрамляющего класса.
                }
                int getParameter() {
                    return finalParameter; // эта строчка кода демонстрирует обращение к final переменной вне контекста.
                }
            }
        }
    /**

     *   При определении анонимного класса применен полиморфизм — переменная listener

     *   содержит экземпляр анонимного класса, реализующего существующий

     *   интерфейс ActionListener.

     **/
    void methodWithAnonymousClass(final int interval) {

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                System.out.println("Эта строка выводится на экран каждые " + interval + " секунд.");

            }

        };



        Timer t = new Timer(interval, listener); // объект анонимного класса использован внутри метода.

        t.start();

    }
    void threading() {
        class Ghjhbj implements Runnable {
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }
        Ghjhbj ghj = new Ghjhbj();
        new Thread(ghj, "Большой поток").start();
        for (int i = 0; i < 5; i++)
        new Thread(ghj).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("абракадабра");
            }
        }).start();

        new Thread(() -> {
            System.out.println("ляяямбда");
        }).start();


        System.out.println(kuku.plus(2, 5) + kukuk.plus(3, 2));
    }
    Ku kuku = (a, b) -> (a + b);
    Ku kukuk = (g, h) -> (g * h) ;

    public static void main(String[] args) {

        OuterClass1 out1 = new OuterClass1();
        out1.methodWithAnonymousClass(2);
        out1.threading();
        System.out.println(out1.kuku.plus(5,10));


    }
}
