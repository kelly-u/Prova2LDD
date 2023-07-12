
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author G. Kelly
 */

public class Q2Dom {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("src/CaetanoVeloso.xml"));
        List<Ano> mapa = new ArrayList();
        
        NodeList album = doc.getElementsByTagName("album");
        for (int i = 0; i < album.getLength(); i++) {
            Element alb1 = (Element) album.item(i);
            String ano = alb1.getAttribute("year");

            Ano ano1 = mapa.stream().filter(a -> a.getNome().equals(ano)).findFirst().orElse(null);
            if (ano1 != null) {
                int qG = ano1.getaGRav();
                qG += 1;
                ano1.setaGRav(qG);

            } else {
                Ano temp = new Ano(ano, 1);
                int p1 = temp.getaGRav();
                temp.setaGRav(p1);
                mapa.add(temp);
            }
        }

        mapa.sort((Ano o1, Ano o2) -> o2.getaGRav() - o1.getaGRav());
  
        Ano a = new Ano(mapa.get(0).getNome(), mapa.get(0).getaGRav());
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Ano.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.marshal(a, System.out);
               
    }
}


@XmlRootElement(name="ano")
class Ano {
    String nome;
    int aGRav;
    
    public Ano(String n, int a) {
        this.nome = n;
        this.aGRav = a;
    }
    public Ano(){}
    
    @XmlElement(name="year")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @XmlAttribute(name="count")
    public int getaGRav() {
        return aGRav;
    }

    public void setaGRav(int aGRav) {
        this.aGRav = aGRav;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", nome, aGRav);
    }

}
