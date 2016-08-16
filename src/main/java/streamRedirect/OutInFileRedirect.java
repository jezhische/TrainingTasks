package streamRedirect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Ежище on 15.08.2016.
 */
public class OutInFileRedirect {
    OutInFileRedirect() {}
    PrintStream output;
    OutInFileRedirect(PrintStream output){this.output = output;}
public File printInFile(){
    try(PrintStream output = new PrintStream(new FileOutputStream("src\\main\\resources\\testSupport\\output.txt"))) {
        System.setOut(output);
        System.out.println("45456456564456");
    }
    catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
    return new File("src\\main\\resources\\testSupport\\output.txt");
}

    public static void main(String[] args) {
        OutInFileRedirect outp = new OutInFileRedirect();
        System.out.println("asasasa");
        outp.printInFile();
        System.out.println("kbjn 564\nkjlk 123");
//        OutInFileRedirect oifr = new OutInFileRedirect();


    }
}
