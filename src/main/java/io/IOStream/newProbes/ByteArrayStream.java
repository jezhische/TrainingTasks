package io.IOStream.newProbes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ежище on 08.08.2017.
 */
public class ByteArrayStream {
    public static void main(String[] args) {
        byte [] bytes = {1, -1, 0, 25};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        int a;
        while((a = bais.read()) != -1) {
            System.out.print(a + "; ");
        }

        System.out.println();
        StringBuilder builder = new StringBuilder();
        bais = new ByteArrayInputStream(bytes);
        for (byte aByte : bytes) {
            builder.append((byte) bais.read() + "; ");
        }
        System.out.println(builder.toString());

        System.out.println();
//        byte[] by = new byte [4];
        List<Integer> list = Arrays.asList(26, 13, 8, 18, 43, 255, 256, 257);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        list.forEach(baos::write);
        bytes = baos.toByteArray();
        try {
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (byte aByte : bytes) {
            System.out.print(aByte + "; ");
        }

    }
}
