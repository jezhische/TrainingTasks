package javaForTester.lesson8XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by WORK_x64 on 06.01.2017.
 */
public class MyDOMFactory {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    public MyDOMFactory() throws ParserConfigurationException {
    }
}
