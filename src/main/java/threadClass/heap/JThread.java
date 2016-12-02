package threadClass.heap;

/**
 * Created by WORK on 24.08.2016.
 */
public class JThread extends Thread {

        JThread(String name){
            super(name);
        }
    @Override
        public void run(){

            System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Поток прерван");
            }
            System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
        }

    public static void main(String[] args) {

        System.out.println("Главный поток начал работу...");
        for(int i=1; i<6;i++) {
            JThread t = new JThread("JThread " + i);
            t.start(); // запуск метода run() в потоке JThread
            try {
                t.join(); // главный поток не завершает работу, ожидает, пока этот поток завершит, но за ним начинается
                // в цикле следующий, который также требует ожидать своего завершения
            } catch (InterruptedException e) {
                System.out.printf("Поток %s прерван", t.getName());
            }
        }
        System.out.println("Главный поток завершил работу...");
    }
}
