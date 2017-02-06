package io.IOStream.objectInputOutputStream;

import java.io.Serializable;

/**
 * Created by Ежище on 05.02.2017.
 */
public class Serial implements Serializable {
    public int a;
    public String s;
//    public Serial serial = new Serial(5, "srl");
    public void printSerial(String name) {
        System.out.printf("%s.a = %d, %s.s = %s, %s.hashCode = %d\n", name, a, name, s, name, this.hashCode());
    }
    Serial(int a, String s) {
        this.a = a;
        this.s = s;
    }
}
