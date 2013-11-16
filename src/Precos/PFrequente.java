/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Precos;

import java.util.ArrayList;

/**
 *
 * @author lca
 */
public class PFrequente extends PDefault{
	private static final double MENSALIDADE = 130;
	private static final int BONUSLAP = 200;
	
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	private int saldo=0;	
	
	@Override
	public String getNome(){
		return "Frequente";
	}
	
	@Override
	public double getCusto(int voltas) {
		double total;
		if (mensalidade()) {
			total = MENSALIDADE + (BONUSLAP < voltas ? 0 : voltas-BONUSLAP);
		} else {
			total = (saldo < voltas ? 0 : voltas-saldo);
		}
		return total;
	}

	@Override
	public void finalizaVolta(Volta volta) throws PrecosException {
		super.finalizaVolta(volta);
		setMelhorVolta(volta);
		asVoltas.add(volta);
	}
	
	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		if(mensalidade()){
			saldo = BONUSLAP - voltas;
		} else {
			saldo = (saldo < voltas ? 0 : saldo-voltas);
		}
		super.alugarVoltas(voltas);
	}

	/**
	 * Limpa os tempos armazenados
	 */
	public final void clearTempos(){
		this.asVoltas.clear();
	}
	
	@Override
	public void finalizaMes(){
		saldo=0;
		super.finalizaMes();
	}
	
	@Override
	public String toString(){
		String str=super.toString();
		
		str += "     KART  || Tempo\n";
		for(Volta v : asVoltas){
			str += String.format("    [%02d] ||  %03ds\n", v.kartID, v.tempo);
		}
		
		return str;
	}
}
