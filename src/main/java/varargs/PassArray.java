package varargs;

/**
 * Created by WORK_x64 on 24.12.2016.
 * http://www.linkex.ru/java/varargs.php
 */

// Использование массива для передачи методу переменного
// количества аргументов. Это старый стиль подхода
// к обработке аргументов переменной длины.
public class PassArray {
    static void vaTest(int v[]) {
        System.out.print("Количество аргументов: " + v.length + " Содержимое: ");
        for (int x : v)
            System.out.print(x + " ") ;
        System.out.println ();
    }
    public static void main(String args[]) {
// Обратите внимание на способ создания массива
// для хранения аргументов.
        int nl[] = {10};
        int n2[] = {1, 2, 3};
        int nЗ[] = {};
        vaTest(nl); // 1 аргумент
        vaTest(n2); // 3 аргумента
        vaTest(nЗ); // без аргументов
    }
}
