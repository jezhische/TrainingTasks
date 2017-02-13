package threadClass.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Ежище on 04.12.2016.
 * http://metanit.com/java/tutorial/8.6.php
 */
public class ThreadsApp2Philosophers {

/* permits - количество разрешений: сколько потоков могут одновременно работать с общим ресурсом. Например, если
 * permits = 3, то пока с синхронизированным блоком кода работает меньше трех потоков, другие потоки могут присоединиться
 * к трапезе, но когда потоков стало 3 (при этом permits = 0), остальные уже не могут войти в синхронизированный блок
 * и ждут, пока не освободится хотя бы одно место (см. https://habrahabr.ru/post/277669/)**/

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        for(int i=1;i<6;i++)
            new Philosopher(sem,i).start();
    }
}
// класс философа
class Philosopher extends Thread
{
    Semaphore sem; // семафор. ограничивающий число философов
    // кол-во приемов пищи
    int num = 0;
    // условный номер философа
    int id;
    // в качестве параметров конструктора передаем идентификатор философа и семафор
    Philosopher(Semaphore sem, int id)
    {
        this.sem=sem;
        this.id=id;
    }

    public void run()
    {
        try
        {
            while(num<3)// пока количество приемов пищи не достигнет 3
            {
                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println ("Философ " + id+" садится за стол");
                // философ ест
                sleep(500);
                num++;

                System.out.println ("Философ " + id+" выходит из-за стола");
                sem.release();

                // философ гуляет
                sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println ("у философа " + id + " проблемы со здоровьем");
        }
    }
}
