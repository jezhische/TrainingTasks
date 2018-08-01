package util.resourceBundle;

import org.jetbrains.annotations.NotNull;

import java.util.*;

// German language
public class MyResources_de extends MyResources {

    @Override
    public Object handleGetObject(@NotNull String key) {
        // don't need okKey, since parent level handles it.
//  Т.е., мне нет необходимости переопределять пару ключ-значение, если в базовом классе эта пара точно такая же.
        if (key.equals("cancelKey")) return "Abbrechen";
// Вот как-то ни фига, похоже, все-таки нужно, иначе null возвращает:
        if (key.equals("okKey")) return super.handleGetObject("okKey");
        return null;
    }

    @NotNull
    @Override
    protected Set<String> handleKeySet() {
//        return new HashSet<String>(Arrays.asList("cancelKey"));
        return super.handleKeySet();
    }
}

class MyResources_deMain {
    public static void main(String[] args) {
        MyResources myResources_de = new MyResources_de();
        System.out.println(myResources_de.handleGetObject("cancelKey"));
        System.out.println(myResources_de.handleGetObject("okKey"));

        MyResources myResources = new MyResources();
        System.out.println(myResources.handleGetObject("cancelKey"));
        System.out.println(myResources.handleGetObject("okKey"));

        System.out.println("//////");

//        while (myResources_de.getKeys().hasMoreElements()) System.out.println(myResources_de.getKeys().nextElement());

        Iterator<String> iterator = myResources_de.handleKeySet().iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
