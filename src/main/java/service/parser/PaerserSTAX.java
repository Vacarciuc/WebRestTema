package service.parser;

import service.entites.Entites;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class PaerserSTAX {

    public String ParsingXmlFunction(String continent, String city) throws FileNotFoundException, XMLStreamException {

        String memoryVar=null;
        String time=null;

        Entites entites=new Entites();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        Reader reader = new FileReader("D:\\Lucrari_JAVA\\TimeZoneWithXML\\src\\timeZone.xml");
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    String elementName=xmlStreamReader.getName().toString();
                    switch (elementName) {
                        case "continent":
                            String attributeValueContinent = xmlStreamReader.getAttributeValue(0);
                            entites.setContinent(attributeValueContinent);
                            break;

                        case "city":
                            String atributeValueCity=xmlStreamReader.getAttributeValue(0);
                            entites.setCity(atributeValueCity);
                            break;

                        case "utc":
                            String atrinuteElementUTC=xmlStreamReader.getElementText();
                            entites.setUtc(atrinuteElementUTC);
                            if (entites.getContinent().equals(continent)){
                                if (entites.getCity().equals(city)){
                                    memoryVar=entites.getUtc();
                                }
                            }
                            break;
                    }
                    break;
            }
        }
        if (memoryVar!=null) {
            Instant instant = Instant.now();
            ZoneOffset zoneOffset = ZoneOffset.of(memoryVar);
            OffsetDateTime odt = OffsetDateTime.ofInstant(instant, zoneOffset);
            time = odt.getHour() + ":" + odt.getMinute() + ":" + odt.getSecond() + "   " +
                    "" + odt.getDayOfMonth() + ":" + odt.getMonth() + ":" + odt.getYear();
        }
        if (memoryVar==null){
            time="Continentul sau orasul introdus nu exista in lista";
        }
        return time;
    }
}
