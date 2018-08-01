package threadClass.threadLocal.someBuilderDemo.wrongExample;

public class SomeBuilderDemo {
    public static class SomeBuilder {
        private int counter;

        public void build() {
            System.out.println("Thread " + Thread.currentThread().getName() + " built some structure...");
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCounter() {
            return counter;
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
            System.out.println("My name is " + getName() + ", and I've built " + builder.getCounter() + " threads");
        }
    }

    public static void main(String[] args) {
        SomeBuilder builder = new SomeBuilder();

        SomeBuilderThread builderThread1 = new SomeBuilderThread(builder);
        SomeBuilderThread builderThread2 = new SomeBuilderThread(builder);

        builderThread1.start();
        builderThread2.start();

        try {
            builderThread1.join();
            builderThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
