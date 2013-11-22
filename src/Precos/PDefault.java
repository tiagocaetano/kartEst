package Precos;

/**
 * Assinatura padrão para o piloto ocasional
 * @author lca
 */
public class PDefault implements Precos{
	
	private Volta melhorVolta;
	private int voltas;
	private int bonuslaps=0;
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
		Precario p;
		try{
			p = MeusPrecos.getInstance().getPrecario(this.getNome());
		} catch (Exception e) {
			return (double) voltas; // 1 euro por volta
		}
		int bvoltas=0;
		double total;
		if(p.getlfBonus() > 0 && p.getBonus()>0){
			bvoltas = voltas / p.getlfBonus() * p.getBonus();
		} else if (p.getlfBonus() == 0 && p.getBonus()>0){
			if(!mensalidade()){
				voltas = ( p.getBonus() >= voltas ? 0 : voltas-p.getBonus() );
			} else {
				voltas = ( bonuslaps >= voltas ? 0 : voltas-bonuslaps );
			}
		}
		
		total = (voltas - bvoltas) * p.getPVolta() + p.getPTaxa();
		if (mensalidade()){
			total += p.getMensalidade();
		}
		return total;
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
		if (mensalidade()){
			Precario p;
			try{
				p = MeusPrecos.getInstance().getPrecario(this.getNome());
				if (p.getlfBonus() == 0 && p.getBonus()>0){
					bonuslaps = ( p.getBonus() <= voltas ? 0 : p.getBonus()-voltas );
				}
			} catch (Exception e) {	}
		} else {
			bonuslaps = ( bonuslaps <= voltas ? 0 : bonuslaps - voltas );
		}
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
		bonuslaps = 0;
		pagames = true;
	}
	
	/**
	 * Representação em forma de texto do objecto
	 * @return 
	 */
	public String toString(){
		String str = String.format("Melhor volta:  %5.3fs  --  Kart: %02d",
				this.getMelhorVolta().tempo, this.getMelhorVolta().kartID);
		return str;
	}

}
