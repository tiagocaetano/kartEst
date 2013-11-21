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
	 * Devolve a assinatura aplicada ao piloto
	 * @return assinatura
	 */
	public Precos getAssinatura() {
		return tarif;
	}

	/**
	 * Aplica um novo tipo de assinatura ao piloto
	 * @param tarif novo tarifário a aplicar
	 */
	public void setAssinatura(Precos tarif) {
		this.tarif = tarif;
	}

	/**
	 * Número de voltas ainda permitidas ao piloto
	 * @return o número de voltas
	 */
	public long getAvVoltas() { return tarif.getAvVoltas(); }
	
	public double getCusto(int nVoltas){
		return tarif.getCusto(nVoltas);
	}
	
	public void terminaVolta(Volta volta){ 
		tarif.finalizaVolta(volta);
		emProva = (tarif.getAvVoltas() == 0);
	}
	
	public boolean estaEmProva(){ return emProva; } 
	
	public boolean iniciaProva(int voltas){ 
		if (emProva) {
			return false;
		} else {
			tarif.alugarVoltas(voltas);
			return (emProva = true);
		}
	}
	
	public void finalizaMes(){	tarif.finalizaMes(); }
	
	@Override
	public String toString(){
		Volta v = tarif.getMelhorVolta();
		return "Piloto: [" + id + "] " + nome + "\n" +
				"Melhor Tempo: " + v.getTempo() + " no kart [" +v.getKartID()+ "]\n" +
				"Tipo de Assinatura: " + tarif.getNome() + "\n" +
				"Voltas disponíveis: " + tarif.getAvVoltas() + " voltas.\n" +
				tarif.toString();
	}
    
}
