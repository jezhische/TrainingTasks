package trainingTest.javarush;

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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ежище on 10.11.2016.
 */
public class Solution16_13_10 {
    public static String firstFileName;
    public static String secondFileName;

    public static void main(String[] args) throws InterruptedException {
        firstFileName = "mom";
        secondFileName = "frame";
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        System.out.println(f.getFileContent());
    }

    public static class ReadFileThread implements ReadFileInterface {

        String readFromFile = null;
        String fileName;
        File file; // и оба этих String, и этот File создаются как переменные уровня класса только из-за того,
        // что для getFileContent() (как, собственно, и для run()) нет аргументов.
        // Вообще, интерфейс Runnable в этом смысле неудобный.

        @Override
        public void setFileName(String fileName) {
            this.fileName = fileName;
            if (new File("src//main//resources").exists()) {
                System.out.println("Директория \"src//main//resources\" существует.");
            } else if (new File("src//main//resources").mkdir())
                System.out.println("Директория \"src//main//resources\" успешно создана.");

            file = new File(String.format("src//main//resources//%s.txt", fileName));
            if (file.exists())
                System.out.printf("Файл \"%s.txt\" существует.\n", fileName);
            else {
                try {
                    if (file.createNewFile())
                        System.out.printf("Файл \"%s.txt\" успешно создан.\n", fileName);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            try (FileWriter writer = new FileWriter(file, false)) {
                // false - чтобы файл был перезаписан заново, а не дозаписан
                String fileContetnt = "Имя файла не идентифицировано.";
                if (fileName.equals(firstFileName)) {
                    fileContetnt = "Мама,мыла,раму,\nРаму,мыла,мама";
                } else if (fileName.equals(secondFileName)) {
                    fileContetnt = "Рама,мылась,мамой,\nМамой,мылась,рама";
                }
                writer.write(fileContetnt);
                writer.flush();

            } catch (IOException ex) {
                System.out.println("Запись в файл не удалась: " + ex.getMessage());
            }
        }

        @Override
        public String getFileContent() {
            readFromFile = String.format("Содержание файла \"%s\":\n", fileName);
            String temp = "";
            try (FileReader reader = new FileReader(file)) {
                int c;
                while ((c = reader.read()) != -1)
                    temp += String.valueOf((char) c);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] splitString = (temp.split(","));
            for (String s : splitString)
                readFromFile += s + " "; // ну... вот это имелось в виду под условием "Раздели пробелом строки файла"?
            return readFromFile;
        }

        @Override
        public void join() throws InterruptedException {

        }

        @Override
        public void start() {

        }

        @Override
        public void run() {

        }
    }

    public static interface ReadFileInterface extends Runnable {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
}
