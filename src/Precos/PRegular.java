/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Precos;

/**
 *
 * @author lca
 */
import java.util.ArrayList;

public class PRegular extends PDefault{
	private boolean pagames = true;
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	
	@Override
	public String getNome(){
		return "Regular";
	}

	@Override
	public double getCusto(int voltas) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		throw new UnsupportedOperationException("Not supported yet."); 
	}
	
	@Override
	public void finalizaVolta(Volta volta) throws PrecosException {
		super.finalizaVolta(volta);
		asVoltas.add(volta);
	}
	
	@Override
	public void finalizaMes(){
		this.pagames = true;
		this.asVoltas.clear();
	}
}
