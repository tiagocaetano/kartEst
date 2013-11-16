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
	
	private Volta melhorVolta;
	private int voltas;
	private boolean pagames;
	
	public PDefault(){
		melhorVolta = new Volta(0, 999.999);
		pagames = true;
	}
	/**
	 * Nome da Assinatura
	 * @return 
	 */
	@Override
	public String getNome(){
		return "Ocasional";
	}
	
	/**
	 * Verifica se a mensalidade está paga
	 * @return 
	 */
	public final boolean mensalidade() { return pagames; }
	
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
	public final Volta getMelhorVolta() {
		return melhorVolta;
	}
	
	@Override
	public final void setMelhorVolta(Volta volta) { 
		if (melhorVolta.compareTo(volta) > 0){
			melhorVolta = volta;
		}
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
		pagames = false;
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
		}
	}
	
	@Override
	public void finalizaMes(){ 
		pagames = true;
	}
	
	public String toString(){
		String str = String.format("Melhor volta:\n\t Tempo: %0.3f -- Kart: %02d",
				this.getMelhorVolta().tempo, this.getMelhorVolta().kartID);
		return str;
	}

}
