package Precos;

/**
 * Define os métodos a serem implementados para gerir uma assinatura conforme
 * definido pelo enunciado
 * @author lca
 */
public interface Precos {
	
	/**
	 * Devolve o nome do tipo de Assinatura
	 * @return 
	 */
	public String getNome();
	
	/**
	 * Verifica se a mensalidade da Assinatura (se existir) está paga
	 * @return 
	 */
	public boolean mensalidade();
	
	/**
	 * Custo das voltas requeridas se há lugar a pagamento da mensalidade esse
	 * valor é adicionado ao custo total
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
	 * Define a melhor volta
	 * @param volta 
	 */
	public void setMelhorVolta(Volta volta);
	
	/**
	 * Voltas por efectuar
	 * Nota: Apenas se refere às voltas durante prova
	 * @return 
	 */
	public int getAvVoltas();
	
	/**
	 * Aluga voltas e dá como iniciada a prova do piloto
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
