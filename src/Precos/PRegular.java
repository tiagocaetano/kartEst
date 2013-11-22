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
	
	@Override
	public String getNome(){
		return "Regular";
	}
	
	@Override public Precario getDefaultPrecario(){
		Precario tprecos = new Precario(this.getNome());		// Tabela de Preços
		tprecos.setPVolta(1.0);
		tprecos.setMensalidade(10.0);
		tprecos.setlfBonus(10);			// Condição de voltas por aluguer
		tprecos.setBonus(2);			// voltas grátis
		return tprecos;
	}
	
	@Override
	public void finalizaMes(){
		super.finalizaMes();
		clearTempos();
	}
}
