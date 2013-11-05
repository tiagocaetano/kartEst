package menus;


import java.util.Random;

import aluguer.Kartodromo;

import consola.SConsola;

public class MenuVoltas {

	private SConsola aConsola;
	private Kartodromo kartodromo; 
	
	public MenuVoltas( Kartodromo k, int x, int y, int comp, int alt ){
		aConsola = new SConsola( "EST.Karts - voltas", comp, alt );
		aConsola.setPosition( x, y );		
		kartodromo = k;
		GeradoraTempos gt = new GeradoraTempos();
		gt.start();
	}

	/**
	 * Esta classe gera automaticamente os tempos por volta
	 */
	class GeradoraTempos extends Thread {
		Random gerador = new Random();

		public void run() {
			while (true) {
				/* para todos os karts alugados */ {
					double tempo = calculaTempo();
					
					// se o piloto for mesmo bom reduz o tempo aleatório em 2 segundos :-)
					String nomePiloto = "Sergio Barbosa";
					if( nomePiloto.equals("Sergio Barbosa") )
						tempo -= 2;
					aConsola.println("Kart <NÚMERO> - <TEMPO>" );					
				}
				aConsola.println("------------------------------");
				try {
					sleep(3000); // gera voltas a cada 3 segundos
				} catch (InterruptedException e) {
				}
			}
		}

		/**
		 * gera um tempo com probabilidade normal com média 62 segundos e desvio padrão
		 * de 2 segundos. Nunca gera valores abaixo dos 60 segundos...
		 * @return o tempo da volta
		 */
		private double calculaTempo() {
			// gerar tempos com probabilidade normal por volta dos 62 segundos
			// com desvio padrão de 2
			double tempo = gerador.nextGaussian() * 2 + 62;
			// se for menor que 60 segundos converter num número maior
			if (tempo < 60)
				tempo = 62 + (60 - tempo);
			return tempo;
		}
	}
}
