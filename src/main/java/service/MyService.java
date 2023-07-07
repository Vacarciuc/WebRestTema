package service;

import service.entites.Language;
import service.parsing.ParsingXML;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

@Path("/AddService/{word}/{firstLang}/{secondLang}")
public class MyService {

    @GET
    public String getMessage(@PathParam("word") String word,
                             @PathParam("firstLang") String firstLang,
                             @PathParam("secondLang") String secondLang) throws XMLStreamException, FileNotFoundException {
        ParsingXML parsingXML=new ParsingXML();
        return parsingXML.ParsingXMLFunction(word, firstLang, secondLang);
    }
}
