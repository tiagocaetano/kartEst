package Precos;

/**
 * Assinatura padrão para o piloto ocasional
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

	@Override public final boolean mensalidade() { return pagames; }
	
	@Override public double getCusto(int voltas){
		return (double) voltas; // 1 euro por volta
	}

	@Override public final Volta getMelhorVolta() {
		return melhorVolta;
	}
	
	@Override public final void setMelhorVolta(Volta volta) { 
		if (melhorVolta.compareTo(volta) < 0){
			melhorVolta = volta;
		}
	}

	@Override public final int getAvVoltas(){
		return voltas;
	}

	@Override public void alugarVoltas(int voltas) {
		pagames = false;
		this.voltas = voltas;
	}

	@Override public void finalizaVolta(Volta v) throws PrecosException {
		if (voltas == 0) {
			throw new PrecosException("Limite de voltas atingido");
		}else {
			// setMelhorVolta(v);
			voltas--;
		}
	}
	
	@Override public void finalizaMes(){ 
		pagames = true;
	}
	
	/**
	 * Representação em forma de texto do objecto
	 * @return 
	 */
	public String toString(){
		String str = String.format("Melhor volta:  %3.1fs  --  Kart: %02d",
				this.getMelhorVolta().tempo, this.getMelhorVolta().kartID);
		return str;
	}

}
