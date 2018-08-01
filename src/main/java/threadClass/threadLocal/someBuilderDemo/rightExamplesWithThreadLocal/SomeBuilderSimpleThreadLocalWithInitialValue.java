package threadClass.threadLocal.someBuilderDemo.rightExamplesWithThreadLocal;

public class SomeBuilderSimpleThreadLocalWithInitialValue {

    public static class SomeBuilder {

        private ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };
        private ThreadLocal<Integer> anotherCounter = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        public void build() {
            System.out.printf("Thread %s builds some structure\n", Thread.currentThread().getName());

            counter.set(counter.get() + 1);

            anotherCounter.set(anotherCounter.get() + 2);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return counter.get();
        }
        public int anotherCount() {
            return anotherCounter.get();
        }
    }

    public static class SomeBuilderThread extends Thread {
        private SomeBuilder builder;
        public SomeBuilderThread(SomeBuilder builder) {
            this.builder = builder;
        }

        @Override
        public void run() {
            for (int i = 0; i < Math.random() * 10; i++) {
                builder.build();
            }
            System.out.printf("I am %s and I've built %d structures. My anotherCount is %d.\n", Thread.currentThread().getName(),
                    builder.getCount(), builder.anotherCount());
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
