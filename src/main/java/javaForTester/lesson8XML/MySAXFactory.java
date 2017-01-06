package javaForTester.lesson8XML;

import com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by WORK_x64 on 06.01.2017.
 */
public class MySAXFactory {
    // SAXParser легкий в смысле занимаемой памяти и быстрый, но он не дает структуры, а просто считывает XML-документ
    // с начала и до конца, последовательно отмечая теги.
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();

    public MySAXFactory() throws ParserConfigurationException, SAXException {
    }
    // handler - обработчик, который будет принимать сообщения от парсера parser, читающего файл. Нужно создать класс-,
    // наследник класса DefaultHandler, но здесь просто создаем анонимный класс:
    DefaultHandler handler = new DefaultHandler(){
        // след.метод вызывается, когда найден первый элемент; элементы - это теги, типа <company> или </company> и т.п..
        // uri - это Namespace universal resource identifier(?); (можно ставить "" пустой String)
        // localName - имя элемента (company, department и т.п.) - "local name (without prefix), or the empty string
        // if Namespace processing is not being performed";
        // qName - "qualified name (with prefix), or the empty string if qualified names are not available";
        // attributes - "attributes attached to the element. If there are no attributes, it shall be
        // an empty Attributes object".
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
        }
    // метод, который находит какое-нибудь значение типа "Ivan" между тегами:
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
//            super.characters(ch, start, length);
            System.out.println("Worker " + String.valueOf(ch) + " is found!");
        }
    };

    public static void main(String[] args) {
        try {
            MySAXFactory sax = new MySAXFactory();
            File xmlFile = new File("src\\main\\java\\javaForTester\\lesson8XML\\Company1");
            sax.parser.parse(xmlFile, sax.handler);
            char [] ch = "Ivan".toCharArray();
            sax.handler.characters(ch, 0, 4);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
