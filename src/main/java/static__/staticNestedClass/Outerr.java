package static__.staticNestedClass;

public class Outerr {
    public /*static*/ interface InnerInterface { // modifier static is redundant - он по-любому будет static
        int print(int a, int b);
    }
}
class Mainn {
    public static void main(String[] args) {
        Outerr outerr = new Outerr();
//        Outerr.InnerInterface ghu = outerr.InnerInterface(); // нельзя создать через объект, только через класс
            // либо так:
//        Outerr.InnerInterface innerMinus = new Outerr.InnerInterface() {
//            @Override
//            public int print(int a, int b) {return a - b;}};
        // либо через лямбду:
        Outerr.InnerInterface innerMinus = (a, b) -> a-b;
        System.out.println(innerMinus.print(56, 13));
    }
}
