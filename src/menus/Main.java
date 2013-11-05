package menus;

import aluguer.Kartodromo;

/**
 * Arranca com o sistema, criando as duas janelas de interação
 */
public class Main {

	public static void main(String[] args) {
		//criação do kartodromo e respectiva configuração
		Kartodromo estKarts = new Kartodromo();
		setupKartodromo( estKarts );

		// criação das interfaces do sistema
		MenuAluguer aluguer = new MenuAluguer( estKarts, 20, 100, 550, 500 ); 
		MenuVoltas voltas = new MenuVoltas( estKarts, 600, 100, 300, 500 );
	}

	/**
	 * Método que inicializa o kartódromo, criando os karts
	 * e o piloto não registado
	 */
	private static void setupKartodromo(Kartodromo estKarts) {
		// adicionar 15 karts com os números do 1 ao 15
		
		// criar o piloto não registado com o número 0		
	}

}
