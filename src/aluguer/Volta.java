/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguer;

/**
 *
 * @author lca
 */
public class Volta {
    
    private int piloto;         // Identificação do Piloto
    private int voltas;         // Número de voltas efectuadas

    /**
     * Inicia uma volta
     * @param piloto
     * @param destino 
     */
    public Volta( int piloto ){
            this.piloto = piloto;
            voltas = 0;
    }

    /**
     * devolve o número de voltas efectuadas
     * @return total de voltas
     */
    public long getVoltas() {
            return voltas;
    }

    /**
     * devolve o ID do Piloto 
     * @return o piloto
     */	
    public int getPiloto() {
            return piloto;
    }

    /**
     * Adiciona uma nova volta
     * 
     */
    public void addvolta(){
            this.voltas += 1;
    }

    @Override
    public String toString(){
        return "  ";
    }
    
}
