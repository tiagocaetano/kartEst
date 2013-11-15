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
    
	private int id;												// Número do piloto
	private String nome;										// Nome do piloto
	private Precos tarif;
	private int saldo;											// Voltas ainda permitidas ao Piloto
	private boolean aCorrer = false;							// indicação se o utilizador está prova
	private int melhorTempo;									// Melhor tempo efectuado, se houver

	/**
	 * Cria um utilizador com um determinado número, tarifário e saldo 
	 * @param num número associado ao utilizador
	 * @param tarif tarifário associado ao utilizador
	 * @param saldo saldo inicial do utilizador
	 */
	public Piloto( int id, Precos tarif, int saldo ){
		this.id= id;
		this.tarif = tarif;
		this.saldo = saldo;
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
	public Precos getTarifario() {
		return tarif;
	}

	/**
	 * Aplica um novo tarifário ao utilizador
	 * @param tarif novo tarifário a aplicar
	 */
	public void setTarifario(Precos tarif) {
		this.tarif = tarif;
	}

	/**
	 * devolve o saldo do utilizador
	 * @return o número de voltas ainda permitidas ao utilizador
	 */
	public long getSaldo() {
		return saldo;
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
