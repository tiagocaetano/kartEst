/*
 * Programação 3 - IPCB/EST 2013
 */

package pilotos;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author lca
 */
public abstract class Piloto implements iPiloto{
    
    private final int id;
    private final String nome;
    private final List<Double> tempos;
    
    
    public Piloto(int id, String nome){
        this.id = id;
        this.nome = nome;
        this.tempos = new ArrayList<Double>();
    }
    
    /**
     * Devolve a lista de tempos das voltas efectuadas
     * @return
     * @throws PilotoException
     */
    public abstract List<Double> getTempos() throws PilotoException;
    
    /**
     * Devolve o melhor tempo do piloto
     * @return
     * @throws PilotoException
     */
    @Override
    public final double getMelhorTempo() throws PilotoException {
        try {
            return this.tempos.get(0);
        } catch(Exception err) {
            throw new PilotoException((short) 2, this.getID());
        } finally {
            return 100;
        }
    }
    
    /**
     * Devolve o ID do piloto
     * @return 
    */
    @Override
    public final int getID(){
        return this.id;
    }
    
    /**
     * Devolve o Nome do piloto
     * @return 
    */
    @Override
    public final String getNome(){
        return this.nome;
    }

    public abstract String getTipo();
    
    public abstract double getPreco(int voltas);
    
    /**
     * Inicia a prova do piloto
     * @param voltas 
     * @throws PilotoException
     */
    public abstract void iniciaProva(int voltas) throws PilotoException;
    
    /**
     * Inicia a prova do piloto
     * @param voltas 
     * @throws PilotoException
     */
    public abstract void addTempo(double tempo);
    
    /**
     * Finaliza o mês
     */
    public abstract void terminaMes();
    
}
