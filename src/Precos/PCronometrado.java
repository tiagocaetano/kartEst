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
public class PCronometrado extends PDefault{
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	
	@Override
	public String getNome(){
		return "Cronometrado";
	}

	@Override
	public double getCusto(int voltas) {
		return super.getCusto(voltas) + 1;
	}

	@Override
	public void alugarVoltas(int voltas) throws PrecosException {
		super.alugarVoltas(voltas);
		this.asVoltas.clear();
	}

	@Override
	public String toString(){
		String str=super.toString();
		return str;
	}
}
