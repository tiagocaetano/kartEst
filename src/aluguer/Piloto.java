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
    
    private String numero;                               	// Número do piloto
	private Vector<Volta> asVoltas = new Vector<Volta>();   // Voltas efectudas
	private Precos preco;                             	// Tarifário de piloto

	private int saldo;                                  	// Voltas ainda permitidas ao Piloto

	private boolean aCorrer = false;                      	// indicação se o utilizador está a correr
	private Volta melhorVolta;                       	// Melhor volta efectuada, se houver


	/**
	 * Cria um utilizador com um determinado número, tarifário e saldo 
	 * @param num número associado ao utilizador
	 * @param tarif tarifário associado ao utilizador
	 * @param saldo saldo inicial do utilizador
	 */
	public Piloto( String num, Precos preco, int saldo ){
		numero = num;
		this.preco = preco;
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
	public String getNumero() {
		return numero;
	}

	/**
	 * Altera o número associado ao piloto
	 * @param numero novo número
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Devolve o tarifário aplicada ao piloto
	 * @return o tarifário aplicado ao piloto
	 */
	public Preco getTarifario() {
		return Preco;
	}

	/**
	 * Aplica um novo tarifário ao utilizador
	 * @param tarif novo tarifário a aplicar
	 */
	public void setTarifario(Tarifario tarif) {
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
	 * Realiza uma chamada para o número de destino
	 * @param destino número para quem ligar
	 * @return a chamada que fica activa 
	 */
	public Chamada fazChamada( String destino ){
		// cria uma nova chamada
		chamadaActiva = new Chamada( numero, destino );
		aFalar = true;			

		// NÃO ALTERAR ESTE CÓDIGO, OU ALTERAR COM MUITO MUITO CUIDADO		
		Thread contador = new Thread(){
			public void run(){

				int bloco = 0; // iniciar o contador de blocos

				// enquanto o utilizador estiver a falar
				while( aFalar ){

					// cobrar o preço correspondente ao bloco de tempo
					tarif.cobrar( bloco, Utilizador.this, chamadaActiva );									

					// esperar para ver se no fim do bloco de tempo ainda está a falar
					// o tempo de espera depende do tempo do bloco
					try {
						// multiplicar o tempo do bloco por 1000 porque o sleep aceita milisegundos
						sleep( tarif.getPeriodoTaxacao( bloco ) * 1000 );

					} catch (InterruptedException e) {
					}
					
					// passar para o bloco de código seguinte
					bloco++;
				}
			}
		};	
		contador.start();  // iniciar a contagem - NÃO RETIRAR ISTO DAQUI DE FORMA ALGUMA
		
		// retornar a chamada activa
		return chamadaActiva;
	}

	/**
	 * Para a chamada que o utilzidor está a realizar
	 */
	public void paraChamada(){
		if( !aFalar )                     // se não estiver a falar não faz nada
			return;

		aFalar = false;                   // deixa de falar		
		asChamadas.add( chamadaActiva );  // adiciona a chamada activa à lista de chamads realizadas
		chamadaActiva = null;             // fica sem chamada activa
	}

	/**
	 * Devolve a chamada activa
	 * @return a chamada activa
	 */
	public Object getChamadaActiva() {		
		return chamadaActiva;
	}
	
	
	public String toString(){
		return "Utilizador: " + numero + "\n" +
				"Tarifario: " + tarif.getNome() + "\n" +
				"Saldo: " + saldo/100000.0 + " euros\n" +
				"Número de telefone: " + numero;		
	}
    
}
