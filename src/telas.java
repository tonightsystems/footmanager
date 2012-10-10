import java.util.Scanner;
public class telas {

	/**
	 * Versao do sistema
	 * 
	 * @type {String}
	 */
	public static String versao = "0.1 alpha";
	public static String titulo, teste;

	/**
	 * Guarda a tela acessada no momento
	 *
	 * 0 = Sair
	 * 1 = Menu inicial
	 * 2 = Campeonatos
	 * 3 = Jogadores
	 * (...)
	 * 
	 * @type {Number}
	 */
	public static int tela = 1;

	/**
	 * Recebe os dados informado pelo usuario
	 * @type {Scanner}
	 */
	public static Scanner dados = new Scanner(System.in);

	/**
	 * Main
	 */
	public static void main(String[] args) {
		cabecalho();
		menu(tela);
	}
	
	/**
	 * Imprime o menu no console
	 */
	public static void menu(int indice){
		p(t(50));
		switch (indice){
			case 1 :
				p("[2] Campeonatos");
				p("[3] Equipes");
				p("[4] Jogadores");
				p("[0] Sair");
			break;
			case 2 :
				cabeTab("2");
				p("[5] Adicionar novo campeonato");
				p("[6] Listar campeonatos");
				p("[0] Sair");
			break;
			case 3 :
				cabeTab("3");
				p("[7] Cadastrar nova equipe");
				p("[8] Visualizar equipes");
				p("[0] Sair");
			break;
			case 4 :
				cabeTab("4");
				p("[9] Cadastrar novo jogador");
				p("[10] Visualizar jogadores");
				p("[0] Sair");
			break;
			case 5 :
				cabeTab("5");
				p("Nome do Campeonato: "); teste = dados.nextLine();
				p("Data de início: ");     teste = dados.nextLine();
				p("Data de término: ");    teste = dados.nextLine();
			break;
			case 6 :
				cabeTab("6");
				p("Campeonato		Data de início		Data de término"); 
			break;	
			case 9 :
				cabeTab("9");
				p("Nome do Jogador: ");    teste = dados.nextLine();
				p("CPF: ");                teste = dados.nextLine();
				p("Telefone fixo: ");      teste = dados.nextLine();
				p("Celular: ");            teste = dados.nextLine();
			break;
			
			default :
				p("Saindo...");
			break;
		}
		p(t(50));
		l();
		if ( indice > 0 && indice < 4 ){
			p("Escolha: ");
			tela = dados.nextInt();
			//cls(); //limpar a tela
			menu(tela);
		}
		l();
	}
	
	/**
	 * Imprime cabecalho do programa no console
	 */
	public static void cabecalho(){
		p(t(150));
		p("FOOTMANAGER      v" + versao);
		p(t(150));
		l();
	}
	
	/**
	 * Imprime um traco no console
	 * @param vezes
	 * @return linha
	 */
	public static String t(int vezes){
		String linha = "";
		while( vezes > 0 ){
			linha += "=";
			vezes--;
		}
		return linha;
	}
	
	/**
	 * Imprime nova linha com texto no console
	 * 
	 * @param string texto Texto a ser impresso. Obrigatorio.
	 */
	public static void p(Object texto){
		System.out.println(texto);
	}
	
	/**
	 * Imprime uma linha vazia no console
	 */
	public static void l(){
		System.out.println();
	}
	
	/**
	 * Limpar a tela
	 */
	public static void cls(){
		for(int i = 0; i < 15; i++)
			System.out.println("");
	}
	
	/**
	 * Imprime cabecalho da tabela
	 */
	public static void cabeTab(Object titulo){
		
		if(titulo == "2"){titulo = "Campeonatos";}
		if(titulo == "3"){titulo = "Equipes";}
		if(titulo == "4"){titulo = "Jogadores";}
		if(titulo == "5"){titulo = "Cadastro de Campeonato";}
		if(titulo == "6"){titulo = "Listagem dos Campeonatos";}
		if(titulo == "9"){titulo = "Cadastro de Jogador";}
		
		l();
		p(t(50));
		p(titulo);
		p(t(50));
		l();
	}
}
