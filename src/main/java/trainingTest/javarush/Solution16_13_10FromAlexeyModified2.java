package trainingTest.javarush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class Solution16_13_10FromAlexeyModified2 {
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
        ReadFileThread f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        System.out.println(Thread.currentThread().getName());
        f.join(); // заставляет вызвавший поток (в данном случае main) дожидаться завершения вызываемого потока (f).
        System.out.println(f.getFileContent());
    }


    private static class ReadFileThread extends Thread // TODO: NB: здесь я отказался от использования интерфейса
        // ReadFileInterface
        // TODO: NB: и создал объект f вот так: ReadFileThread f = new ReadFileThread(); , теперь можно
            //  отказаться от имплементирования интерфейса ReadFileInterface и выкинуть этот интерфейс вовсе,
            // как я это здесь и сделал!
    {
        private String fullFileName;

        public void setFileName(String fullFileName)
        {
            this.fullFileName = fullFileName;
        }

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
