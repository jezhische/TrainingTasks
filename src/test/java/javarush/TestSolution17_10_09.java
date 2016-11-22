package javarush;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trainingTest.javarush.CorruptedDataException17_10_09;
import trainingTest.javarush.Solution17_10_09;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Ежище on 20.11.2016.
 */
public class TestSolution17_10_09 {
    Solution17_10_09 sol;

    @Before // аннотация означает, что метод ниже будет выполняться перед каждым тестом
    public void init() {
        sol = new Solution17_10_09();
    }

    @After // аннотация означает, что метод ниже будет выполняться после каждого теста
    public void tearDown() {
        sol = null;
        Solution17_10_09.allLines.clear();
        Solution17_10_09.forRemoveLines.clear();
    }

    /**
     * метод для создания подмены данных System.in:
     */
    public void systemInSubstitution(String substitute) {
        try (ByteArrayInputStream dataIn = new ByteArrayInputStream(substitute.getBytes())) {
            System.setIn(dataIn);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testReadFiles() throws IOException {
        systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//allLines.txt");
        Assert.assertTrue(sol.readFiles().get(0).equals("Dear Mr. Victor,"));
        systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//forRemoveLines.txt");
        Assert.assertEquals(sol.readFiles().get(1), "Regarding the velcro attaching machine,");
    }

    @Test
    public void testJoinData() throws IOException {
        systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//allLines.txt");
        Solution17_10_09.allLines = sol.readFiles();
        systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//forRemoveLines.txt");
        Solution17_10_09.forRemoveLines = sol.readFiles();
        Assert.assertTrue(Solution17_10_09.allLines.containsAll(Solution17_10_09.forRemoveLines));
        sol.joinData(); // в сигнатуре тестового метода не пробрасывается CorruptedDataException17_10_09,
        // как этого требует метод joinData(), поскольку это исключение является наследником IOException,
        // которое уже проброшено в сигнатуре тестового метода
        Assert.assertFalse(Solution17_10_09.allLines.containsAll(Solution17_10_09.forRemoveLines));
    }

    @Test(expected = CorruptedDataException17_10_09.class)
    public void testJoinDataTrowsException() throws IOException {
        systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//allLinesCorrupted.txt");
        Solution17_10_09.allLines = sol.readFiles();
        systemInSubstitution("src//main//resources//sashkaTasks//auxiliaryForSolution17_10_09//forRemoveLines.txt");
        Solution17_10_09.forRemoveLines = sol.readFiles();
        Assert.assertFalse(Solution17_10_09.allLines.containsAll(Solution17_10_09.forRemoveLines));
        sol.joinData();
    }

}
