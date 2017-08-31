package collectionsAndMaps.map.newM;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;

public class StringSplitCompare {

    private void writeToFile(String filename, String text) {
        try (FileWriter writer = new FileWriter(filename); BufferedWriter bWriter = new BufferedWriter(writer)) {
            bWriter.write(text);
            bWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(String filename) {
        File file = new File(filename);
        StringBuilder text = new StringBuilder();
        if (file.exists() && file.isFile()) {
            try (FileReader reader = new FileReader(file); BufferedReader breader = new BufferedReader(reader)) {
                String read = null;
                while ((read = breader.readLine()) != null) {
                    text.append(read);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }

    public String[] splitter(String filename, String text, String regex) {
        writeToFile(filename, text);
        return readFromFile(filename).split(regex);
    }

    public Map<Integer, String> sortedMapa(String[] splitted) {
        Arrays.sort(splitted, String.CASE_INSENSITIVE_ORDER);
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < splitted.length; i++) {
            map.put(i, splitted[i]);
        }
        return map;
    }

    // сложный способ - создаем коллекцию значений key из EntrySet, которые затем {будут удалены из map:
    public Map<Integer, String> complexTrimedMapa(Map<Integer, String> sortedMapa, String trimmerRegex) {
        sortedMapa.entrySet().stream().collect(ArrayList::new, // создаем контейнер, который }будет
                // затем наполняться и вернется как результат применения метода collect(),
                // эквивалентно () -> new ArrayList<Integer>() }
        (list, entry) -> {if (entry.getValue().contains(trimmerRegex)) list.add(entry.getKey());}, // создаем контейнер
                // с результатами, отобранными по нужному критерию
                ArrayList::addAll // в первый контейнер {добавляем содержимое второго,
                // эквивалентно (list1, list2) -> list1.addAll(list2). И дальше все три операции по кругу.
                ).forEach(sortedMapa::remove); // удаляем записи по всем ключам из полученного ArrayList,
        // эквивалентно (i) -> sortedMapa.remove(i)
        return sortedMapa;
    }

    // простой способ - воспользуемся готовым способом из коллекции:
    public Map<Integer, String> simplyTrimedMapa(Map<Integer, String> sortedMapa, String trimmerRegex) {
        sortedMapa.entrySet().removeIf(entry -> entry.getValue().contains(trimmerRegex));
        return sortedMapa;
    }

    public static void main(String[] args) {
        StringSplitCompare stringSplitCompare = new StringSplitCompare();
        String filename = "src\\main\\java\\collectionsAndMaps\\map\\newM\\textData\\stringSplitCompareData.txt";
        String text = "    // сложный способ - создаем коллекцию значений key из EntrySet, которые затем {будут удалены из map:\n" +
                "    public Map<Integer, String> complexTrimedMapa(Map<Integer, String> sortedMapa, String trimmerRegex) {\n" +
                "        sortedMapa.entrySet().stream().collect(ArrayList::new, // создаем контейнер, который }будет\n" +
                "                // затем наполняться и вернется как результат применения метода collect(),\n" +
                "                // эквивалентно () -> new ArrayList<Integer>() }\n" +
                "        (list, entry) -> {if (entry.getValue().contains(trimmerRegex)) list.add(entry.getKey());}, // создаем контейнер\n" +
                "                // с результатами, отобранными по нужному критерию\n" +
                "                ArrayList::addAll // в первый контейнер {добавляем содержимое второго,\n" +
                "                // эквивалентно (list1, list2) -> list1.addAll(list2). И дальше все три операции по кругу.\n" +
                "                ).forEach(sortedMapa::remove); // удаляем записи по всем ключам из полученного ArrayList,\n" +
                "        // эквивалентно (i) -> sortedMapa.remove(i)\n" +
                "        return sortedMapa;\n" +
                "    }";
        String regex = "[{}]";
        String[] splitted = stringSplitCompare.splitter(filename, text, regex);
//        System.out.println(Arrays.deepToString(splitted));
        Arrays.stream(splitted).forEach(System.out::println);

        Map<Integer, String> sortedMapa = stringSplitCompare.sortedMapa(splitted);
        sortedMapa.forEach((key, value) -> System.out.println("key: " + key + "\nvalue: " + value));

        System.out.println("\n---------------------------------------------------------\n");
        stringSplitCompare.complexTrimedMapa(sortedMapa, "tr").forEach(
                (key, value) -> System.out.println("key: " + key + "\nvalue: " + value));
        System.out.println("\n---------------------------------------------------------\n");
        stringSplitCompare.simplyTrimedMapa(sortedMapa, "tr").forEach(
                (key, value) -> System.out.println("key: " + key + "\nvalue: " + value));

    }
}
