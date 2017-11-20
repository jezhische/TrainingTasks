package InterfaceAndFabricMethods.interfaceComplexImplementation;

abstract class AbstractComplexImplem implements ComplexIn {
    @Override
    public void printAbstr() {
        System.out.println("printAbstr() overrided in AbstractComplexImplem");
    }

    @Override
    public void printConcr() {
        System.out.println("printConcr() overrided in AbstractComplexImplem");

    }
}
