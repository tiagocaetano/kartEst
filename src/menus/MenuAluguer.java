package menus;

import aluguer.Kartodromo;
import consola.SConsola;

/**
 * Classe respons�vel pela apresenta��oe
 * processamento do menu principal da aplica��o
 * @author <por aqui nomes dos autores>
 */
public class MenuAluguer {

	// a consola respons�vel pela janela da aplica��o
	private SConsola aConsola;
	
	// o kartrodromo sobre o qual se est� a trabalhar
	private Kartodromo kartodromo;   
	
	public MenuAluguer( Kartodromo k, int x, int y, int comp, int alt ){
		aConsola = new SConsola( "EST.Karts", comp, alt );
		aConsola.setPosition( x, y );
		
		kartodromo = k;
		
		// criar uma nova thread para poder ter v�rias janelas ao mesmo tempo
		Thread t = new Thread(){			
			public void run() {
				menuPrincipal();
			}
		};
		t.start();
	}

	/** 
	 * m�todo que apresenta o menu principal da aplica��o
	 */
	public void menuPrincipal(){
		String menu = "Karts na EST - aluguer de karts\n\n" + 
		              "P - criar novo Piloto\n" +
		              "A - novo Aluguer\n" + 
		              "K - ver Karts alugados\n" + 
		              "V - Ver piloto\n" + 
		              "F - Fechar m�s\n" +
		              "X - sair\n\n";
		char op;
		do {
			aConsola.clear();
			aConsola.println( menu );
			op = Character.toUpperCase( aConsola.readChar() );
			switch( op ){
				case 'P':
					criarPiloto();
					break;
				case 'A':
					novoAluguer();
					break;
				case 'K':
					verKartsAlugados();
					break;
				case 'V':
					verPiloto();
					break;
				case 'F':
					fecharMes();
					break;
				case 'X':
					break;
				default:
					aConsola.println("Op��o Inv�lida\n\n");
					break;
			}
		} while( op != 'X');
		aConsola.close();
		System.exit( 0 );	             
	}
	
	/**
	 * cria um novo piloto
	 */
	private void criarPiloto() {
		aConsola.clear();
		aConsola.println("Menu de cria��o de piloto\n\n"); 

		aConsola.print("Nome do Piloto? ");
		String nome = aConsola.readLine();

		aConsola.println( "Escolha o tipo de piloto\n\n" +
					      "C - Cronometrado\n" + 
					      "R - Regular\n" +
					      "F - Frequente\n\n\n" );
		int id = kartodromo.getProxPilotoId();
		char op = Character.toUpperCase( aConsola.readChar() );
		switch( op ){
		case 'C': break;		
		case 'R': break;
		case 'F': break;
		default: aConsola.println("escolha inv�lida");
				 aConsola.readLine();
				 return;
		}		
		aConsola.println("Piloto criado com id: " + id);
		aConsola.readLine();
	}

	/**
	 * cria um novo aluguer
	 */
	private void novoAluguer() {
		aConsola.clear();		
		aConsola.println( "Menu de cria��o de sess�o\n\n");
		
		// pedir o piloto
		// pedir o piloto
		// pedir o piloto
		
		aConsola.println("N�mero de voltas? ");
		int nVoltas = aConsola.readInt();
		
		aConsola.println( "Vai custar : <CUSTO>" );
		aConsola.println( "Prosseguir (s)? " );
		char sim = Character.toUpperCase( aConsola.readChar() );
		if( sim != 'S' )
			return;

		
		do {
			aConsola.println("Karts Livres: ");
			// apresentar karts livres
			// apresentar karts livres

			aConsola.println("N�mero do kart? ");
			int kart = aConsola.readInt();
			
			if( false /*kart n�o existe ou est� indispon�vel */ )
				aConsola.println("Kart n�o dispon�vel, escolha um dispon�vel");
		} while( false /*kart n�o existe ou est� indispon�vel */ );
		
		// come�ar o aluguer do kart pelo piloto
		// come�ar o aluguer do kart pelo piloto
		// come�ar o aluguer do kart pelo piloto		
	}

	/**
	 * Pede o n�mero do piloto e devolve o piloto associado
	 * @return o piloto indicado pelo n�mero do operador
	 */
	private Object pedirPiloto() {
		Object p = null;
		do {
			aConsola.println( "N�mero do piloto? (0 para �nico)? ");
			int idPiloto = aConsola.readInt();
			 
		} while( /* piloto n�o existe */ false );
		return p;
	}

	/**
	 * ver quais os karts que est�o alugados
	 */
	private void verKartsAlugados() {
		aConsola.clear();
		aConsola.println("Karts alugados - <N�mero de karts alugados>" );
		
		/* para todos os karts alugados */ {
			aConsola.println( "Kart: <N�mero>" + " piloto: <Nome>" + 
					          "  voltas pedidas: <N�mero>" + "  dadas: <N�mero>" );			
		}
		aConsola.readLine();
	}

	/**
	 *  ver as informa��es de um piloto
	 */
	private void verPiloto() {
		aConsola.clear();		
		aConsola.println( "Informa��es sobre piloto");
		// pedir o piloto
		// pedir o piloto
		// pedir o piloto

		aConsola.println("Nome: <nome do piloto>" );
		aConsola.println("Melhor volta: <TEMPO>" +
				         " no kart <N�MERO KART>"  );
		aConsola.println("Tempos ---------" );
		/** para todos os tempos */
			aConsola.println( "<N�MERO KART> - <TEMPO>" );
		
		aConsola.readLine();
	}

	/**
	 * fecha o m�s e arranca com o pr�ximo
	 */
	private void fecharMes() {
		aConsola.clear();		
		aConsola.println( "Fechando o m�s");
		
		/* fechar o m�s para todos os pilotos */
		/* fechar o m�s para todos os pilotos */
		/* fechar o m�s para todos os pilotos */
		
		aConsola.readLine();
	}
}
