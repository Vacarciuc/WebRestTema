package service;

import service.parser.PaerserSTAX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

@Path("/AddService/{continents}/{city}")
public class MyService {

    @GET
    public String getMessage(@PathParam("continents") String continent,
                             @PathParam("city") String city) throws XMLStreamException, FileNotFoundException {
        PaerserSTAX paerserSTAX=new PaerserSTAX();
        return paerserSTAX.ParsingXmlFunction(continent, city);
    }
}
