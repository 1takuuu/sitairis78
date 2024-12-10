public class Main {
    public static void main(String[] args) {
        String xmlFile = "src/data.xml";
        String xsdFile = "src/schema.xsd";
        String xslFile = "src/transform.xsl";
        String outputFile = "src/output.html";

        try {
            // 1. Валидация XML
            System.out.println("Validating XML:");
            XmlValidator.validate(xmlFile, xsdFile);

            // 2. Парсинг с использованием DOM
            System.out.println("\nParsing with DOM:");
            XmlParser.parseWithDOM(xmlFile);

            // 3. Парсинг с использованием SAX
            System.out.println("\nParsing with SAX:");
            XmlParser.parseWithSAX(xmlFile);

            // 4. XPath запросы
            System.out.println("\nExecuting XPath query:");
            XPathExample.executeXPathQuery(xmlFile);

            // 5. XSLT-преобразование
            System.out.println("\nPerforming XSLT transformation:");
            XsltTransformer.transform(xmlFile, xslFile, outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
