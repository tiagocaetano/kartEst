/*
 * Programação 3 - IPCB/EST 2013
 */

package pilotos;
import java.util.List;

/**
 * Interface de Pilotos
 * @author lca
 */
public interface iPiloto {
        
    /**
     * Devolve o ID do piloto
     * @return 
    */
    public int getID();
    
    /**
     * Devolve o Nome do piloto
     * @return 
    */
    public String getNome();

    /**
     * Devolve o Tipo de piloto
     * @return 
    */
    public String getTipo();
    
    /**
     * Devolve a lista de tempos das voltas efectuadas
     * @return
     * @throws PilotoException
     */
    public List<Double> getTempos() throws PilotoException;
    
    /**
     * Devolve o melhor tempo do piloto
     * @return
     * @throws PilotoException
     */
    public double getMelhorTempo() throws PilotoException;
    
    /**
     * Adiciona voltas ao crédito do piloto
     * @param voltas 
     * @return  valor do aluguer ou da mensalidade
     */
    public double getPreco(int voltas);
    
    /**
     * Inicia a prova do piloto
     * @param voltas 
     * @throws PilotoException
     */
    public void iniciaProva(int voltas) throws PilotoException;
    
    /**
     * Adiciona um novo tempo a lista de tempos
     * @param tempo 
     */
    public void addTempo(double tempo);
    
    /**
     * Finaliza o mês
     */
    public void terminaMes();
    
}