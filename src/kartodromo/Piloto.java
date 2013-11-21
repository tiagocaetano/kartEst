/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kartodromo;

import Precos.*;

/**
 *
 * @author lca
 */ 
public class Piloto {
    private static short pilotcount=0;				// Contagem de pilotos
	private short id;								// Número do piloto
	private String nome;							// Nome do piloto
	private Precos tarif;
	private boolean emProva = false;				// Indicação se o utilizador está prova

	/**
	 * Cria um Piloto
	 * @param nome nome associado ao utilizador
	 * @param tarif tarifário associado ao utilizador
	 */
	public Piloto(String nome, Precos tarif){
		this.nome = nome;
		this.tarif = tarif;
		this.id = Piloto.pilotcount++;
	}
	
	/**
	 * Devolve o nome do piloto
	 * @return 
	 */
	public String getNome(){ return this.nome; }

	/**
	 * Devolve o número do piloto
	 * @return o número do piloto
	 */
	public int getId() { return this.id;	}

	/**
	 * Aplica um novo tipo de assinatura ao piloto
	 * @param tarif novo tarifário a aplicar
	 */
	public void setAssinatura(Precos tarif) {	this.tarif = tarif;	}

	/**
	 * Número de voltas ainda permitidas ao piloto
	 * @return o número de voltas
	 */
	public int getAvVoltas() { return this.tarif.getAvVoltas(); }
	
	public double getCusto(int nVoltas){
		return this.tarif.getCusto(nVoltas);
	}
	
	/**
	 * Transmite ao tarifário os dados 
	 * @param v 
	 */
	public void terminaVolta(Volta v){ 
		this.tarif.finalizaVolta(v);
		this.emProva = (this.tarif.getAvVoltas() > 0);
	}
	
	/**
	 * Permite saber se o piloto está em prova
	 * Nota: como este valor é passível de ser alterado durante
	 * execução da thread um resultado 'TRUE' poderá ser incorrecto
	 * @return Estado do piloto
	 */
	public boolean estaEmProva(){ return emProva; } 
	
	/**
	 * Inicia a prova do piloto
	 * @param voltas voltas a efectuar
	 * @return 
	 */
	public boolean iniciaProva(int voltas){ 
		if (emProva) {
			return false;
		} else {
			tarif.alugarVoltas(voltas);
			return (emProva = true);
		}
	}
	
	/**
	 * Inicia o processo de finalização do mês da assinatura
	 * adquirida pelo piloto
	 */
	public void finalizaMes(){	tarif.finalizaMes(); }
	
	/**
	 * Representação em forma de texto do objecto
	 * @return 
	 */
	@Override public String toString(){
		String str = String.format("Piloto: [ %02d ] -- %s\n" +
				"Tipo de Assinatura: %s\n", 
				id, nome, tarif.getNome());
		return str + tarif.toString();
	}
    
}
