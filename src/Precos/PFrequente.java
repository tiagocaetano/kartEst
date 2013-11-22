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
	
	@Override public Precario getDefaultPrecario(){
		Precario tprecos = new Precario(this.getNome());		// Tabela de Preços
		tprecos.setPVolta(1.0);
		tprecos.setMensalidade(130.0);
		tprecos.setBonus(200);
		return tprecos;
	}

	@Override public void finalizaVolta(Volta volta) throws PrecosException {
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
		boolean odd=true;
		str += "\nOutras voltas efectuadas:\n     KART  ||   Tempo      KART  ||   Tempo\n";
		for(Volta v : asVoltas){
			str += String.format("     [%02d]  ||  %5.3fs", v.kartID, v.tempo);
			str += ( odd ? "\n" : " ");
			odd = !odd;
		}
		
		return str;
	}
}
