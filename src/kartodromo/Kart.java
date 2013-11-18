
package kartodromo;
/**
 *
 * @author lca
 */
import Precos.Volta;

public class Kart {
	private Piloto piloto;
	private static int count=0;
	private int kartID;
	
	public Kart(){
		piloto = null;
		kartID = Kart.count++;
	}
	
	public void assignPiloto(Piloto piloto){
		this.piloto = piloto;
	}
	
	public void removePiloto(){
		this.piloto = null;
	}
	
	public void terminaVolta(Volta volta){
		if (piloto != null) {
			piloto.terminaVolta(volta);
		}
	}
}
