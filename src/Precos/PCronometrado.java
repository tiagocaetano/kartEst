package Precos;

/**
 *
 * @author lca
 */
public class PCronometrado extends PFrequente {
	
	@Override
	public String getNome(){
		return "Cronometrado";
	}

	@Override
	public double getCusto(int voltas) {
		return voltas + 1;
	}

	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		super.alugarVoltas(voltas);
		clearTempos();
	}
}
