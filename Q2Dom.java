
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
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
        System.out.println(mapa);
    }
}

class Ano {

    String nome;
    int aGRav;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getaGRav() {
        return aGRav;
    }

    public void setaGRav(int aGRav) {
        this.aGRav = aGRav;
    }

    public Ano(String nome, int aGRav) {
        this.nome = nome;
        this.aGRav = aGRav;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", nome, aGRav);
    }

}
