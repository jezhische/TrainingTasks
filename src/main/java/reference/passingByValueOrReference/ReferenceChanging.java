package reference.passingByValueOrReference;

/**
 * Created by WORK_x64 on 25.01.2017.
 */
public class ReferenceChanging {
    /*
    * Ключевой момент: ссылка - это область в памяти, в которой хранится запись адреса, указывающего на ту область
    * памяти, в которой хранится объект. Объект хранится в хипе, ссылка, видимо, в стеке.
    * При присвоении ссылке нового значения (например: Object a = new Object(); Object b = new Object(); a = b;)
    * происходит следующее: в область памяти, где записан адрес объекта a, записывается адрес объекта b, и теперь
    * обе эти ссылки имеют одинаковый адрес и указывают на объект b.
    * Можно сказать, что ссылка - это объект в стеке, в котором хранится адрес реального объекта, где-то в хипе
    * записанного. Это сделано для того, чтобы, если указания (ссылки) на объект хранятся в разных местах, не клонировать
    * каждый раз сам объект (тем более, что это бы уже получался новый объект), а хранить только копии ссылок.
    * Когда мы берем объект для каких-то операций, то мы на самом деле берем ссылку на него и по ней попадаем к объекту.
    * При операциях с объектом (не-immutable объектом!) меняется значение полей объекта, ссылка остается неизменной.
    * При присвоении другого объекта данному переписывается значение ссылки (копируется значение ссылки другого объекта
    * в поле ссылки первого).
    * При использовании ссылки на объект в качестве параметра метода в аргумент метода передается ЗНАЧЕНИЕ ссылки на
    * объект, и это значение КОПИРУЕТСЯ, и если в методе происходит присвоение этой скопированной ссылке другого значения
    * (приравняли объект из аргумента другому объекту), то меняется КОПИЯ значения, это никак не затрагивает ссылку,
    * которая брошена в аргумент (а если в аргумент брошен примитив, то копируется ЗНАЧЕНИЕ этого примитива, и дальше
    * идут манипуляции с КОПИЕЙ этого значения).
    * Поэтому после выхода из метода ссылка, использованная в аргументе, остается нетронутой.
    * А поскольку стек метода закрыт, копия этой ссылки, над которой в методе производились манипуляции, уничтожается.
    * Однако, в методе, пока стек открыт и эта копия ссылки живая, можно пройти по ней до объекта и поменять его поля,
    * и после выхода из метода эти изменения в объекте сохранятся.
    * Таким образом, в методе можно поменять поля объекта, на который указывает ссылка, кинутая в аргумент, но
    * нельзя поменять значение этой ссылки (или этого примитива). См.: http://www.javable.com/columns/robinson/letters/01/
    * и   https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html
    * Поэтому аргументы метода в java всегда передаются ПО ЗНАЧЕНИЮ - это либо значение брошенного в аргументы
    * примитива, либо значение ссылки на объект.
    * В отношении изменения полей объекта в методе - это верно для изменяемого объекта.
    * Однако, что касается immutable объектов (неизменяемых, таких как String, Integer, BigDecimal и вообще любых
    * оберток), здесь ситуация иная. Если использовать, например, Integer i как аргумент метода, ЗНАЧЕНИЕ ССЫЛКИ
    * (записанное в поле i) будет скопировано в методе, как и для изменяемых объектов. Однако, обратиться к полям
    * immutable объекта по этой ссылке невозможно по определению: эти поля недоступны
    * (см., например, http://www.ibm.com/developerworks/ru/library/j-jtp02183/). При попытке изменить ЗНАЧЕНИЕ immutable
    * ОБЪЕКТА (например, значение его поля, хранящего примитив с каким-то числом) будет просто создан новый объект с новым
    * значением (соответственно, значение ссылки тоже поменяется, она теперь содержит адрес нового объекта).
    * Таким образом, теперь внутри стека метода измененная копия ссылки указывает на новый объект. При выходе из
    * метода копия ссылки уничтожается и путь к этому новому объекту становится недоступным (и, поскольку теперь нет
    * ссылки на этот объект, он будет уничтожен сборщиком мусора). Таким образом, исходная ссылка после выхода из метода
    * по-прежнему указывает на исходный неизмененный объект.
    * Если стереть адрес из ссылки (приравнять ее к null), объект становится доступным сборщику мусора.
    * Тип объекта, указанный перед ссылкой (например, String для объекта s, где String s = new String("");), необходим
    * для того, чтобы получить доступ к открытым полям и пропертис класса, обозначенного типом (например, если создать s
    * как обжект: Object s = new String("");, то доступ будет только к полям класса Object)
    * См.: http://www.cyberforum.ru/java-j2se/thread646918.html
    **/
    public int a, b;
    public String c;
    public ReferenceChanging(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static ReferenceChanging tryToChangeReference(ReferenceChanging rech) { // попытка поменять ссылку: сделать так,
        // чтобы значение ссылки rech переписалось на newRech, соответственно, rech уже будет указывать на новый
        // объект, на который ссылается newRech
        ReferenceChanging newRech = new ReferenceChanging(666, 888, "hororo");
        rech = newRech;
        return rech;
    }

    public static void main(String[] args) {
        ReferenceChanging rech = new ReferenceChanging(5, 3, "ku");
        System.out.printf("Before changing: a, b, c:                 %d, %d, %s", rech.a, rech.b, rech.c);
        tryToChangeReference(rech);
        System.out.printf("\nAfter attempt to change: a, b, c:         %d, %d, %s", rech.a, rech.b, rech.c);
        rech = tryToChangeReference(rech);
        System.out.printf("\nAfter changing with equaling: a, b, c:    %d, %d, %s", rech.a, rech.b, rech.c);
        ReferenceChanging hhh = rech;
        rech.a = 598632;
        hhh.b = 874545455;
        System.out.printf("\nrech: a, b, c:                 %d, %d, %s", rech.a, rech.b, rech.c);
        System.out.printf("\nhhh: a, b, c:                 %d, %d, %s", rech.a, rech.b, rech.c);

    }
}