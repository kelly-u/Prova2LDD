
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author G. Kelly
 */
public class Q3Stax {
  
    //NOME DAS GRAVADORAS + QUANTOS ALBUNS LANCARAM
    
    //Tudo fica dento do main
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlif = XMLInputFactory.newFactory();
        Reader reader=  new FileReader("src/CaetanoVeloso.xml");
        XMLStreamReader xmlsr = xmlif.createXMLStreamReader(reader);
        
        boolean bCompany = false;
        String company;
        
        int qCompany = 0;
        
        while (xmlsr.hasNext()) {
            switch (xmlsr.next()) {
                case XMLStreamReader.START_ELEMENT:
                    String nome = xmlsr.getLocalName();
                    if (nome.equals("company")){
                        bCompany = true;
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    break;
                case XMLStreamReader.CHARACTERS:
                    if(bCompany){
                        company = xmlsr.getText();
                        System.out.println(company);
                    }       
                    bCompany = false;                
                    break;
            }
        }
        xmlsr.close();
    }
    
}
