
package Precos;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Esta classe é responsável para ler a tabela de preços de um ficheiro e 
 * disponibilizar os valores à classe Preço.
 * @author lca
 */
public final class MeusPrecos {
	
	private static MeusPrecos singleMe = null;
	private HashMap<String,Precario> precarios = new HashMap<>();
	
	private MeusPrecos() throws PrecosException {
		try {
			File tprecos = new File("tprecos.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(tprecos);
			doc.getDocumentElement().normalize();
			NodeList tabela = doc.getElementsByTagName("tarifario");
			Precario p;
			Element dom;	//Elemento do Document Object Model
			String val;
			for (int i = 0; i < tabela.getLength(); i++) {				
				if (tabela.item(i).getNodeType() == Node.ELEMENT_NODE) {
					dom = (Element) tabela.item(i);
					p = new Precario(dom.getAttribute("nome"));
					
					val = dom.getElementsByTagName("bonus").item(0).getTextContent();
					p.setBonus( Integer.parseInt(val));
					
					val = dom.getElementsByTagName("lfbonus").item(0).getTextContent();
					p.setlfBonus( Integer.parseInt(val));
					
					val = dom.getElementsByTagName("mensalidade").item(0).getTextContent();
					p.setMensalidade(Double.parseDouble(val));
					
					val = dom.getElementsByTagName("taxas").item(0).getTextContent();
					p.setPTaxa(Double.parseDouble(val));
					
					val = dom.getElementsByTagName("volta").item(0).getTextContent();
					p.setPVolta(Double.parseDouble(val));
					precarios.put(p.getNome(), p);
				}				
			}			
		} catch (Exception ex) { 
			throw new PrecosException("Erro de leitura do preçário: " + ex.getMessage());
		}
	}
	
	public static MeusPrecos getInstance() {
      if (singleMe == null) {
			singleMe = new MeusPrecos();
		}
      return singleMe;
    }
	
	public final Precario getPrecario(String nome) { return precarios.get(nome); }
}
