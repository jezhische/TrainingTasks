package InterfaceAndFabricMethods.interfaceComplexImplementation;

public class ComplexImplem extends AbstractComplexImplem implements ComplexIn {
    @Override
    public void printConcr() {
        System.out.println("printConcr() overrided in ComplexImplem");

    }

    @Override
    public String getSomething(String something) {
        return something;
    }
}
