package menus;

import aluguer.Kartodromo;
import consola.SConsola;

/**
 * Classe responsável pela apresentaçãoe
 * processamento do menu principal da aplicação
 * @author <por aqui nomes dos autores>
 */
public class MenuAluguer {

	// a consola responsável pela janela da aplicação
	private SConsola aConsola;
	
	// o kartrodromo sobre o qual se está a trabalhar
	private Kartodromo kartodromo;   
	
	public MenuAluguer( Kartodromo k, int x, int y, int comp, int alt ){
		aConsola = new SConsola( "EST.Karts", comp, alt );
		aConsola.setPosition( x, y );
		
		kartodromo = k;
		
		// criar uma nova thread para poder ter várias janelas ao mesmo tempo
		Thread t = new Thread(){			
			public void run() {
				menuPrincipal();
			}
		};
		t.start();
	}

	/** 
	 * método que apresenta o menu principal da aplicação
	 */
	public void menuPrincipal(){
		String menu = "Karts na EST - aluguer de karts\n\n" + 
		              "P - criar novo Piloto\n" +
		              "A - novo Aluguer\n" + 
		              "K - ver Karts alugados\n" + 
		              "V - Ver piloto\n" + 
		              "F - Fechar mês\n" +
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
					aConsola.println("Opção Inválida\n\n");
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
		aConsola.println("Menu de criação de piloto\n\n"); 

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
		default: aConsola.println("escolha inválida");
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
		aConsola.println( "Menu de criação de sessão\n\n");
		
		// pedir o piloto
		// pedir o piloto
		// pedir o piloto
		
		aConsola.println("Número de voltas? ");
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

			aConsola.println("Número do kart? ");
			int kart = aConsola.readInt();
			
			if( false /*kart não existe ou está indisponível */ )
				aConsola.println("Kart não disponível, escolha um disponível");
		} while( false /*kart não existe ou está indisponível */ );
		
		// começar o aluguer do kart pelo piloto
		// começar o aluguer do kart pelo piloto
		// começar o aluguer do kart pelo piloto		
	}

	/**
	 * Pede o número do piloto e devolve o piloto associado
	 * @return o piloto indicado pelo número do operador
	 */
	private Object pedirPiloto() {
		Object p = null;
		do {
			aConsola.println( "Número do piloto? (0 para único)? ");
			int idPiloto = aConsola.readInt();
			 
		} while( /* piloto não existe */ false );
		return p;
	}

	/**
	 * ver quais os karts que estão alugados
	 */
	private void verKartsAlugados() {
		aConsola.clear();
		aConsola.println("Karts alugados - <Número de karts alugados>" );
		
		/* para todos os karts alugados */ {
			aConsola.println( "Kart: <Número>" + " piloto: <Nome>" + 
					          "  voltas pedidas: <Número>" + "  dadas: <Número>" );			
		}
		aConsola.readLine();
	}

	/**
	 *  ver as informações de um piloto
	 */
	private void verPiloto() {
		aConsola.clear();		
		aConsola.println( "Informações sobre piloto");
		// pedir o piloto
		// pedir o piloto
		// pedir o piloto

		aConsola.println("Nome: <nome do piloto>" );
		aConsola.println("Melhor volta: <TEMPO>" +
				         " no kart <NÚMERO KART>"  );
		aConsola.println("Tempos ---------" );
		/** para todos os tempos */
			aConsola.println( "<NÚMERO KART> - <TEMPO>" );
		
		aConsola.readLine();
	}

	/**
	 * fecha o mês e arranca com o próximo
	 */
	private void fecharMes() {
		aConsola.clear();		
		aConsola.println( "Fechando o mês");
		
		/* fechar o mês para todos os pilotos */
		/* fechar o mês para todos os pilotos */
		/* fechar o mês para todos os pilotos */
		
		aConsola.readLine();
	}
}
