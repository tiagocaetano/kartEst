/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Precos;

/**
 *
 * @author lca
 */
public abstract class PrecosDefault implements Precos{
	
	private short voltas;
	private boolean pagames = true;
	private Volta melhorVolta;
			
	private class Volta {
		short kartID;
		short tempo;
		
		public Volta(short kart, short tempo){
			this.kartID=kart;
			this.tempo=tempo;
		}
		
		public short getTempo(){
			return tempo;
		}
		
		public short getKart(){
			return kartID;
		}
	}
	
	/**
	 * Nome da Assinatura
	 * @return 
	 */
	@Override
	public String getNome(){
		return this.getClass().getName();
	}
	
	/**
	 * Custo da aquisição de voltas
	 * @return 
	 */
	public abstract short getCusto(short voltas);
	
	/**
	 * Devolve a melhor volta
	 * @return 
	 */
	public Volta getMelhorVolta() {
		return melhorVolta;
	}
	
	/**
	 * Voltas disponíveis no plafond
	 * @return 
	 */
	public short getAvVoltas(){
		return voltas;
	}
	
	/**
	 * Aluga voltas 
	 * @param voltas número de voltas a alugar
	 * @return
	 * @throws PrecoException 
	 */
	public abstract short alugarVoltas(short voltas) throws PrecosException;
	
	/**
	 * Termina uma volta
	 * @param tempo
	 * @throws PrecosException 
	 */
	public abstract void finalizaVolta(short tempo) throws PrecosException;
	
}
