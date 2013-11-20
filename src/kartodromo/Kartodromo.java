package kartodromo;

import Precos.*;
import consola.SConsola;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
/**
 * esta classe representa o kartodromo com os seus karts, pilotos, etc
 */
public class Kartodromo {

	private SConsola oPainel;		// Painel de voltas
	private SConsola oMenu;			// Menu da Aplicação
	
	private int maxKart;
	private Map<Integer, Piloto> pilotos = new HashMap<>();	// Lista de Pilotos registados incluindo piloto 'zero'
	private Map<Integer, Kart> kPark = new HashMap<>();		// Karts disponíveis no parque
	private Queue<Kart> kRunn = new LinkedList<>();			// Karts em prova
	
	
	/**
	 * Inicializa o kartódromo, criando os karts e o piloto não registado
	 */
	public Kartodromo(){
		// adicionar 15 karts com os números do 1 ao 15
		maxKart = 15;
		for (int i=1; i<=maxKart; i++) {
			kPark.put(i, new Kart(i));
		}
		// criar o piloto não registado com o número 0
		Piloto p = new Piloto("Default", new PDefault());
		pilotos.put(p.getId(), p);
		
		// criação das interfaces do sistema
		oMenu =  new SConsola("EST.Karts - Menu", 550, 500);
		oMenu.setPosition(20, 100);
		menuPrincipal();
		oPainel = new SConsola("EST.Karts - Voltas", 300, 500);
		oPainel.setPosition(600, 100);	
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
		Piloto piloto=null;
		char op;
		oMenu.clear();
		oMenu.println("Menu de criação de piloto\n\n"); 

		oMenu.print("Nome do Piloto? ");
		String nome = oMenu.readLine();
		while (piloto == null) {
			oMenu.clear();
			oMenu.println("Menu de criação de piloto\n\n");
			oMenu.println( "Escolha o tipo de piloto\n\n" +
							  "    C - Cronometrado\n" + 
							  "\tR - Regular\n" +
							  "\tF - Frequente\n\n\n" );

			op = Character.toUpperCase( oMenu.readChar() );
			switch( op ){
				case 'C':
					piloto = new Piloto(nome, new PCronometrado());
					break;		
				case 'R':
					piloto = new Piloto(nome, new PRegular());
					break;
				case 'F':
					piloto = new Piloto(nome, new PFrequente());
					break;
				default:
					oMenu.println("escolha inválida");
					oMenu.readLine();
			}
		}
		oMenu.println("Piloto criado com id: " + piloto.getId());
		oMenu.readLine();
	}
	
	/**
	 * Pede o número do piloto e devolve o piloto associado
	 * @return o piloto indicado pelo número do operador
	 */
	private Piloto pedirPiloto(){
		Piloto op;
		oMenu.println("====  PILOTOS DISPONÍVEIS  ====");
		for (Piloto p: pilotos.values()) {
			if (!p.estaEmProva()) {
				oMenu.println(String.format("    %02d - %s", p.getId(), p.getNome()));
			}
		}
		
		do{
			oMenu.print("\nIntroduza o número do piloto que pretende: ");
			op = pilotos.get(oMenu.readInt());
			if (op == null)
				oMenu.print("OPÇÃO INVÁLIDA");
		} while (op == null);
		
		return op;
	}

	/**
	 * Permite escolher um Kart a partir da lista apresentada
	 * @return Kart selecionado
	 */
	private Kart pedirKart(){
		Piloto op;
		String str = "";
		oMenu.println("====   PARQUE de KARTS   ====");
		for (int i=0; i<maxKart; i++) {			
			str+= String.format("   > %02d  %12s", i, 
					(kPark.get(i).temPiloto() ? "EM PROVA" : "DISPONÍVEL"));
		}
		
		do{
			oMenu.print("\nIntroduza o número do kart que pretende: ");
			op = pilotos.get(oMenu.readInt());
			if (op == null)
				oMenu.print("OPÇÃO INVÁLIDA");
		} while (op == null);
		
		return op;
	}
	/**
	 * cria um novo aluguer
	 */
	private void novoAluguer() {
		oMenu.clear();		
		oMenu.println( "Menu de criação de sessão\n\n");
		
		Piloto p = pedirPiloto();
		
		oMenu.println("Número de voltas? ");
		int nVoltas = oMenu.readInt();
		
		oMenu.println( "Vai custar : " + p.getCusto(nVoltas) );
		oMenu.println( "Prosseguir (s)? " );
		char op = Character.toUpperCase( oMenu.readChar() );
		if( op != 'S' )
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
		Piloto p = pedirPiloto();
		oMenu.println(p.toString());
		oMenu.readLine();
	}

	/**
	 * fecha o mês e arranca com o próximo
	 */
	private void fecharMes() {
		oMenu.clear();		
		oMenu.println( "Fechando o mês...");
		
		for (Piloto p : pilotos.values()){
			oMenu.print("Piloto: [" + p.getId() + "] " + p.getNome());
			p.finalizaMes();
			oMenu.println("  MÊS ENCERRADO");
			oMenu.readLine();					
		}
		
		oMenu.readLine();
	}
	
    public static void main(String[] args) {
		//criação do kartodromo e respectiva configuração
		new Kartodromo();
		
	}
}
