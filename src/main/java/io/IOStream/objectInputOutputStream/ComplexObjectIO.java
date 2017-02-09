package io.IOStream.objectInputOutputStream;

import java.io.*;

/**
 * Created by Ежище on 07.02.2017.
 * http://www.intuit.ru/studies/courses/16/16/lecture/27133?page=3
 */
public class ComplexObjectIO {
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}
