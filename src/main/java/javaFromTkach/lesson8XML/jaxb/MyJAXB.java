package javaFromTkach.lesson8XML.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ежище on 07.01.2017.
 */
public class MyJAXB {
    JAXBContext context = JAXBContext.newInstance(Company.class, Department.class, Worker.class, Name.class); // раньше,
    // видимо, нужно было создавать массив в аргументах: (new Class[]{Company.class, Department.class}) и т.д.,
    // теперь достаточно varargs.

    public MyJAXB() throws JAXBException {
    }

    Unmarshaller unmarshaller = context.createUnmarshaller();
    Marshaller marshaller = context.createMarshaller();

    public static void main(String[] args) throws JAXBException, IOException {
        MyJAXB my = new MyJAXB();
        File fileToRead = new File("src//main//java//javaFromTkach//lesson8XML//Company1");
        Company comp = (Company) my.unmarshaller.unmarshal(fileToRead);

        File fileToWrite = new File("src//main//java//javaFromTkach//lesson8XML//jaxb//Company2");
        fileToWrite.createNewFile();
        my.marshaller.marshal(comp, fileToWrite);
    }
}
