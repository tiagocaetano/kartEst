/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Precos;

/**
 *
 * @author lca
 */
public class PDefault implements Precos{
	
	private Volta melhorVolta = new Volta(0, 999.999);
	private int voltas;
	
	/**
	 * Nome da Assinatura
	 * @return 
	 */
	@Override
	public String getNome(){
		return "Ocasional";
	}
	
	/**
	 * Custo da aquisição de voltas
	 * @param voltas
	 * @return 
	 */
	@Override
	public double getCusto(int voltas){
		return voltas; // 1 euro por volta
	}
	
	/**
	 * Devolve a melhor volta
	 * @return 
	 */
	@Override
	public Volta getMelhorVolta() {
		return melhorVolta;
	}

	/**
	 * Voltas por fazer
	 * @return 
	 */
	@Override
	public final int getAvVoltas(){
		return voltas;
	}
	
	/**
	 * Aluga voltas 
	 * @param voltas número de voltas a alugar
	 */
	@Override
	public void alugarVoltas(int voltas) {
		this.voltas = voltas;
	}
	
	/**
	 * Termina uma volta
	 * @param volta Dados da volta efectuada
	 * @throws PrecosException 
	 */
	@Override
	public void finalizaVolta(Volta volta) throws PrecosException {
		if (voltas == 0) {
			throw new PrecosException("Limite de Voltas atingido");
		}else {
			voltas--;
			if (melhorVolta.compareTo(volta) < 0){
				melhorVolta = volta;
			}
		}
	}
	
	@Override
	public void finalizaMes(){ 
		// Neste caso, não é necessário fazer nada
	}
	
	public String toString(){
		String str = String.format("Melhor volta:\n\t Tempo: %0.3f -- Kart: %02d",
				this.getMelhorVolta().tempo, this.getMelhorVolta().kartID);
		return str;
	}

}
