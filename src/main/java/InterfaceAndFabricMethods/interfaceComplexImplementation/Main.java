package InterfaceAndFabricMethods.interfaceComplexImplementation;

public class Main {
    public static void main(String[] args) {
        ComplexImplemChild anonym = new ComplexImplemChild() {
            @Override
            public String getSomething(String something) {
                return super.getSomething(something) + " in anonym Child";
            }
        };

        System.out.println(ComplexIn.complexIn);
        System.out.println(new ComplexImplemChild().complexIn);
        System.out.println(ComplexImplemChild.complexIn);
        System.out.println(anonym.complexIn);
        System.out.println(anonym.getSomething("something"));
        System.out.println(new ComplexImplemChild().getSomething("something"));
        new ComplexImplemChild().printAbstr();
        new ComplexImplemChild().printConcr();
    }
}
