package aluguer;

/**
 * esta classe representa o kartodromo com os seus karts, pilotos, etc
 */
public class Kartodromo {

	// indica��o de qual o pr�ximo n�mero para o piloto
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
