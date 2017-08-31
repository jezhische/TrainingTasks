package threadClass.newT;

public class NonSinchronizedTest {
    private int a = 1, b = 2, result11, result12, result22;


     private void one() {a = b;}
     private void two() {b = a;}

     private void threadOne() {
         new Thread(() -> one()).start();
     }
     private void threadTwo() {
         new Thread(this::two).start();
     }

     private void analizeThreadWork() {
         if (a == 1 && b == 1) result11++;
         else if (a == 2 && b == 2) result22++;
         else if (a != b) result12++;
     }

     public void work() {
         for (int i = 0; i < 1000; i++) {
             threadOne();
             threadTwo();
             try {
                 Thread.sleep(10);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             analizeThreadWork();
             a = 1;
             b = 2;
         }
     }

    public int getResult11() {
        return result11;
    }

    public int getResult12() {
        return result12;
    }

    public int getResult22() {
        return result22;
    }

    public static void main(String[] args) {
         NonSinchronizedTest nonS = new NonSinchronizedTest();
//         nonS.one();
//        System.out.println(nonS.a);
        nonS.work();
        System.out.printf("result11: %d, result22: %d, result12: %d", nonS.getResult11(), nonS.getResult22(),
                nonS.getResult12());
    }
}
