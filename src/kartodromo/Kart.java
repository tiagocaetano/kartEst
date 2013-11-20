
package kartodromo;
/**
 *
 * @author lca
 */
import Precos.Volta;

public class Kart {
	private Piloto piloto;
	private int kartid;
	
	public Kart(int id){
		piloto = null;
		this.kartid = id;
	}
	
	public int getId(){ return kartid; }
	
	public Boolean temPiloto(){ return (piloto == null); }
	
	public boolean assignPiloto(Piloto piloto){
		if (piloto.iniciaProva()) {
			this.piloto = piloto;
			return true;
		} else {
			return false;
		}
	}
	
	public void removePiloto(){
		piloto.terminaProva();
		this.piloto = null;
	}
	
	public void terminaVolta(Volta volta){
		if (piloto != null) {
			piloto.terminaVolta(volta);
		}
	}
}
