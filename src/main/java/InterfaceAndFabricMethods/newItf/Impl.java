package InterfaceAndFabricMethods.newItf;

import java.io.IOException;

public class Impl implements ForImpl{

    @Override
    public Number doit() throws IOException { // NB: можно и не пробрасывать исключение - почему?
        return new Integer(5);
    }

    public Object implementProbe(Object o) {
        return (String)o;
    }

    public Object go() throws Exception {
        return implementProbe(doit());
    }

    public static void main(String[] args) throws Exception {
        Impl impl = new Impl();
        System.out.println(impl.go()); // ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    }

}
