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
	
	/**
	 * Devolve o nome do tipo de Assinatura
	 * @return 
	 */
	public String getNome();
	
	/**
	 * Custo das voltas requeridas se há lugar a pagamento da
	 * mensalidade esse valor é adicionado ao custo total
	 * @param voltas
	 * @return 
	 */
	public double getCusto(int voltas);
	
	/**
	 * Devolve a melhor volta
	 * @return 
	 */
	public Volta getMelhorVolta();
	
	/**
	 * Voltas disponíveis no plafond
	 * @return 
	 */
	public int getAvVoltas();
	
	/**
	 * Aluga voltas 
	 * @param voltas número de voltas a alugar
	 */
	public void alugarVoltas(int voltas);
	
	/**
	 * Termina uma volta
	 * @param volta
	 * @throws PrecosException 
	 */
	public void finalizaVolta(Volta volta) throws PrecosException;
	
	/**
	 * Executa as operações do final do mês
	 */
	public void finalizaMes();
	
}
