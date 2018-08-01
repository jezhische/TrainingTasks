package patterns;

public class nothing {

    private boolean isA;
    public boolean isA() {return true;}
    public int s;
    public String s() {return "What the hell?";}

    public static void main(String[] args) {
        nothing nothing = new nothing();
        System.out.println(nothing.isA);
        System.out.println(nothing.isA());
        System.out.println(nothing.s);
        System.out.println(nothing.s());
    }
}
