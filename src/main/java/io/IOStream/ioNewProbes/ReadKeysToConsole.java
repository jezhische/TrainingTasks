package io.IOStream.ioNewProbes;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WORK_x64 on 07.08.2017.
 */
public class ReadKeysToConsole {
    public static void main(String[] args) {
        InputStreamReader input = null;
        try {
            input = new InputStreamReader(System.in);
            System.out.println("~ для выхода");
            char c;
            do {
                c = (char) input.read();
                System.out.print(c);
            }
            while (c != '~');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null)
                try {
                input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
