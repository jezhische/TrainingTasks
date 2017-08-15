package reference.passingByValueOrReference;

/**
 * Created by WORK_x64 on 24.01.2017.
 */
public class TestClassFields implements Cloneable {
    /*
    * Основной вывод здесь: ссылка на объект не меняется после того, как он был закинут в метод, им поманипулировали и
    * внутри стека метода попытались приравнять его к чему-то еще. А вот поля объекта, если в методе они менялись,
    * останутся измененными после выхода из метода.
    * Просто примитивная переменная или объект-переменная в обертке не изменится после манипуляций ею в методе, и
    * не-статическая, и СТАТИЧЕСКАЯ ТАКЖЕ.
    * **/


    int a = 5;
    static int b = 10;
    String str = "kuu";
    public static void changeFields(TestClassFields tcf) {
        tcf.a = 333;
        b = 666;
        tcf.str = "bebebe";
    }
    @Override
    public boolean equals (Object obj) {
        if (obj instanceof TestClassFields)
            return (((TestClassFields)obj).a == a && ((TestClassFields)obj).str.equals(str));
        return super.equals(obj);
    }
    @Override
    public TestClassFields clone() throws CloneNotSupportedException { // TODO: ATTENTION! This is not authentic clone()!
        TestClassFields newTcp = (TestClassFields)super.clone();
//        newTcp.a = a;
////        b = 999999;
//        newTcp.str = str;
        return newTcp;
//        return (TestClassFields)super.clone();
    }
    public static TestClassFields changeReference(TestClassFields tcf) throws CloneNotSupportedException {
        TestClassFields newTcp = new TestClassFields();
        tcf = newTcp.clone();
        return tcf;
    }

    public static int changePrimitive(int i) {
        ++i;
        return i;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClassFields tcf = new TestClassFields();
        System.out.printf("Before changeFields: tcf.a = %s, b = %s, tcf.str = %s", tcf.a, b, tcf.str);
        changeFields(tcf);
        System.out.printf("\nAfter changeFields: tcf.a = %s, b = %s, tcf.str = %s", tcf.a, b, tcf.str);
        TestClassFields tcf2 = (TestClassFields) tcf.clone();
        System.out.println("After cloning:");
        System.out.println("(tcf2.equals(tcf)) = " + (tcf2.equals(tcf))); // поскольку я переопределил equals()
        System.out.println("(tcf2 == tcf) = " + (tcf2 == tcf));
        System.out.printf("After cloning: tcf2.a = %s, b = %s, tcf2.str = %s", tcf2.a, b, tcf2.str);
        changeReference(tcf);
        System.out.printf("\nAfter changeReference: tcf.a = %s, b = %s, tcf.str = %s", tcf.a, b, tcf.str);
        TestClassFields tcfChangeReference = changeReference(tcf);
        System.out.printf("\nchangeReference returns: tcfChangeReference.a = %s, b = %s, tcfChangeReference.str " +
                        "= %s", tcfChangeReference.a, b, tcfChangeReference.str);
        tcf = changeReference(tcf);
        System.out.printf("\nAfter equaling tcf = changeReference(tcf): tcf.a = %s, b = %s, tcf.str = %s", tcf.a, b, tcf.str);
        b = 99999;
        System.out.println("\nstatic int b = " + b);
        System.out.println("++b = " + ++b);
        System.out.println("b = " + b);
        int k = 99999;
        System.out.println("\nnon-static int k = " + k);
        System.out.println("++k = " + ++k);
        System.out.println("k = " + k);

        int iNonstatic = 44;
        int iStatic = 22;
        System.out.printf("\nBefore changePrimitive: iNonstatic = %d, iStatic = %d", iNonstatic, iStatic);
        changePrimitive(iNonstatic);
        changePrimitive(iStatic);
        System.out.printf("\nAfter changePrimitive: iNonstatic = %d, iStatic = %d", iNonstatic, iStatic);
        System.out.printf("\nchangePrimitive returns: changePrimitive(iNonstatic) = %d, changePrimitive(iStatic) = %d",
                changePrimitive(iNonstatic), changePrimitive(iStatic));

    }
}
