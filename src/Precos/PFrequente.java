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
	private ArrayList<Volta> asVoltas = new ArrayList<>();
	
	@Override
	public String getNome(){
		return "Frequente";
	}

	@Override
	public void finalizaVolta(Volta volta) throws PrecosException {
		super.finalizaVolta(volta);
		setMelhorVolta(volta);
		asVoltas.add(volta);
	}

	/**
	 * Limpa os tempos armazenados
	 */
	public final void clearTempos(){
		this.asVoltas.clear();
	}
	
	@Override
	public String toString(){
		String str=super.toString();
		
		str += "\nOutras voltas efectuadas:\n     KART  || Tempo\n";
		for(Volta v : asVoltas){
			str += String.format("     [%02d]  ||  %5.3fs\n", v.kartID, v.tempo);
		}
		
		return str;
	}
}
