package threadClass.threadLocal.simpleDateFormatSample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// https://stackoverflow.com/questions/817856/when-and-how-should-i-use-a-threadlocal-variable/817926#817926
// One possible (and common) use is when you have some object that is not thread-safe, but you want to avoid
// synchronizing access to that object (I'm looking at you, SimpleDateFormat). Instead, give each thread its
// own instance of the object.

// Чтобы переменная была доступна отовсюду, она может быть статической. Но статическая переменная потоконебезопасна.
// Чтобы избежать дорогостоящей операции синхронизации, оборачиваем ее в ThreadLocal, и теперь у каждого потока будет
// своя переменная с одним и тем же именем, но с разными значениями в зависимости от потока.
public class PrimitiveSimpleDateFormatThreadLocal {
        // SimpleDateFormat is not thread-safe, so give one to each thread
// Создаем переменную - это будет образец SimpleDateFormat, обернутый в ThreadLocal
        private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
            @Override
            protected SimpleDateFormat initialValue()
            {
                return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
            }
        };

// Метод для доступа к переменной - получаем переменную и с ее помощью форматируем какую-либо дату.
        public String formatIt(Date date)
        {
            return formatter.get().format(date);
        }
}
// (Пока что это непоказательный пример, см. ComplexSimpleDateFormatThreadLocal)
class CheckThreadLocal {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 25; i > 0; i--) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + new PrimitiveSimpleDateFormatThreadLocal().formatIt(new Date()));
            });
        }
        executorService.shutdown();
    }
}