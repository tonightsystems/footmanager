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
	 * Objeto Equipes
	 */
	public static Equipe equipe = new Equipe();
	
	/**
	 * Objeto Conexao
	 */
	public static Conexao bd = new Conexao();
	
	public static Campeonatos camp = new Campeonatos();
	
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
	 * 7 = Cadastrar Nova Equipe
	 * 8 = Visualizar Todas as Equipes
	 * 9 = Editar Equipe Cadastrada
	 * 10 = Deletar Equipe Cadastrada
	 * 11 = Cadastrar novo jogador
	 * 12 = Visualizar jogadores
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
	 * Metodo que imprime cabecalho do programa no console
	 * @return null
	 */
	public static void cabecalho(){
		util.p(util.t(150));
		util.p("FOOTMANAGER      v" + versao);
		util.p(util.t(150));
		util.l();
	}
	
	/**
	 * Metodo que imprime o cabecalho de cada tabela
	 */
	public static void cabecalhoTab(String titulo) {
		util.l();
		util.p(util.t(50));
		util.p(titulo);
		util.p(util.t(50));
		util.l();
	}
	
	/**
	 * Metodo que salva os dados necessarios para retornar a tela anterior
	 * 
	 * @param indice
	 */
	public static void voltarPag(int indice) {
		int variavel = 1;

		anterior = variavel;
		variavel = indice;
	}
	
	/**
	 * Metodo que imprime as opcoes 'menu principal, 'voltar' e 'sair' em cada tela
	 */
	public static void opcoes(int indice) {
		voltarPag(indice);
		util.l();
		util.p("[1] Menu Principal	[100] Voltar	[0] Sair");
	}
	
	/**
	 * Impressao do menu e das telas no console
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
				cabecalhoTab("Campeonatos");
				util.p("[5] Adicionar novo campeonato");
				util.p("[6] Listar campeonatos");
				opcoes(indice);
			break;
			
			case 3 :
				cabecalhoTab("Equipes");
				util.p("[7]  Cadastrar Nova Equipe");
				util.p("[8]  Visualizar Todas as Equipes");
				util.p("[9]  Editar Equipe Cadastrada");
				util.p("[10] Deletar Equipe Cadastrada");
				opcoes(indice);
			break;
			
			case 4 :
				cabecalhoTab("Jogadores");
				util.p("[11] Cadastrar novo jogador");
				util.p("[12] Visualizar jogadores");
				opcoes(indice);
			break;
			
			case 5 :
				cabecalhoTab("Cadastro de Campeonato");
				camp.cadastrar();
				opcoes(indice);
			break;
			
			case 6 :
				cabecalhoTab("Listagem dos Campeonatos");
				camp.listar();
				
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 7 :
				cabecalhoTab("Cadastrar Nova Equipe");
				equipe.cadastrar();
				opcoes(indice);
			break;	
			
			case 8 :
				cabecalhoTab("Listagem das Equipes Cadastradas");
				equipe.listar();
				
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 9 :
				cabecalhoTab("Editar Equipe Cadastrada");
				equipe.listar();
				util.l();
				util.p(util.t(50));
				
				int cod;
				util.p("Informe o código da equipe:");
				cod = dados.nextInt();
				
				equipe.alterar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 10 :
				cabecalhoTab("Deletar Equipe Cadastrada");
				equipe.listar();
				util.l();
				util.p(util.t(50));
				
				int cod2;
				util.p("Informe o código da equipe:");
				cod2 = dados.nextInt();
				
				equipe.deletar(cod2);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 11 :
				cabecalhoTab("Cadastro de Jogador");
				util.p("Nome do Jogador: ");    
				teste = dados.nextLine();
				dados.nextLine();
				util.p("CPF: ");                
				teste = dados.nextLine();
				util.p("Telefone fixo: ");      
				teste = dados.nextLine();
				util.p("Celular: ");            
				teste = dados.nextLine();
				opcoes(indice);
			break;
			
			case 12 :
				cabecalhoTab("Visualizar jogadores");
				
				util.p("Jogador		CPF	Telefone fixo	Celular"); 
				//teste impressao
				util.p("testeteste	teste   testeteste 	testeteste");
				util.p("testeteste	teste	testeteste	testeteste");
				util.l();
				
				opcoes(indice);
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
}