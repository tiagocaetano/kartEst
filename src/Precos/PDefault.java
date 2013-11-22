package Precos;

/**
 * Assinatura padrão para o piloto ocasional
 * @author lca
 */
public abstract class PDefault implements Precos{
	
	private Volta melhorVolta;
	private int voltas;
	private int bonuslaps;
	private boolean pagames;
	private Precario tprecos;
	
	public PDefault(){
		this.melhorVolta = new Volta(0, 999.999);
		this.pagames = true;
		this.bonuslaps = 0;
		try{
			this.tprecos = MeusPrecos.getInstance().getPrecario(getNome());
		} catch (Exception e) {	
			this.tprecos = getDefaultPrecario();
		}
	}
	
	@Override public abstract String getNome();

	@Override public boolean mensalidade() { return pagames; }
	
	@Override public abstract Precario getDefaultPrecario();
	
	@Override public double getCusto(int voltas){		
		int bvoltas=0;
		double total;
		if(tprecos.getlfBonus() > 0 && tprecos.getBonus()>0){
			bvoltas = voltas / tprecos.getlfBonus() * tprecos.getBonus();
		} else if (tprecos.getlfBonus() == 0 && tprecos.getBonus()>0){
			if(mensalidade()){
				bvoltas = tprecos.getBonus();
			} else {
				bvoltas = getBonus();
			}
		}
		
		if (bvoltas >= voltas){
			total = tprecos.getPTaxa();
		} else{
			total = (voltas - bvoltas) * tprecos.getPVolta() + tprecos.getPTaxa();
		}
		
		if (mensalidade()){
			total += tprecos.getMensalidade();
		}
		return total;
	}
	
	@Override public int getBonus(){ return this.bonuslaps; }
	
	@Override public boolean setBonus(int bonus){ 		
		/* Não permite alterar as voltas grátis se existir 
		 * uma condição de voltas grátis por aluguer */
		if (tprecos.getlfBonus() > 0) {
			return false;
		} else {
			this.bonuslaps = bonus;
			return true;
		}
	}

	@Override public Volta getMelhorVolta() { return melhorVolta; }
	
	@Override public boolean setMelhorVolta(Volta volta) { 
		if (melhorVolta.compareTo(volta) < 0){
			melhorVolta = volta;
			return true;
		}
		return false;
	}

	@Override public int getAvVoltas(){	return voltas;	}

	@Override public void alugarVoltas(int voltas) {
		if (this.pagames){
			setBonus( tprecos.getBonus() <= voltas ? 0 : tprecos.getBonus()-voltas );
			this.pagames = false;
		} else {
			setBonus( getBonus() <= voltas ? 0 : getBonus()-voltas );
		}		
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
