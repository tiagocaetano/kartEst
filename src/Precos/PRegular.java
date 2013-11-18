/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Precos;

/**
 *
 * @author lca
 */
public class PRegular extends PFrequente {
	private static final double MENSALIDADE = 10;
	
	@Override
	public String getNome(){
		return "Regular";
	}

	@Override
	public double getCusto(int voltas) {
		// duas voltas grátis por cada 10 no aluguer
		// mensalidade de 10 euros
		return (mensalidade() ? MENSALIDADE : 0 ) + voltas - voltas/10 * 2;
	}
	
	@Override
	public void finalizaMes(){
		super.finalizaMes();
		clearTempos();
	}
}
