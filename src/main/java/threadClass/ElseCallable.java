package threadClass;

import java.util.concurrent.*;

/**
 * Created by WORK on 21.09.2016.
 */
public class ElseCallable implements Callable<ElseCallable> {

    int a, b, c;
    ElseCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int divide(int a, int b) {
        return c = a / b;
    }

    @Override
    public ElseCallable call() throws Exception {
        ElseCallable elss = new ElseCallable(a, b);
        try {
            elss.divide(a, b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return elss;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(new ElseCallable(6, 0));
        executorService.shutdown();
        int c = ((ElseCallable)future.get()).c;
        System.out.println(c);
    }
}
