package trainingTest.javarush;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ежище on 15.11.2016.
 * /* Транзакционность
 Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
 1. Считать с консоли 2 имени файла
 2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
 В методе joinData:
 3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
 4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
 4.1. очистить allLines от данных
 4.2. выбросить исключение CorruptedDataException
 Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
 */
public class Solution17_10_09 {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
    }

    public void joinData () throws CorruptedDataException17_10_09 {

    }
}
