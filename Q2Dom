
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

/* Em qual ANO o artista lançou mais ÁLBUNS
e QUANTOS ÁLBUNS foram lançados?
Vai ter que ter uma estrutura que vai associar ANOS a quantidade de ÁLBUNS
Depois mandar ordenar.
O que tiver mais álbuns, devem ser impressos

Na prova é qual TIME teve mais PONTOS (só faltou QNTS pontos)
Vai ter que ter uma estrutura que vai associar TIMES a quantidade de PONTOS
Depois mandar ordenar.
O que tiver mais pontos, devem ser impressos

Saída esperada:
< year count ="3"> 1972 </ year >*/

public class Q2Dom {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("src/CaetanoVeloso.xml"));
        // Um cara, crachá. A string ANO vai estar associada a um integer QNT DE ÁLBUNS NO ANO (String)
        Map<String, Integer> mapa = new HashMap();
          
        // Precisa saber o nome dos times (elementos)
        // EU preciso saber o ano dos jogos (atributos)
        NodeList album = doc.getElementsByTagName("album");
        for (int i = 0; i < album.getLength(); i++) {
            Element a1 = (Element) album.item(i);
            System.out.println(a1.getAttribute("year"));
        }
    }
}
