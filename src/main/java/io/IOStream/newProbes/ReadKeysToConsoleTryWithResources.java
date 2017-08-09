package io.IOStream.newProbes;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WORK_x64 on 07.08.2017.
 */
public class ReadKeysToConsoleTryWithResources {
    public static void main(String[] args) {
        System.out.println("~ to exit");
        try(InputStreamReader input = new InputStreamReader(System.in)) {
            char c;
            do {
                c = (char)input.read();
                System.out.print(c);
            } while (c != '~');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
