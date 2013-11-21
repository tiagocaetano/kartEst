
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
	
	public boolean temPiloto(){ return (piloto != null); }
	
	public boolean assignPiloto(Piloto piloto, int voltas){
		if (piloto.iniciaProva(voltas)) {
			this.piloto = piloto;
			return true;
		} else {
			return false;
		}
	}
	
	public void terminaVolta(Double tempo){
		if (piloto != null) {
			try{
				piloto.terminaVolta(new Volta(kartid, tempo));
				if (!piloto.estaEmProva())
					this.piloto = null;
			}catch (Exception e){
				this.piloto = null;
			}
		}
	}
	
	@Override public String toString(){
		String str = String.format(" Kart [ %02d ]", kartid);
		if (piloto != null) {
			str += String.format(" - Piloto [ %02d ] %s", piloto.getId(), piloto.getNome());
		}
		return str;
	}
}
