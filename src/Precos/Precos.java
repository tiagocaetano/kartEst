/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Precos;

/**
 *
 * @author lca
 */
public interface Precos {
	public static double ALUGUER_VOLTA = 1;
	public static double CRONOMETRAR = 1;
	public static double CUSTO_REGULAR = 10;
	public static double CUSTO_FREQUENTE = 130;
	
	/**
	 * Devolve o nome do tipo de Assinatura
	 * @return 
	 */
	public String getNome();
	
	/**
	 * Custo das voltas requeridas se há lugar a pagamento da
	 * mensalidade esse valor é adicionado ao custo total
	 * @return 
	 */
	public short getCusto(short voltas);
	
	/**
	 * Devolve a melhor volta
	 * @return 
	 */
	public short getMelhorVolta();
	
	/**
	 * Voltas disponíveis no plafond
	 * @return 
	 */
	public short getAvVoltas();
	
	/**
	 * Aluga voltas 
	 * @param voltas número de voltas a alugar
	 * @return
	 * @throws PrecoException 
	 */
	public short alugarVoltas(short voltas) throws PrecosException;
	
	/**
	 * Termina uma volta
	 * @param tempo
	 * @throws PrecosException 
	 */
	public void finalizaVolta(short tempo) throws PrecosException;
	
}
