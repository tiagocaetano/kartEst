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
	private int id;									// Número do piloto
	private String nome;							// Nome do piloto
	private Precos tarif;
	private boolean aCorrer = false;				// Indicação se o utilizador está prova

	/**
	 * Cria um Piloto
	 * @param nome nome associado ao utilizador
	 * @param tarif tarifário associado ao utilizador
	 */
	public Piloto(String nome, Precos tarif){
		this.nome= nome;
		this.tarif = tarif;
	}
	
	/**
	 * Devolve o nome do piloto
	 * @return 
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Devolve o número do piloto
	 * @return o número do piloto
	 */
	public int getId() {
		return id;
	}

	/**
	 * Devolve o tarifário aplicada ao piloto
	 * @return o tarifário aplicado ao piloto
	 */
	public Precos getAssinatura() {
		return tarif;
	}

	/**
	 * Aplica um novo tarifário ao utilizador
	 * @param tarif novo tarifário a aplicar
	 */
	public void setAssinatura(Precos tarif) {
		this.tarif = tarif;
	}

	/**
	 * devolve o saldo do utilizador
	 * @return o número de voltas ainda permitidas ao utilizador
	 */
	public long getAvVoltas() {
		return tarif.getAvVoltas();
	}

	/**
	 * altera o saldo 
	 * @param saldo
	 */
	public void setSaldo(int saldo) {
            if (saldo>0) {
                this.saldo = saldo;
            }
	}
	
	
	public String toString(){
		return "Piloto: " + id + "\n" +
				"Tarifario: " + tarif.getNome() + "\n" +
				"Saldo: " + saldo + " voltas\n";
	}
    
}
