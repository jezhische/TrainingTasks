package threadClass;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import javax.imageio.stream.FileImageInputStream;

/**
 * Created by WORK on 19.09.2016.
 */
public class FutureTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите базовый каталог (например, /usr/loacl/jdk/lib): ");
        String directory = in.nextLine();
        System.out.print("Введите ключевое слово (например, volatile): ");
        String keyword = in.nextLine();
        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask task = new FutureTask(counter);
        Thread t = new Thread(task);
        t.start();
        try
        {
            System.out.println(task.get() + " файлов найдено.");
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
    }

}
/**
 *  Задача подсчитыает файлы в каталоге и всех его подкаталогах,
 *  которые содержат указанное ключевое слово.
 */
class MatchCounter implements Callable // было просто Callable
{
    /**
     * Конструктор MatchCounter
     * @param directory Каталог, с которого начинается поиск
     * @param keyword Искомое ключевое слово
     */
    private File directory;
    private String keyword;
    private int count;

    public MatchCounter(File directory, String keyword)  // здесь directory - это каталог, а не String!
    {
        this.directory = directory;
        this.keyword = keyword;
    }
    public Integer call()
    {
        count = 0;
        try
        {
            File[] files = directory.listFiles();
            //
            if (files.length == 0)  // это добавил я
                System.out.println("пустая вышла директория");
            else
                System.out.println(files.length);
            //
            ArrayList<Future> results = new ArrayList<Future>();
            for(File file : files)
                if(file.isDirectory())
                {
//                    System.out.println("найдена директория"); // добавил я, эта печать в консоль не идет - здесь ошибка
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask task = new FutureTask(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }
                else
                {
                    if(search(file)) count++;
                }
            for(Future result : results)
                try
                {
                    count+= (int)result.get();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }
        }
        catch(InterruptedException e)
        {
        }
        catch (NullPointerException ex) { // это catch всавил я сам
            System.out.println("здесь поймал NullPointerException");
        }
        return count;
    }

    /**
     * Ищем в файле заданное ключевое слово.
     * @param file Файл, в котором идет поиск
     * return true, если слово найдено в файле
     */
    public boolean search(File file)
    {
        try
        {
            Scanner in = new Scanner((Readable) new FileImageInputStream(file));
            boolean found = false;
            while(!found == in.hasNextLine()) //было: while(!found &amp;&amp; in.hasNextLine())
            {
                String line = in.nextLine();
                if(line.contains(keyword)) found = true;
            }
            in.close();
            return found;
        }
        catch (IOException e)
        {
            return false;
        }
    }
}
