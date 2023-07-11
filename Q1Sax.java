
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author G. Kelly
 */

// Só falta botar no formato html
public class Q1Sax extends DefaultHandler {

    private int qAuthors = 0;
    private String title;
    private boolean bTitle = false;

    @Override
    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
        super.startElement(string, string1, string2, atrbts);
        switch (string2) {
            case "albums":
                System.out.println("<ul>");
                break;
            case "title":
                bTitle = true;
                break;
            case "author":
                qAuthors ++;
                break;
        }

    }

    @Override
    public void endElement(String string, String string1, String string2) throws SAXException {
        super.endElement(string, string1, string2);
        if (string2.equals("authors")) {
            if (qAuthors > 1) {
                System.out.print("<li>");
                System.out.print(title);
                System.out.println("</li>");
            }
            qAuthors = 0;
            title = "";
        }
        
        if (string2.equals("albums")){
            System.out.println("</ul>");
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        super.characters(chars, i, i1);
        if (bTitle) {
            title = new String(chars, i, i1);
        }
        bTitle = false;
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("src/CaetanoVeloso.xml"), new Q1Sax());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
