import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;

public class XmlParser {

    // DOM-парсер
    public static void parseWithDOM(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));

        NodeList books = doc.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            System.out.println("Book ID: " + book.getAttribute("id"));
            System.out.println("Title: " + book.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Author: " + book.getElementsByTagName("author").item(0).getTextContent());
            System.out.println("Price: " + book.getElementsByTagName("price").item(0).getTextContent());
            System.out.println("Currency: " + book.getElementsByTagName("price").item(0).getAttributes().getNamedItem("currency").getTextContent());
        }
    }

    // SAX-парсер
    public static void parseWithSAX(String filePath) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("book")) {
                    System.out.print("Book ID: " + attributes.getValue("id"));
                } else if (qName.equals("title") || qName.equals("author") || qName.equals("price")) {
                    System.out.print(qName + ": ");
                }
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println(new String(ch, start, length));
            }
        };
        saxParser.parse(new File(filePath), handler);
    }
}
