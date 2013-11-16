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
	private static final int BONUS = 200;
	
	private int saldo=0;
	private boolean pagames = true;
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	
	@Override
	public String getNome(){
		return "Frequente";
	}
	
	@Override
	public double getCusto(int voltas) {
		double total;
		if (pagames) {
			total = MENSALIDADE + (BONUS < voltas ? 0 : voltas-BONUS);
		} else {
			total = (saldo < voltas ? 0 : voltas-saldo);
		}
		return total;
	}

	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		if(pagames){
			this.pagames = false;
			saldo = BONUS - voltas;
		} else {
			saldo = (saldo < voltas ? 0 : saldo-voltas);
		}
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
		saldo=0;
		this.pagames = true;
		this.asVoltas.clear();
	}
}
