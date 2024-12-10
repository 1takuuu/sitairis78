import javax.xml.xpath.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class
XPathExample {
    public static void executeXPathQuery(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();

        // Поиск всех авторов
        XPathExpression expr = xpath.compile("//author");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("Author: " + nodes.item(i).getTextContent());
        }
    }
}
