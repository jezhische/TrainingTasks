package trainingTest.javarush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ежище on 15.11.2016.
 * /* Транзакционность
 * Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
 * 1. Считать с консоли 2 имени файла
 * 2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
 * В методе joinData:
 * 3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
 * которые есть в forRemoveLines
 * 4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то //содержит не все строки из forRemoveLines
 * 4.1. очистить allLines от данных
 * 4.2. выбросить исключение CorruptedDataException
 * Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
 */
public class Solution17_10_09 {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    private String fileNameQualifier = "\'allLines\'";

    public static void main(String[] args) {
        Solution17_10_09 instance = new Solution17_10_09();
        try {
            allLines = instance.readFiles();
            forRemoveLines = instance.readFiles();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            instance.joinData();
        } catch (CorruptedDataException17_10_09 ex) {
            System.out.println(ex.getMessage());
        } // следующие непроверяемые исключения, унаследованные от RuntimeExeptions, могут быть выброшены при работе
        // метода joinData(), что приведет к завершению программы и потере данных из статических коллекций allLines
        // и forRemoveLines. Их обработка, по идее, сделает метод joinData() транзакционным, т.е. при пробрасывании
        // этих исключений выполнение программы продолжится и данные не будут утеряны. Иных вариантов "сбоя" я не вижу.
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> readFiles() throws IOException {// условие задачи требует, чтобы все исключения были обработаны
        // в main. Хотя проще было бы обработать исключения прямо здесь через try-with-resources.
        List<String> gotFromFile = new ArrayList<>();
        System.out.printf("Print full file name for %s list filling and press Enter\n", fileNameQualifier);
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        String line;
        while ((line = reader.readLine()) != null)
            gotFromFile.add(line);
        reader.close();
        fileNameQualifier = "\'forRemoveLines\'";
        return gotFromFile;
    }

    public void joinData() throws CorruptedDataException17_10_09 {
//        System.out.println(allLines.containsAll(forRemoveLines));
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException17_10_09("Data is corrupted");
        }

    }
}
