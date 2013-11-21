
package kartodromo;
import Precos.Volta;

/**
 * Representa um kart e o seu estado actual
 * @author lca
 */
public class Kart {
	private Piloto piloto;
	private int kartid;
	
	public Kart(int id){
		piloto = null;
		this.kartid = id;
	}
	
	/**
	 * Devolve o número do kart
	 * @return 
	 */
	public int getId(){ return kartid; }
	
	/**
	 * Verifica se o kart tem um piloto atribuído
	 * Nota: Resultado passível de ser alterado pela thread do painel de voltas
	 * @return 
	 */
	public boolean temPiloto(){ return (piloto != null); }
	
	/**
	 * Atribui um piloto ao kart e coloca o mesmo em prova
	 * @param piloto piloto
	 * @param voltas número de voltas que o piloto vai efectuar
	 * @return Devolve 'FALSE' se o piloto já está prova
	 */
	public boolean assignPiloto(Piloto piloto, int voltas){
		if (piloto.iniciaProva(voltas)) {
			this.piloto = piloto;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Informa o piloto do final da prova e tempo efectuado
	 * @param tempo 
	 */
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
	
	/**
	 * Representação em forma de texto do objecto
	 * @return 
	 */
	@Override public String toString(){
		String str = String.format(" Kart [ %02d ]", kartid);
		if (piloto != null) {
			str += String.format(" - Piloto [ %02d ] %s", piloto.getId(), piloto.getNome());
		}
		return str;
	}
}
