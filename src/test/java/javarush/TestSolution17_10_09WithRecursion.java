package javarush;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trainingTest.javarush.CorruptedDataException17_10_09;
import trainingTest.javarush.Solution17_10_09WithRecursion;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ежище on 18.11.2016.
 */
public class TestSolution17_10_09WithRecursion extends Solution17_10_09WithRecursion {
//    Solution17_10_09WithRecursion sol; // в создании объекта нет нужды, поскольку тест пришлось унаследовать от класса, который
    // тестируется (причину см. ниже)

    @Before // аннотация означает, что метод ниже будет выполняться перед каждым тестом
    public void init() {
//        sol = new Solution17_10_09WithRecursion(); // нет нужды в инициализации объекта
    }

    @After // аннотация означает, что метод ниже будет выполняться после каждого теста
    public void tearDown() {
//        sol = null; // нет нужды в уничтожении объекта
        allLines.clear();
        forRemoveLines.clear();
    }

    /** метод для создания подмены данных System.in: */
    public void systemInSubstitution(String substitute) {
        try (ByteArrayInputStream dataIn = new ByteArrayInputStream(substitute.getBytes())) {
            System.setIn(dataIn);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFiles() throws IOException { // перегруженный метод, повторяющий тот, что нужно тестировать, с тем исключением,
        // что данные, которые должны быть считаны со сканера, подменяются данными из метода systemInSubstitution.
        // Тестироваться будет этот перегруженный метод. Это неправильно, поскольку тестирование перегруженного метода
        // не означает, что базовый будет работать, но иного варианта здесь я не вижу.
        if (fileNameQualifier.equals("\'allLines\'"))
            systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//allLines.txt");
        else if (fileNameQualifier.equals("\'forRemoveLines\'"))
            systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//forRemoveLines.txt");
        System.out.printf("Print full file name for %s list filling and press Enter\n", fileNameQualifier);
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
            String line;
            switch (fileNameQualifier) {
                case "\'allLines\'":
                    while ((line = reader.readLine()) != null)
                        allLines.add(line);
                    fileNameQualifier = "\'forRemoveLines\'";
                    break;
                case "\'forRemoveLines\'":
                    while ((line = reader.readLine()) != null)
                        forRemoveLines.add(line);
                    pulse = false;
                    break;
            }
        if (pulse) {
            readFiles();
        }
    }

    public void readCorruptedFiles() throws IOException { // метод для считывания "поврежденных" файлов для тестирования работы
        // исключения CorruptedDataException17_10_09
        if (fileNameQualifier.equals("\'allLines\'"))
            systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//allLinesCorrupted.txt");
        else if (fileNameQualifier.equals("\'forRemoveLines\'"))
            systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//forRemoveLines.txt");
        System.out.printf("Print full file name for %s list filling and press Enter\n", fileNameQualifier);
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
            String line;
            switch (fileNameQualifier) {
                case "\'allLines\'":
                    while ((line = reader.readLine()) != null)
                        allLines.add(line);
                    fileNameQualifier = "\'forRemoveLines\'";
                    break;
                case "\'forRemoveLines\'":
                    while ((line = reader.readLine()) != null)
                        forRemoveLines.add(line);
                    pulse = false;
                    break;
            }
        if (pulse) {
            readCorruptedFiles();
        }
    }

    @Test
    public void testReadFiles() {
        try {
            readFiles();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(allLines.get(0).equals("Dear Mr. Victor,"));
        Assert.assertEquals(forRemoveLines.get(1), "Regarding the velcro attaching machine,");
    }
    @Test
    public void testJoinData() throws CorruptedDataException17_10_09 {
        try {
            readFiles();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(allLines.containsAll(forRemoveLines));
        joinData();
        Assert.assertFalse(allLines.containsAll(forRemoveLines));
    }
    @Test (expected = CorruptedDataException17_10_09.class)
    public void testCorruptedDataException17_10_09() throws CorruptedDataException17_10_09 {
        try {
            readCorruptedFiles();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertFalse(allLines.containsAll(forRemoveLines));
        joinData();
    }
//    public static void main(String[] args) {
//        System.out.println(forRemoveLines.get(1));
//    }
}
