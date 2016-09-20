package threadClass;

/**
 * Created by WORK on 25.08.2016.
 */
public class MyThreadRunnable implements Runnable {

    MyThreadRunnable(){
    }

    public void run(){

        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException e){
            System.out.println("Поток прерван");
        }
        System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
    }
    public static void main(String[] args) {

        System.out.println("Главный поток начал работу...");
        new Thread(new MyThreadRunnable(),"MyThreadRunnable").start();
        System.out.println("Главный поток завершил работу...");
    }
}
