package services;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author SANTY
 */
public class CalcProxy {
    
    
    public String locateService(String serviceName) {
        String urlService;
        try {
            File file = new File("files/calcserver.xml");
            DocumentBuilderFactory docF = DocumentBuilderFactory.newInstance();
            DocumentBuilder docB = docF.newDocumentBuilder();
            Document doc = docB.parse(file);
            doc.getDocumentElement().normalize();
            
            System.out.println("=> Searching in calcserver.xml . . . .");
            System.out.println("> root of xml file: " + doc.getDocumentElement().getNodeName());
            
            NodeList urls = doc.getElementsByTagName("url");
            Node url;
            
            if (serviceName.equals("sumar") || serviceName.equals("multiplicar")) {
                url = urls.item(0);
                urlService = url.getTextContent();
                System.out.println("> name: " + url.getNodeName() + " - value: " + urlService);
            } else if (serviceName.equals("restar") || serviceName.equals("dividir")) {
                url = urls.item(1);
                urlService = url.getTextContent();
                System.out.println("> name: " + url.getNodeName() + " - value: " + urlService);
            } else {
                urlService = "error: Could not find the service";
//                System.out.println("> could not find the service");
            }
            return urlService;
        } catch (IOException ex) {
            ex.printStackTrace();
            return "error: Archivo corrupto";
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            return "error: Archivo corrupto";
        } catch (SAXException ex) {
            ex.printStackTrace();
            return "error: Archivo corrupto";
        }
    }
    
}
