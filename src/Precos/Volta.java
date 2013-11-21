package Precos;

/**
 * Classe que envolve os dados de uma volta
 * @author lca
 */
public class Volta implements Comparable<Volta> {
	int kartID;
	Double tempo;
	
	public Volta(int kart, Double tempo){
		this.kartID = kart;
		this.tempo = tempo;
	}
	
	/**
	 * Devolve o id do kart que efectuou a volta
	 * @return 
	 */
	public int getKartID(){ return this.kartID; }
	
	/**
	 * Devolve o tempo efectuado na volta
	 * @return 
	 */
	public Double getTempo(){ return this.tempo; }
	
	/**
	 * Implementação do interface Comparable
	 * Nota: Esta classe tem uma ordem natural incompatível com a igualdade entre objectos
	 * @param v
	 * @return 
	 */
	@Override public int compareTo(Volta v) {
		return v.getTempo().compareTo(this.tempo);
	}
	
	/**
	 * Representação em forma de texto do objecto
	 * @return 
	 */
	@Override public String toString(){
		return String.format("Kart [ %02d ] - %6.3f segundos", kartID, tempo);
	}
}
