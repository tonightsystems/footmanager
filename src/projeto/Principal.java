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
	
	/**
	 * Objeto Campeonato
	 */
	public static Campeonato camp = new Campeonato();
	
	/**
	 * Objeto Partida
	 */
	public static Partida partida = new Partida();
	
	/**
	 * Declaracao Variaveis
	 */
	public static String teste;
	public static int anterior = 0;
	public static int cod, id_camp;

	/**
	 * Guarda a tela acessada no momento:
	 *
	 * 0 = Sair
	 * 1 = Menu inicial
	 * 2 = Campeonatos
	 * 3 = Equipes
	 * 4 = Jogadores
	 * 5 = Adicionar novo Campeonato
	 * 6 = Visualizar Todos os Campeonatos
	 * 7 = Editar Campeonato Cadastrado
	 * 8 = Deletar Campeonato Cadastrado
	 * 9 = Cadastrar Nova Equipe
	 * 10 = Visualizar Todas as Equipes
	 * 11 = Editar Equipe Cadastrada
	 * 12 = Deletar Equipe Cadastrada
	 * 13 = Cadastrar novo jogador
	 * 14 = Visualizar jogadores
	 * 15 = Editar Jogador Cadastrado
	 * 16 = Deletar Jogador Cadastrado
	 * 17 = Cadastrar nova partida
	 * 18 = Visualizar partidas
	 * 19 = Editar partida Cadastrada
	 * 20 = Deletar partida Cadastrada
	 * 
	 * 100 = Voltar
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
				util.p("[5] Adicionar Novo Campeonato");
				util.p("[6] Listar Campeonatos");
				util.p("[7] Editar Campeonato Cadastrado");
				util.p("[8] Deletar Campeonato Cadastrado");
				util.p("[21] Gerenciar Partidas");
				opcoes(indice);
			break;
			
			case 3 :
				cabecalhoTab("Equipes");
				util.p("[9]  Cadastrar Nova Equipe");
				util.p("[10] Visualizar Todas as Equipes");
				util.p("[11] Editar Equipe Cadastrada");
				util.p("[12] Deletar Equipe Cadastrada");
				opcoes(indice);
			break;
			
			case 4 :
				cabecalhoTab("Jogadores");
				util.p("[13] Cadastrar Novo Jogador");
				util.p("[14] Visualizar Jogadores");
				util.p("[15] Editar Jogador Cadastrado");
				util.p("[16] Deletar Jogador Cadastrado");
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
				opcoes(indice);
			break;	
			
			case 7 :
				cabecalhoTab("Editar Campeonato Cadastrado");
				camp.listar();
				util.l();
				util.p(util.t(50));
				
				util.p2("Informe o código do campeonato a ser editado: ");
				cod = dados.nextInt();
				util.p(util.t(50));
				util.l();
				camp.alterar(cod);
				util.l();
				util.p(util.t(50));
				opcoes(indice);
			break;		
			
			case 8 :
				cabecalhoTab("Deletar Campeonato Cadastrado");
				camp.listar();
				util.l();
				util.p(util.t(50));
				
				util.p2("Informe o código do campeonato a ser deletado: ");
				cod = dados.nextInt();
				
				camp.deletar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 9 :
				cabecalhoTab("Cadastrar Nova Equipe");
				equipe.cadastrar();
				opcoes(indice);
			break;	
			
			case 10 :
				cabecalhoTab("Listagem das Equipes Cadastradas");
				equipe.listar();
				opcoes(indice);
			break;	
			
			case 11 :
				cabecalhoTab("Editar Equipe Cadastrada");
				equipe.listar();
				util.l();
				util.p(util.t(50));
				
				util.p("Informe o código da equipe a ser editada: ");
				cod = dados.nextInt();
				
				util.p(util.t(50));
				util.l();
				equipe.alterar(cod);
				util.l();
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 12 :
				cabecalhoTab("Deletar Equipe Cadastrada");
				equipe.listar();
				util.l();
				util.p(util.t(50));

				util.p("Informe o código da equipe a ser deletada: ");
				cod = dados.nextInt();
				
				equipe.deletar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 13 :
				cabecalhoTab("Cadastro de Jogador");
				//jogador.cadastrar();
				opcoes(indice);
			break;
			
			case 14 :
				cabecalhoTab("Visualizar jogadores");
				//jogador.listar();
				opcoes(indice);
			break;	
			
			case 15 :
				cabecalhoTab("Editar Jogador Cadastrado");
				//jogador.listar();
				util.l();
				util.p(util.t(50));
				
				util.p("Informe o código do jogador a ser editado: ");
				cod = dados.nextInt();
				
				util.p(util.t(50));
				util.l();
				//jogador.alterar(cod);
				util.l();
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 16 :
				cabecalhoTab("Deletar Jogador Cadastrado");
				//jogador.listar();
				util.l();
				util.p(util.t(50));
				
				util.p("Informe o código do jogador a ser deletado: ");
				cod = dados.nextInt();
				
				//jogador.deletar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 17 :
				cabecalhoTab("Cadastro de Partida");
				partida.cadastrar(id_camp);
				opcoes(indice);
			break;
			
			case 18 :
				cabecalhoTab("Partidas Cadastradas");
				
				partida.listar(id_camp);
				opcoes(indice);
			break;
			
			case 19 :
				cabecalhoTab("Editar Partida Cadastrada");
				util.p("Partidas Existentes:");
				util.l();
				partida.listar(id_camp);
				util.l();
				util.p(util.t(50));
			
				util.p2("Informe o código da partida a ser editada: ");
				cod = dados.nextInt();
				
				util.p(util.t(50));
				util.l();
				partida.alterar(id_camp);
				util.l();
				util.p(util.t(50));
				opcoes(indice);
			break;
			
			case 20 :
				cabecalhoTab("Deletar Partida Cadastrada");
				util.p("Partidas Existentes:");
				util.l();
				partida.listar(id_camp);
				util.l();
				util.p(util.t(50));
				
				util.p2("Informe o código da partida a ser deletada: ");
				cod = dados.nextInt();
				
				partida.deletar(id_camp);
				util.p(util.t(50));
				opcoes(indice);
			break;
			
			case 21 :
				cabecalhoTab("Gerenciar Partidas");
				util.p("Campeonatos Existentes:");
				util.l();
				camp.listar();
				util.l();
				util.p(util.t(50));
				util.p2("Informe o código do campeonato: ");
				id_camp = dados.nextInt();
				util.p(util.t(50));
				
				cabecalhoTab("Partidas");
				util.p("[17] Cadastrar Nova Partida");
				util.p("[18] Visualizar Partidas");
				util.p("[19] Editar Partida Cadastrada");
				util.p("[20] Deletar Partida Cadastrada");
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
		if ( indice > 0 && indice < 30 ){
			util.p2("Escolha: ");
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