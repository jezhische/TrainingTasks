package lambda.varargProbe;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by Ежище on 03.07.2017.
 */
public class VarargLambda {

    private VarargFuncInterface vfunc;

    VarargLambda(VarargFuncInterface vfunc) {
        System.out.println("VarargLambda instance is created");
        this.vfunc = vfunc;
    }

    public static void print(String printable) {System.out.printf("printable_arg: %s;\n", printable);}

    public static void main(String[] args) {
        VarargFuncInterface vfunc_print = (varargs) -> Arrays.asList(varargs)
                .forEach(a -> System.out.printf("arg: %s;\n", a));
        vfunc_print.run("jhk, jlkhjl, hjhkjhkjh,fbg,bgbgbg, fgfdg".split(","));

        /*VarargLambda varargLambda = */new VarargLambda((vararg) -> {
            Arrays.asList("hh,jhgjhg,bpt".split(",")).forEach(VarargLambda :: print);
            Consumer<String> consumer = a -> System.out.println(Arrays.asList(vararg));
            consumer.accept("");
        }).vfunc.run("kk", "hh");
    }
}
