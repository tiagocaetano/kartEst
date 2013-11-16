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
	private static final double MENSALIDADE = 10;
	
	private boolean pagames = true;
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	
	@Override
	public String getNome(){
		return "Regular";
	}

	@Override
	public final double getCusto(int voltas) {
		// duas voltas grátis por cada 10 no aluguer
		return (pagames ? MENSALIDADE : 0 ) + voltas - voltas/10 * 2;
	}

	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		// considera a mensalidade paga
		pagames = false;
		super.alugarVoltas(voltas);
	}
	
	@Override
	public void finalizaVolta(Volta volta) throws PrecosException {
		super.finalizaVolta(volta);
		setMelhorVolta(volta);
		asVoltas.add(volta);
	}
	
	@Override
	public void finalizaMes(){
		this.pagames = true;
		this.asVoltas.clear();
	}
	
	@Override
	public String toString(){
		String str=super.toString();
		return str;
	}
}
