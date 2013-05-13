package util;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author SANTY
 */
public class Parser {
    private NodeList operations;
    private Node operation;
    private int indexOperation;
    
    public Boolean openFile(String file) {
        DocumentBuilderFactory docF;
        DocumentBuilder docB;
        Document doc;
        File f;
        try {
            f = new File(file);
            docF = DocumentBuilderFactory.newInstance();
            docB = docF.newDocumentBuilder();
            doc = docB.parse(f);
            doc.getDocumentElement().normalize();
            operations = doc.getElementsByTagName("webservice");
            indexOperation = 0;
            
            System.out.println("> root of xml file: " + doc.getDocumentElement().getNodeName());
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            return false;
        } catch (SAXException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Boolean getNextOperation() {
        try {
            operation = operations.item(indexOperation ++);
            operation.getTextContent();
            return true;
        } catch (Exception ex) {
            System.out.println("> found " + (indexOperation - 1) + " operations");
            return false;
        }
    }
    
    public String getOperation() {
        Element method;
        try {
            method = (Element) operation;
            return method.getElementsByTagName("method").item(0).getTextContent();
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String getParameter(String param) {
        NodeList paramsList;
        Element params, p1;
        try {
            params = (Element) operation;
            paramsList = params.getElementsByTagName("params");
            p1 = (Element) paramsList.item(0);
            return p1.getElementsByTagName(param).item(0).getTextContent();
        } catch (Exception ex) {
            return "";
        }
    }

    public void setResult(String r) {
        Element result;
        try {
            result = (Element) operation;
            result.getElementsByTagName("result").item(0).setTextContent(r);
        } catch (Exception ex) {
            System.out.println("> override xml file error");
        }
    }
    
}