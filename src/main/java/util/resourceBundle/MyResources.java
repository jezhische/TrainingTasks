package util.resourceBundle;

import org.jetbrains.annotations.NotNull;

import java.util.*;

// The following is a very simple example of a ResourceBundle subclass, MyResources, that manages two resources
// (for a larger number of resources you would probably use a Map). Notice that you don't need to supply a value if a
// "parent-level" ResourceBundle handles the same key with the same value (as for the okKey below).

// default (English language, United States)
public class MyResources extends ResourceBundle {

    @Override
    protected Object handleGetObject(@NotNull String key) {
        if (key.equals("okKey")) return "Ok";
        if (key.equals("cancelKey")) return "Cancel";
        return null;
    }

    @NotNull
    @Override
    public Enumeration<String> getKeys() {
//        keySet() - сам по себе метод из ResourceBundle. Этот метод keySet() всего лишь
// ОБРАЩАЕТСЯ К МЕТОДУ handleKeySet() и просто возвращает то, что возвращает метод handleKeySet().
        return Collections.enumeration(keySet());
    }

    // Overrides handleKeySet() so that the getKeys() implementation
    // can rely on the keySet() value.
    @NotNull
    @Override
//    "Returns a Set of the keys contained only in this ResourceBundle." - в базовом классе, создает этот сет ключей,
// обращаясь к Enumeration<String> getKeys(). Таким образом, в базовом классе получается КРУГОВАЯ ЗАЦИКЛЕННОСТЬ:
// handleKeySet() получает значения из Enumeration<String> getKeys(); getKeys() получает значения из keySet();
// а keySet() получает значения из handleKeySet().
// Но здесь мы его переопределяем, чтобы вернуть то, что нужно нам.
    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList("okKey", "cancelKey"));
    }
}

