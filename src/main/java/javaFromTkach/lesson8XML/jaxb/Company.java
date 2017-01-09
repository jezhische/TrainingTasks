package javaFromTkach.lesson8XML.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Ежище on 07.01.2017.
 */
@XmlRootElement
public class Company {
    @XmlAttribute
    private int id;
    @XmlElementWrapper(name = "departments")
    @XmlElement
    private List<Department> departments;
}
