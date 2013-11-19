package kartodromo;

import Precos.*;
import consola.SConsola;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
 * esta classe representa o kartodromo com os seus karts, pilotos, etc
 */
public class Kartodromo {

	// indicação de qual o próximo número para o piloto
	private int proxIdPiloto = 1;
	private SConsola oPainel;		// Painel de voltas
	private SConsola oMenu;			// Menu da Aplicação
	
	private ArrayList<Precos> precos = new ArrayList<>();	// Lista de Preços disponíveis
	private ArrayList<Piloto> pilotos = new ArrayList<>();	// Lista de Pilotos registados incluindo piloto 'zero'
	private Queue<Kart> kPark = new LinkedList<>();			// Karts disponíveis no parque
	private Queue<Kart> kRunn = new LinkedList<>();			// Karts em prova
	
	
	/**
	 * Inicializa o kartódromo, criando os karts e o piloto não registado
	 */
	public Kartodromo(){
		// adicionar 15 karts com os números do 1 ao 15
		for (int i=0; i<15; i++) {
			kPark.add(new Kart());
		}
		// criar o piloto não registado com o número 0
		
		// criação das interfaces do sistema
		oMenu =  new SConsola("EST.Karts - Menu", 550, 500); 
		oMenu.setPosition(20, 100);
		menuPrincipal();
		oPainel = new SConsola("EST.Karts - Voltas", 300, 500);
		oPainel.setPosition(600, 100);		
	}
	
	/**
	 * Devolve o identificador a usar para um novo piloto
	 * @return o identificador a usar para um novo piloto
	 */
	public int getProxPilotoId() {
		proxIdPiloto++;
		return proxIdPiloto;
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
			oMenu.clear();
			oMenu.println( menu );
			op = Character.toUpperCase( oMenu.readChar() );
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
					oMenu.println("Opção Inválida\n\n");
					break;
			}
		} while( op != 'X');
		oMenu.close();
		System.exit( 0 );	             
	}
	
	/**
	 * cria um novo piloto
	 */
	private void criarPiloto() {
		oMenu.clear();
		oMenu.println("Menu de Criacção Piloto\n\n"); 
	
		oMenu.print("Nome do Piloto? ");
		String nome = oMenu.readLine();// armazena nome do piloto

		oMenu.println( "Escolha o tipo de piloto\n\n" +
					      "C - Cronometrado\n" + 
					      "R - Regular\n" +
					      "F - Frequente\n\n\n" );
		int id = getProxPilotoId();
		char op = Character.toUpperCase( oMenu.readChar() );
		switch( op ){
			case 'C':pilotos.add(id, new Piloto(nome, new PCronometrado()));	//cria piloto Cronometrado	
			break;
			
			case 'R':pilotos.add(id,new Piloto(nome, new PRegular()));//cria piloto Regular
			break;
			
			case 'F':pilotos.add(id,new Piloto(nome, new PFrequente()));//cria piloto Frequente
			break;
			
			default: oMenu.println("escolha invalida");
					 oMenu.readLine();
					 return;
					 
		}	
	
		oMenu.println("Piloto criado com id: " + id);
		oMenu.readLine();
	}

	/**
	 * cria um novo aluguer
	 */
	private void novoAluguer() {
		oMenu.clear();		
		oMenu.println( "Menu de criação de sessão\n\n");
		
		// pedir o piloto
		// pedir o piloto
		// pedir o piloto
		
		oMenu.println("Número de voltas? ");
		int nVoltas = oMenu.readInt();
		
		oMenu.println( "Vai custar : <CUSTO>" );
		oMenu.println( "Prosseguir (s)? " );
		char sim = Character.toUpperCase( oMenu.readChar() );
		if( sim != 'S' )
			return;

		
		do {
			oMenu.println("Karts Livres: ");
			// apresentar karts livres
			// apresentar karts livres

			oMenu.println("Número do kart? ");
			int kart = oMenu.readInt();
			
			if( false /*kart não existe ou está indisponível */ )
				oMenu.println("Kart não disponível, escolha um disponível");
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
			oMenu.println( "Número do piloto? (0 para único)? ");
			int idPiloto = oMenu.readInt();
			 
		} while( /* piloto não existe */ false );
		return p;
	}

	/**
	 * ver quais os karts que estão alugados
	 */
	private void verKartsAlugados() {
		oMenu.clear();
		oMenu.println("Karts alugados - <Número de karts alugados>" );
		
		/* para todos os karts alugados */ {
			oMenu.println( "Kart: <Número>" + " piloto: <Nome>" + 
					          "  voltas pedidas: <Número>" + "  dadas: <Número>" );			
		}
		oMenu.readLine();
	}

	/**
	 *  ver as informações de um piloto
	 */
	private void verPiloto() {
		oMenu.clear();		
		oMenu.println( "Informações sobre piloto");
		// pedir o piloto
		// pedir o piloto
		// pedir o piloto

		oMenu.println("Nome: <nome do piloto>" );
		oMenu.println("Melhor volta: <TEMPO>" +
				         " no kart <NÚMERO KART>"  );
		oMenu.println("Tempos ---------" );
		/** para todos os tempos */
			oMenu.println( "<NÚMERO KART> - <TEMPO>" );
		
		oMenu.readLine();
	}

	/**
	 * fecha o mês e arranca com o próximo
	 */
	private void fecharMes() {
		oMenu.clear();		
		oMenu.println( "Fechando o mês");
		
		/* fechar o mês para todos os pilotos */
		/* fechar o mês para todos os pilotos */
		/* fechar o mês para todos os pilotos */
		
		oMenu.readLine();
	}
	
    public static void main(String[] args) {
		//criação do kartodromo e respectiva configuração
		Kartodromo estKarts = new Kartodromo();
		
	}
}
