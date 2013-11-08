package aluguer;

/**
 * esta classe representa o kartodromo com os seus karts, pilotos, etc
 */
public class Kartodromo {

	// indicação de qual o próximo número para o piloto
	private int proxIdPiloto = 9;
	
	public Kartodromo(){		
	}
	
	/**
	 * Devolve o identificador a usar para um novo piloto
	 * @return o identificador a usar para um novo piloto
	 */
	public int getProxPilotoId() {
		proxIdPiloto++;
		return proxIdPiloto;
	}
}
