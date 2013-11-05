/* 
 *  esta classe encapsula um piloto generico do Kartdromo
 * 
 *@author 	Tiago Caetano
 *@data 	    Outubro 2013
 *@version 	v.0.1
 */

package pilotos;



public abstract class PilotoDefault implements InterfacePiloto {

	
	// variaveis de instancia da classe
	private int id;// id piloto
	private String nome;// nome do piloto
	

	/* 
	 * constructor vazio
	 */
	 public PilotoDefault() {}
	
	/*
	 * construtor 
	 * Piloto por defeito que nao esta registado id=0;
	 */
	public PilotoDefault(int id, String nome) {
		this.id = id;
		this.nome = nome;
		
	}
	

	/*
	 * Metodo interrogador devolve id do piloto
	 * @return: id piloto
	 * 
	 */
	public int getId() {
		return id;
	}
	
	
	/*
	 * Metodo que altera id piloto
	 * @param: id 
	 * @return:void
	 * 
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	
	/*
	 * Metodo que devolve o nome do piloto
	 * @return: nome do piloto
	 * 
	 */

	public String getNome() {
		return nome;
	}

	
	/*
	 * Metodo que altera o nome do piloto
	 * @return: void
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	



	@Override
	public String toString() {
		return "PilotoDefault [id=" + id + ", nome=" + nome + "]";
	}
	

	

	

}
