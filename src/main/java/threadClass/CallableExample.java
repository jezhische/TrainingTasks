package threadClass;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Ежище on 16.09.2016.
 * http://darkraha.com/rus/java/api/multithread/task.php
 * https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
 */
public class CallableExample {
    public static class WordLengthCallable implements Callable<Integer> {
        private String word;
        public WordLengthCallable(String word) {
            this.word = word;
        }
        public Integer call() {
            return Integer.valueOf(word.length());
        }
    }

    public static void main(String args[]) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Set<Future<Integer>> set = new HashSet<Future<Integer> >();

        String [] words = {"мама мыла раму"};

        for (String word: words) { // здесь вместо String words были args из main
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        System.exit(sum);
    }
}
