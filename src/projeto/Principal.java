package projeto;
import projeto.Conexao;
import projeto.Utilitarios;
import projeto.Equipe;
import java.util.Scanner;
public class Principal {

	/**
	 * Versao do sistema
	 * 
	 * @type {String}
	 */
	public static String versao = "0.1 alpha";
	
	/**
	 * Objeto Utilitarios
	 */
	public static Utilitarios util = new Utilitarios();
	
	/**
	 * Objeto Utilitarios
	 */
	public static Equipe equipe = new Equipe();
	
	/**
	 * Objeto Conexao
	 */
	public static Conexao bd = new Conexao();
	
	/**
	 * Declaracao Variaveis
	 */
	public static String teste;
	public static int anterior = 0;

	/**
	 * Guarda a tela acessada no momento:
	 *
	 * 0 = Sair
	 * 1 = Menu inicial
	 * 2 = Campeonatos
	 * 3 = Equipes
	 * 4 = Jogadores
	 * 5 = Adicionar novo campeonato
	 * 6 = Listar campeonatos
	 * 7 = Cadastrar nova equipe
	 * 8 = Visualizar equipes
	 * 9 = Cadastrar novo jogador
	 * 10 = Visualizar jogadores
	 * 15 = Voltar	 
	 * 
	 * @type {Number}
	 */
	public static int tela = 1;

	/**
	 * Recebe os dados informados pelo usuario
	 * @type {Scanner}
	 */
	public static Scanner dados = new Scanner(System.in);

	/**
	 * Main
	 */
	public static void main(String[] args) {
		try {
			cabecalho();
			menu(tela);
		} catch( Exception e  ){
			System.out.println("Erro: " + e.getMessage() );
		}
	}
	
	/**
	 * Imprime o menu e as telas no console
	 */
	public static void menu(int indice){
		util.p(util.t(50));
		switch(indice){
		
			case 1 :
				util.p("[2] Campeonatos");
				util.p("[3] Equipes");
				util.p("[4] Jogadores");
				util.l();
				util.p("[0] Sair");
			break;
			
			case 2 :
				pagina(indice);
				util.p("[5] Adicionar novo campeonato");
				util.p("[6] Listar campeonatos");
				voltarSair();
			break;
			
			case 3 :
				pagina(indice);
				util.p("[7] Cadastrar nova equipe");
				util.p("[8] Visualizar equipes");
				voltarSair();
			break;
			
			case 4 :
				pagina(indice);
				util.p("[9] Cadastrar novo jogador");
				util.p("[10] Visualizar jogadores");
				voltarSair();
			break;
			
			case 5 :
				pagina(indice);
				util.p("Nome do Campeonato: "); 
				teste = dados.nextLine(); 
				dados.nextLine();
				util.p("Data de inÌcio: ");     
				teste = dados.nextLine(); 
				util.p("Data de tÈrmino: ");    
				teste = dados.nextLine();
				dados.nextLine();
				voltarSair();
			break;
			
			case 6 :
				pagina(indice);
				util.p("Campeonato	Data de inÌcio	Data de tÈrmino"); 
				
				//teste impressao
				util.p("testeteste	testetesteteste	testetesteteste");
				util.p("testeteste	testetesteteste	testetesteteste");
				util.l();
				
				util.p(util.t(50));
				voltarSair();
			break;	
			
			case 7 :
				pagina(indice);
				util.p("Nome da Equipe: "); 
				teste = dados.nextLine();
				dados.nextLine();
				util.p("Apelido: ");        
				teste = dados.nextLine();
				util.p("Mascote: ");        
				teste = dados.nextLine();
				voltarSair();
			break;	
			
			case 8 :
				pagina(indice);
				util.p("Equipe		Data de inÌcio	  Data de tÈrmino"); 
				
				//teste impressao
				util.p("testeteste	testetesteteste	  testetesteteste");
				util.p("testeteste	testetesteteste	  testetesteteste");
				util.l();
				
				util.p(util.t(50));
				voltarSair();
			break;	
			
			case 9 :
				pagina(indice);
				util.p("Nome do Jogador: ");    
				teste = dados.nextLine();
				dados.nextLine();
				util.p("CPF: ");                
				teste = dados.nextLine();
				util.p("Telefone fixo: ");      
				teste = dados.nextLine();
				util.p("Celular: ");            
				teste = dados.nextLine();
				voltarSair();
			break;
			
			case 10 :
				pagina(indice);
				util.p("Jogador		CPF	Telefone fixo	Celular"); 
				//teste impressao
				util.p("testeteste	teste   testeteste 	testeteste");
				util.p("testeteste	teste	testeteste	testeteste");
				util.l();
				
				voltarSair();
			break;	
			
			case 100 :
				menu(anterior);
			break;
			
			default :
				util.p("Saindo...");
			break;
		}
		util.p(util.t(50));
		util.l();
		if ( indice > 0 && indice < 11 ){
			util.p("Escolha: ");
			tela = dados.nextInt();
			menu(tela);
		}
		util.l();
	}
	
	/**
	 * Imprime cabecalho do programa no console
	 * @return null
	 */
	public static void cabecalho(){
		util.p(util.t(150));
		util.p("FOOTMANAGER      v" + versao);
		util.p(util.t(150));
		util.l();
	}
	
	
	/**
	 * Imprime cabecalho da tabela
	 */
	public static void cabecalhoTabela(int titulo){
		String titulo2 = null;
		
		if(titulo == 2){ titulo2 = "Campeonatos";}
		if(titulo == 3){titulo2 = "Equipes";}
		if(titulo == 4){titulo2 = "Jogadores";}
		if(titulo == 5){titulo2 = "Cadastro de Campeonato";}
		if(titulo == 6){titulo2 = "Listagem dos Campeonatos";}
		if(titulo == 7){titulo2 = "Cadastrar nova equipe";}
		if(titulo == 8){titulo2 = "Listagem das Equipes Cadastradas";}
		if(titulo == 9){titulo2 = "Cadastro de Jogador";}
		if(titulo == 10){titulo2 = "Visualizar jogadores";}
		
		util.l();
		util.p(util.t(50));
		util.p(titulo2);
		util.p(util.t(50));
		util.l();
	}
	
	/**
	 * Salva os dados necessarios para acessar a tela que o usuario estava visualizando anteriormente
	 * 
	 * @param indice
	 */
	public static void pagina(int indice){
		int variavel = 1;
		
		cabecalhoTabela(indice);
		anterior = variavel;
		variavel = indice;
	}
	
	/**
	 * Imprime as opcoes 'voltar' e 'sair' na tela
	 */
	public static void voltarSair(){
		util.l();
		util.p("[1] Menu Principal	[100] Voltar	[0] Sair");
	}
}
