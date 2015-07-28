
import org.jdom.Document;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ajay
 */
public class MapToXmlGenerator {

    public static void main(String args[]) {
        Map<String, String> map = new HashMap<String, String>();
        List<Map<String,String>> data = new ArrayList<Map<String, String>>();
        map.put("name", "vishu");
        map.put("cast", "soni");
        data.add(map);
        map.put("name","rishu");
        map.put("cast","verma");
        data.add(map);
        Element element = MapToXmlGenerator.writeXmlFile(data);
    }

    /**
     * (non-Javadoc)
     *
     * Method writeXmlFile() will convert the map key as tag and map value as value of the tag in xml.
     * @param data passing the list of map.
     * @return the xml root element containing all information about the xml elements.
     */
    private static Element writeXmlFile(List<Map<String, String>> data) {

        Element rootElement = new Element("funds");
        Document document = new Document(rootElement);
        document.setRootElement(rootElement);

        for (Map<String, String> fundDataForXML : data) {
            Element fund = new Element("fund");
            for (Map.Entry<String, String> iterator : fundDataForXML.entrySet()) {
                String key = iterator.getKey();
                String value = iterator.getValue();
                Element element = new Element(key);
                element.setText(value);
                fund.addContent(element);
            }
            document.getRootElement().addContent(fund);
        }
        return document.getRootElement();
    }
}
