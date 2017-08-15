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

import java.io.*;

/**
 * Created by Ежище on 10.11.2016.
 */
public class Solution16_13_10_madSolution {
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
        System.out.println("currentThread name is " + Thread.currentThread().getName());
        Thread.sleep(50); // Важный момент: если не дать текущему главному потоку (а это main) поспать, он выведет
        // содержание файла раньше, чем тот будет переписан дочерним потоком f.
        System.out.println(f.getFileContent());
    }

    public static class ReadFileThread implements ReadFileInterface {

        private String fileName;
        private File file; // и этот String, и этот File создаются как переменные уровня экземпляра, а не локальные,
        // только из-за того, что у getFileContent() (как, собственно, и у run()) нет аргументов.
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
            try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
                int a;
                String temp = "";
                while ((a = buffer.read()) != -1)
                    temp += String.valueOf((char) a);
                return String.format("Содержание файла \"%s\":\n", fileName) + temp;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return "Файл не прочитан";
        }

        @Override
        public void join() throws InterruptedException {

        }

        @Override
        public void start() {
            new Thread(this, fileName).start();
        }

        @Override
        public void run() {
            System.out.printf("Thread %s got started\n", Thread.currentThread().getName()); // все эти лишние выводы
            // на печать я расставил как маркеры - чтобы было видно, как все происходит. Их можно удалить, и тогда
            // решение задачи примет вид, требуемый в условии.
            String readFromFile = "";
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
            // И теперь переписываем файл в измененном виде, чтобы потом считать его в методе getFileContent().
            // Дурной способ - нужно было просто дать главному потоку поспать, пока дочерний не завершит работу.
            try (PrintWriter printInFile = new PrintWriter(file);) {
                printInFile.write(readFromFile);
                printInFile.flush();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.printf("Thread %s is finished\n", Thread.currentThread().getName());
        }
    }

    public static interface ReadFileInterface extends Runnable {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
}
