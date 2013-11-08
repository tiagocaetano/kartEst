/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguer;

import java.util.Vector;

/**
 *
 * @author lca
 */ 
public class Piloto {
    
        private int id;                               	// Número do piloto
	private Vector<Volta> asVoltas = new Vector<Volta>();   // Voltas efectudas
	private Precos tarif;                             	// Tarifário de piloto
        private Volta curVolta;
	private int saldo;                                  	// Voltas ainda permitidas ao Piloto

	private boolean aCorrer = false;                      	// indicação se o utilizador está a correr
	private Volta melhorVolta;                       	// Melhor volta efectuada, se houver


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
	 * Devolve as chamadas efectuadas pelo utilizador. A chamada activa não entra neste vector! 
	 * @return um vector com as chamadas efectuadas pelo utilizador
	 */
	public Vector<Volta> getVoltas() {
		return (Vector<Volta>) asVoltas.clone();
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
	 * @return o saldo (em milésimos de euro-cêntimos)
	 */
	public long getSaldo() {
		return saldo;
	}

	/**
	 * altera o saldo 
	 * @param saldo novo saldo (em milésimos de euro-cêntimos)
	 */
	public void setSaldo(long saldo) {
		if (saldo>0)
			this.saldo = saldo;
	}

	/**
	 * Método chamado para cobrar o custo (de um bloco) de uma chamada
	 * @param custoBloco custo de um bloco de tempo
	 */
	public void cobra(long custoBloco) {
		saldo -= custoBloco;
	}

	/**
	 * Inicia prova
	 * @return devolve a prova activa
	 */
	public Volta iniciaProva(){
		// cria uma nova chamada
		curVolta = new Volta( id );
		aCorrer = true;			

		// NÃO ALTERAR ESTE CÓDIGO, OU ALTERAR COM MUITO MUITO CUIDADO		
		Thread contador = new Thread(){
			public void run(){

				int bloco = 0; // iniciar o contador de blocos

				// enquanto o utilizador estiver a falar
				while( aCorrer ){

					// cobrar o preço correspondente ao bloco de tempo
					//tarif.cobrar( bloco, Piloto.this, curVolta );									

					// esperar para ver se no fim do bloco de tempo ainda está a falar
					// o tempo de espera depende do tempo do bloco
					try {
						// multiplicar o tempo do bloco por 1000 porque o sleep aceita milisegundos
						//sleep( tarif.getPeriodoTaxacao( bloco ) * 1000 );

					} catch (InterruptedException e) {
					}
					
					// passar para o bloco de código seguinte
					bloco++;
				}
			}
		};	
		contador.start();  // iniciar a contagem - NÃO RETIRAR ISTO DAQUI DE FORMA ALGUMA
		
		// retornar a chamada activa
		return curVolta;
	}


	/**
	 * Devolve a chamada activa
	 * @return a chamada activa
	 */
	public Object getChamadaActiva() {		
		return curVolta;
	}
	
	
	public String toString(){
		return "Utilizador: " + numero + "\n" +
				"Tarifario: " + tarif.getNome() + "\n" +
				"Saldo: " + saldo/100000.0 + " euros\n" +
				"Número de telefone: " + numero;		
	}
    
}
