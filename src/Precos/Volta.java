package Precos;

/**
 *
 * @author lca
 */
public class Volta implements Comparable<Volta> {
	int kartID;
	Double tempo;
	
	public Volta(int kart, Double tempo){
		this.kartID = kart;
		this.tempo = tempo;
	}
	
	public int getKartID(){ return this.kartID; }
	
	public Double getTempo(){ return this.tempo; }
	
	@Override
	public int compareTo(Volta v) {
		return v.getTempo().compareTo(tempo);
	}
}
