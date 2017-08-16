package io.IOStream.newProbes.serialization;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*@RunWith(JUnit4.class)*/
public class ObjectIOStreamTest /*extends TestCase*/ {
    ObjectIOStream stream;
    ForTest test;

    @Before
    public void setUp() throws Exception {
        stream = new ObjectIOStream();
        test = new ForTest(9);
    }

    @After
    public void tearDown() throws Exception {
        stream = null;
        test = null;
    }

    @Test
    public void writeObject() throws Exception {
    }

    @Test
    public void readObject() throws Exception {
    }



    @Test(expected = FileNotFoundException.class)
    public void readObjectEx() {
        stream.readObject("src\\main\\java\\io\\IOStream\\newProbes\\serialization\\dataFiles\\zzz.txt");
    }

    @Test
    public void readObjectExTryCatch() throws Exception {
        try {
            stream.readObject("src\\main\\java\\io\\IOStream\\newProbes\\serialization\\dataFiles\\zzz.txt");
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("src\\main\\java\\io\\IOStream\\newProbes\\serialization\\dataFiles\\" +
                    "zzz.txt (Не удается найти указанный файл)"));
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void readObjectExRule() throws Exception {
        thrown.expect(ClassNotFoundException.class);
//        thrown.expectMessage(containsString("src\\main\\java\\io\\IOStream\\newProbes\\serialization\\" +
//                "dataFiles\\zzz.txt (Не удается найти указанный файл)"));
//        throw new FileNotFoundException();


        stream.readObject("src\\main\\java\\io\\IOStream\\newProbes\\serialization\\dataFiles\\zzz.txt");

    }

}