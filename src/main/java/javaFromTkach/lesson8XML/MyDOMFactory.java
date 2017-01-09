package javaFromTkach.lesson8XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by WORK_x64 on 06.01.2017.
 */
public class MyDOMFactory {
//    JDOM - попробовать найти
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    public MyDOMFactory() throws ParserConfigurationException, IOException, SAXException {
    }

    public static Document getDocument (File xmlFile) throws IOException, SAXException, ParserConfigurationException {
        return new MyDOMFactory().builder.parse(xmlFile);
//        return new MyDOMFactory().factory.newDocumentBuilder().parse(xmlFile); // (или так)
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException,
    IllegalArgumentException {
        File xmlFile = new File("src\\main\\java\\javaFromTkach\\lesson8XML\\Company1");
        Document doc = getDocument(xmlFile);
        // вызов root-элемента <company> - это образец класса Element:
        Element e = doc.getDocumentElement();
        System.out.println(e.getTagName());
//        Node firstNode = e.getFirstChild();
//        System.out.println(firstNode.getNodeName());
//        System.out.println(firstNode.hasChildNodes());
//        System.out.println(e.getTextContent());
//
//        NodeList nodeList = e.getChildNodes();
//        System.out.println(nodeList);
        System.out.println(e.getElementsByTagName("department").item(0).getNodeValue());
        System.out.println(e.getAttribute("id"));
        System.out.println(e.getAttributeNode("id"));
        Node n = e.getFirstChild();
        System.out.println(n.getNextSibling().getTextContent());
        e.setAttribute("id", "18");
        n.setNodeValue("fff");
        System.out.println(e.getAttributeNode("id"));
        System.out.println(n.getAttributes());

        NodeList nodeList = e.getChildNodes();
        System.out.println("nodeList.getLength() = " + nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nn = nodeList.item(i);
            System.out.println("item(" + i + ") = " + nn.getNodeValue() + ", TextContent = " + nn.getTextContent());
        }


//        System.out.println(doc.getElementsByTagName("workers"));
//        System.out.println(doc.getElementById("1"));

    }
}
