package service.parsing;



import service.entites.Language;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ParsingXML {
    public String ParsingXMLFunction(String word, String firstLang, String secondLang) throws FileNotFoundException, XMLStreamException {
        String memoryVar=null;
        boolean x=false;
        List<String>stringList=new ArrayList<>();

        //@Autowire//
        Language language=new Language();

        //maping function
        XMLInputFactory xmlInputFactory=XMLInputFactory.newFactory();
        Reader reader=new FileReader("C:\\Users\\enigma\\Downloads\\restDownload\\WebRestTema\\src\\translation.xml");
        //
        XMLStreamReader xmlStreamReader=xmlInputFactory.createXMLStreamReader(reader);
        while (xmlStreamReader.hasNext()){
            switch (xmlStreamReader.next()){
                case XMLStreamReader.START_ELEMENT:{
                    String elementName=xmlStreamReader.getName().toString();
                    stringList.add(elementName);
                    if (elementName.equals(firstLang)) {
                        language.setFirstLanguage(xmlStreamReader.getElementText().toString());
                    } else if (elementName.equals(secondLang)) {
                        language.setSecondLanguage(xmlStreamReader.getElementText().toString());
                        if (word.equals(language.getFirstLanguage())){
                            memoryVar=language.getSecondLanguage();
                        }else if (memoryVar==null){
                            memoryVar="cuvant inexistent";
                        }
                    }
                }
                break;
            }
        }
        if (!(stringList.contains(firstLang)) || (!(stringList.contains(secondLang)))){
            memoryVar="Va rugam sa va asigurati ca ati introdus corect cuvintele";
        }
        return memoryVar;
    }
}
