package threadClass.threadLocal.someBuilderDemo.rightExamplesWithThreadLocal;

public class SomeBuilderSimpleThreadLocal {

    public static class SomeBuilder {
        // There is a table, that associated with the current thread. This ThreadLocal instance can be a key
        // in this table, and the value can be assigned with the T set() method of the ThreadLocal instance.
        // If I want to have another entry in this table, I can create another instance of ThreadLocal class.

        // todo: ANOTHER WORDS: each ThreadLocal instance can hold some object in it.
        // Each thread will get this ThreadLocal instance as a new, "pure" instance, the same as "prototype".
        private ThreadLocal<Integer> counter = new ThreadLocal<>();
        private ThreadLocal<Integer> anotherCounter = new ThreadLocal<>();

        public void build() {
            System.out.printf("Thread %s builds some structure\n", Thread.currentThread().getName());
            if (counter.get() == null)
                counter.set(0);             // public T get() Returns the value in the current thread's copy of this
            // thread-local variable. Here T is Integer.
            counter.set(counter.get() + 1);

            if (anotherCounter.get() == null)
                anotherCounter.set(0);
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
