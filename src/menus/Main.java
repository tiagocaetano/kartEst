package menus;

import aluguer.Kartodromo;

/**
 * Arranca com o sistema, criando as duas janelas de intera��o
 */
public class Main {

	public static void main(String[] args) {
		//cria��o do kartodromo e respectiva configura��o
		Kartodromo estKarts = new Kartodromo();
		setupKartodromo( estKarts );

		// cria��o das interfaces do sistema
		MenuAluguer aluguer = new MenuAluguer( estKarts, 20, 100, 550, 500 ); 
		MenuVoltas voltas = new MenuVoltas( estKarts, 600, 100, 300, 500 );
	}

	/**
	 * M�todo que inicializa o kart�dromo, criando os karts
	 * e o piloto n�o registado
	 */
	private static void setupKartodromo(Kartodromo estKarts) {
		// adicionar 15 karts com os n�meros do 1 ao 15
		
		// criar o piloto n�o registado com o n�mero 0		
	}

}
