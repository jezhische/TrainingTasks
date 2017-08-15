package javaFromTkach.lesson8XML.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Ежище on 07.01.2017.
 */
//@XmlType
public class Worker {
    @XmlAttribute
    private int id;
    @XmlElement
    private String name;
}
