import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XmlValidator {
    public static void validate(String xmlPath, String xsdPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new javax.xml.transform.stream.StreamSource(new File(xmlPath)));
            System.out.println("Validation successful!");
        } catch (SAXException | IOException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
