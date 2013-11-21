package kartodromo;

import Precos.*;
import consola.SConsola;
import static java.lang.Thread.sleep;
import java.util.*;
/**
 * esta classe representa o kartodromo com os seus karts, pilotos, etc
 */
public class Kartodromo {

	private SConsola oPainel;		// Painel de voltas
	private SConsola oMenu;			// Menu da Aplicação
	
	private int maxKart;
	private Map<Integer, Piloto> pilotos = new HashMap<>();		// Lista de Pilotos registados incluindo piloto 'zero'
	private Map<Integer, Kart> kPark = new HashMap<>();			// Karts disponíveis no parque
	private Queue<Kart> kRunn = new LinkedList<>();				// Karts em prova
	
	private GeradoraTempos gt = new GeradoraTempos();
	
	
	/**
	 * Inicializa o kartódromo, criando os karts e o piloto não registado
	 */
	public Kartodromo(){
		// Cria 15 karts com os números do 1 ao 15
		maxKart = 15;
		for (int i=1; i<=maxKart; i++) {
			kPark.put(i, new Kart(i));
		}
		
		/**
		 * Criar o piloto não registado, ao
		 * primeiro piloto é-lhe atribuido o número 0
		 */
		Piloto p = new Piloto("Default", new PDefault());
		pilotos.put(p.getId(), p);
		
		// Criação da interface do menu do sistema
		oMenu =  new SConsola("EST.Karts - Menu", 550, 500);
		oMenu.setPosition(20, 100);
	}
    
	/** 
	 * método que apresenta o menu principal da aplicação
	 */
	final public void iniciaMenu(){
		String menu = "Karts na EST - aluguer de karts\n\n" + 
		              "P - criar novo Piloto\n" +
		              "A - novo Aluguer\n" + 
		              "K - ver Karts alugados\n" + 
		              "V - Ver piloto\n" + 
		              "F - Fechar mês\n" +
		              "X - sair\n";
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
					gt.termina();
					oPainel.close();
					break;
				default:
					oMenu.print("    :>Opção Inválida");
					break;
			}
		} while( op != 'X');
		oMenu.close();
		
	}
	
	/**
	 * Inicia o painel onde serão colocados os tempos dos karts em prova
	 */
	final public void iniciaPainel(){
		oPainel = new SConsola("EST.Karts - Voltas", 300, 500);
		oPainel.setPosition(600, 100);
		
		// Inicia a thread que vai atribuir o tempo das voltas
        gt.start();
	}
	
	/**
	 * Cria um novo piloto
	 */
	private void criarPiloto() {
		Piloto piloto = null;
		char op;
		oMenu.clear();
		oMenu.println("Menu de criação de piloto\n"); 

		oMenu.print("Nome do Piloto? ");
		String nome = oMenu.readLine();
		while (piloto == null) {
			oMenu.clear();
			oMenu.println("Menu de criação de piloto\n");
			oMenu.print( "Escolha o tipo de piloto\n\n" +
							  "    C - Cronometrado\n" + 
							  "    R - Regular\n" +
							  "    F - Frequente\n\n:>" );

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
		pilotos.put(piloto.getId(), piloto);
		oMenu.println("Piloto criado com id: " + piloto.getId());
		oMenu.readLine();
	}
	
	/**
	 * Pede o número do piloto e devolve o piloto associado
	 * @return o piloto indicado pelo número do operador
	 */
	private Piloto pedirPiloto(){
		Piloto op;
		oMenu.println("      ====  PILOTOS DISPONÍVEIS  ====");
		for (Piloto p: pilotos.values()) {
			oMenu.println(String.format("        [ %02d ]  %s  %s",
					p.getId(), p.getNome(), 
					(p.estaEmProva() ? "(em prova)" : " ")));			
		}
		oMenu.print("\nIntroduza o número do piloto que pretende: ");
		op = pilotos.get(oMenu.readInt());
		
		return op;
	}

	/**
	 * Permite escolher um Kart a partir da lista apresentada
	 * @return Kart selecionado
	 */
	private Kart pedirKart(){
		Kart k;
		oMenu.println("    ====   PARQUE de KARTS   ====");
		for (int i=1; i<=maxKart; i++) {			
			oMenu.println(String.format("    > %02d  %s", i, 
					(kPark.get(i).temPiloto() ? "DISPONÍVEL" : "EM PROVA")));
		}
		
		do{
			oMenu.print("\nEscolha um dos karts disponíveis: ");
			k = kPark.get(oMenu.readInt());
			if (k == null)
				oMenu.print("OPÇÃO INVÁLIDA");
		} while (k == null);
		
		return k;
	}
	/**
	 * Cria um novo aluguer
	 */
	private void novoAluguer() {
		oMenu.clear();		
		oMenu.println( "Menu de criação de sessão\n\n");
		
		Piloto p = pedirPiloto();
		if (p == null) {
			// Cancela a operação
			oMenu.print("Operação cancelada... ");
			oMenu.readLine();
			return;
		}
		
		oMenu.print("Número de voltas? ");
		int nVoltas = oMenu.readInt();
		
		oMenu.println( "Vai custar : " + p.getCusto(nVoltas) );
		oMenu.print( "Prosseguir (s)? " );
		char op = Character.toUpperCase( oMenu.readChar() );
		if ( op == 'S') {
			oMenu.clear();
			Kart k = pedirKart();
			k.assignPiloto(p, nVoltas);
			kRunn.add(k);
		}
	}

	/**
	 * ver quais os karts que estão alugados
	 */
	private void verKartsAlugados() {
		oMenu.clear();
		
		synchronized(kRunn){
			oMenu.println("Karts alugados - " + kRunn.size() );
			Iterator<Kart> karts = kRunn.iterator();
			while (karts.hasNext()){
				karts.next().toString();
			}
		}		
		oMenu.readLine();
	}

	/**
	 *  ver as informações de um piloto
	 */
	private void verPiloto() {
		Piloto p;
		do {
			oMenu.clear();
			p = pedirPiloto();
		} while (p == null);
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
	
	private class GeradoraTempos extends Thread {
		Random gerador = new Random();
		boolean runable = true;

		@Override public void run() {
			Kart k;
			while (runable) {
				/**
				 * Gera um tempo com probabilidade normal com
				 * um mínimo 62 segundos e máximo de 70 segundos 
				 */
				Double tempo = gerador.nextDouble() * 8 + 62;
				synchronized(kRunn){
					if (!kRunn.isEmpty()) {
						k = kRunn.remove();
						k.terminaVolta(tempo);
						oPainel.println(String.format("    Kart [ %02d ] - %3.1f segundos",
								k.getId(), tempo));
						/**
						 * Se ainda há voltas por fazer alinha o
						 * kart para mais uma volta
						 */
						if (k.temPiloto()) {
							kRunn.add(k);
						}
					}
				}
				try {
					sleep(1000); // gera um tempo de volta por segundo
				} catch (InterruptedException e) {
				}
			}
		}
		
		public void termina(){ runable = false; }
    }

	public static void main(String[] args) {
		//criação do kartodromo e respectiva configuração
		Kartodromo bigK = new Kartodromo();
		bigK.iniciaPainel();
		bigK.iniciaMenu();	
	}
}
