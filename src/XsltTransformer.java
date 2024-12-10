import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XsltTransformer {
    public static void transform(String xmlFile, String xslFile, String outputFile) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new File(xslFile)));
        transformer.transform(new StreamSource(new File(xmlFile)), new StreamResult(new File(outputFile)));
        System.out.println("Transformation completed. Output saved to: " + outputFile);
    }
}
