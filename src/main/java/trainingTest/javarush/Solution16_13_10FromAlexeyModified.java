package trainingTest.javarush;

import java.io.*;

/**
 * Created by WORK on 14.11.2016.
 *
 /* Последовательный вывод файлов
 1. Разберись, что делает программа.
 2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
 3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
 интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
 3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
 3.2. Метод getFileContent должен возвращать содержимое файла.
 3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
 4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
 4.1. Для этого добавь вызов соответствующего метода.
 Ожидаемый вывод:
 [все тело первого файла]
 [все тело второго файла]
 */
public class Solution16_13_10FromAlexeyModified {
    private static String firstFileName;
    private static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    private static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread(); // создаем f как объект интерфейса, а не класса ReadFileThread.
        // А в принципе, можно было бы и как образец класса. См. комментарий ниже.
        f.setFileName(fileName);
        f.start();
        System.out.println(Thread.currentThread().getName());
        f.join(); // заставляет вызвавший поток (в данном случае main) дожидаться завершения вызываемого потока (f).
        System.out.println(f.getFileContent());
    }

    private static interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }




    private static class ReadFileThread extends Thread implements ReadFileInterface // TODO: NB: в этом классе не
            // имплементированы методы  void join() throws InterruptedException; и void start(); из интерфейса
        // ReadFileInterface, хотя мы вроде как обязаны это сделать. Вместо этого их имплементирует родительский класс
        // Tread, так что мы запросто можем их потом использовать в образце f без всякого переопределения еще раз
        // в классе-наследнике ReadFileThread (тем более, что, например, метод join() финальный и не может быть
            // переопределен).
        // TODO: NB: а вот если образовывать объект f вот так: ReadFileThread f = new ReadFileThread(); , то можно было
            // бы отказаться от имплементирования интерфейса и выкинуть этот интерфейс вовсе,
            // см. Solution16_13_10FromAlexeyModified2
    {
        private String fullFileName;

        @Override
        public void setFileName(String fullFileName)
        {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent()
        {
            StringBuilder sb = new StringBuilder();
            String string;
            try
            {
                BufferedReader in = new BufferedReader(new FileReader(fullFileName));
                while ((string = in.readLine()) != null)
                {
                    sb.append(string);
                    sb.append(" ");
                }
                in.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return sb.toString();
        }

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++) {
                getFileContent();
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
