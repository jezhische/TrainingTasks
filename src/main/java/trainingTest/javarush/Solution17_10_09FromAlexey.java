package trainingTest.javarush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WORK on 22.11.2016.
 * /* Транзакционность
 Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
 1. Считать с консоли 2 имени файла
 2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
 В методе joinData:
 3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть
 в forRemoveLines
 4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
 4.1. очистить allLines от данных
 4.2. выбросить исключение CorruptedDataException
 Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
 */
public class Solution17_10_09FromAlexey {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string1;
        String string2;
        Solution17_10_09FromAlexey solution = new Solution17_10_09FromAlexey();
        try
        {
            BufferedReader f1 = new BufferedReader(new FileReader(bf.readLine()));
            while ((string1 = f1.readLine()) != null)
            {
                allLines.add(string1);
            }
            BufferedReader f2 = new BufferedReader(new FileReader(bf.readLine()));
            while ((string2 = f2.readLine()) != null)
            {
                forRemoveLines.add(string2);
            }
            bf.close();
            f1.close();
            f2.close();
            solution.joinData();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void joinData () throws CorruptedDataException {
        String s;
        int count = 0;
        for(int i = 0; i<forRemoveLines.size(); i++)
        {
            s = forRemoveLines.get(i);

            for(int j = 0; j<allLines.size(); j++)
            {
                if(s.equals(allLines.get(j)))
                {
                    allLines.remove(j);
                    count++;
                }
            }
        }
        if(count != forRemoveLines.size())
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}


class CorruptedDataException extends IOException {
}
