package javaFromTkach.lesson8XML.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by Ежище on 07.01.2017.
 */
//@XmlType
public class Department {
    @XmlElement
    private String name;
    @XmlElementWrapper(name = "workers")
    @XmlElement
    private List<Worker> workers;
    @XmlElementWrapper(name = "names")
    @XmlElement
    private List<Name> names;
}
