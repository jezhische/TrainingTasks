package collectionsAndMaps.garbage;

public class IncapsPr {
    class Sample {
        private String ou = "ouu";
        private A aa;
        public String getOu() {return ou;}
        public A getAa() {
            return aa;
        }
    }
    class A{}

    public static void main(String[] args) {
        Sample sample = new IncapsPr().new Sample();
        String s = sample.getOu() ;
        s = "uhuh";
        System.out.println(sample.getOu()); // ouu   //String is immutable, "uhuh" - this is new undependent instance

        A a = new IncapsPr().new A();
        System.out.println(a);
        a = new IncapsPr().new A();
        System.out.println(a); // hash codes are different, as A is not immutable
    }
}
