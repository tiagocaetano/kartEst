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
	private boolean pagames = true;
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	
	@Override
	public String getNome(){
		return "Frequente";
	}
	
	@Override
	public double getCusto(int voltas) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		this.pagames = false;
	}
	
	@Override
	public void finalizaMes(){
		this.pagames = true;
		this.asVoltas.clear();
	}
}
