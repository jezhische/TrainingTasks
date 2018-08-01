package threadClass.threadLocal.someBuilderDemo.rightExample;

import java.util.HashMap;

public class SomeBuilderDemo {

    public static class SomeBuilder {
        private HashMap<String, Integer> counters = new HashMap<>();

        public void build() {
            System.out.printf("Thread %s builds some structure\n", Thread.currentThread().getName());
            if (!counters.containsKey(Thread.currentThread().getName()))
                counters.put(Thread.currentThread().getName(), 1);
            else counters.put(Thread.currentThread().getName(), counters.get(Thread.currentThread().getName()) + 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCounter() {
            if (counters.containsKey(Thread.currentThread().getName()))
                return counters.get(Thread.currentThread().getName());
            return 0;
        }
    }

    public static class SomeBuilderThread extends Thread {
        private SomeBuilder builder;
        public SomeBuilderThread(SomeBuilder builder) {
            this.builder = builder;
        }

        @Override
        public void run() {
            for (int i = 0; i < Math.random() * 10; i++)
                builder.build();
            System.out.printf("I am %s and I've built %d structures\n", Thread.currentThread().getName(),
                    builder.getCounter());
        }
    }

    public static void main(String[] args) {
        SomeBuilder builder = new SomeBuilder();
        SomeBuilderThread t1 = new SomeBuilderThread(builder);
        SomeBuilderThread t2 = new SomeBuilderThread(builder);
         t1.start();
         t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
