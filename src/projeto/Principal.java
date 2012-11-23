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
	 * Objeto Jogadores
	 */
	public static Jogador jogador = new Jogador();
	
	/**
	 * Objeto Conexao
	 */
	public static Conexao bd = new Conexao();
	
	/**
	 * Objeto Campeonato
	 */
	public static Campeonato camp = new Campeonato();
	
	/**
	 * Objeto Avaliacao
	 */
	public static Avaliacao avaliacao = new Avaliacao();
	
	/**
	 * Objeto Gol
	 */
	public static Gol gol = new Gol();
	
	/**
	 * Declaracao Variaveis
	 */
	public static String teste;
	public static int anterior = 0;
	public static int cod, id_part, id_joga, id_equi;

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
	 * 9 = Gerenciar Campeonato
	 * 10 = Cadastrar Nova Equipe
	 * 11 = Visualizar Todas as Equipes
	 * 12 = Editar Equipe Cadastrada
	 * 13 = Deletar Equipe Cadastrada
	 * 14 = Cadastrar novo jogador
	 * 15 = Visualizar jogadores
	 * 16 = Editar Jogador Cadastrado
	 * 17 = Deletar Jogador Cadastrado

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
				cabecalhoTab("CAMPEONATOS");
				util.p("[5] Adicionar Novo Campeonato");
				util.p("[6] Listar Campeonatos");
				util.p("[7] Editar Campeonato Cadastrado");
				util.p("[8] Deletar Campeonato Cadastrado");
				util.p("[9] Gerenciar Campeonato");
				opcoes(indice);
			break;
			
			case 3 :
				cabecalhoTab("EQUIPES");
				util.p("[10] Cadastrar Nova Equipe");
				util.p("[11] Visualizar Todas as Equipes");
				util.p("[12] Editar Equipe Cadastrada");
				util.p("[13] Deletar Equipe Cadastrada");
				opcoes(indice);
			break;
			
			case 4 :
				cabecalhoTab("JOGADORES");
				util.p("[14] Cadastrar Novo Jogador");
				util.p("[15] Visualizar Jogadores");
				util.p("[16] Editar Jogador Cadastrado");
				util.p("[17] Deletar Jogador Cadastrado");
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
				
				util.p2("Informe o codigo do campeonato a ser deletado: ");
				cod = dados.nextInt();
				
				camp.deletar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 9 :			
				cabecalhoTab("GERENCIAMENTO DE CAMPEONATOS");
				camp.listar();
				util.l();
				util.p(util.t(50));
				
				util.p2("Informe o codigo do campeonato: ");
				cod = dados.nextInt();
				util.p(util.t(50));
				util.l();
				
				if(cod > 0){ 
					util.p("[20] Partidas");
					util.p("[21] Avaliacoes dos Jogadores");
					util.p("[22] Gols");
				}
				opcoes(indice);				
			break;		
				
			case 10 :
				cabecalhoTab("Cadastrar Nova Equipe");
				equipe.cadastrar();
				opcoes(indice);
			break;	
			
			case 11 :
				cabecalhoTab("Listagem das Equipes Cadastradas");
				equipe.listar();
				opcoes(indice);
			break;	
			
			case 12 :
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
			
			case 13 :
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
			
			case 14 :
				cabecalhoTab("Cadastro de Jogador");
				jogador.cadastrar();
				opcoes(indice);
			break;
			
			case 15 :
				cabecalhoTab("Visualizar Jogadores");
				jogador.listar();
				
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 16 :
				cabecalhoTab("Editar Jogador Cadastrado");
				jogador.listar();
				util.l();
				util.p(util.t(50));
				
				util.p("Informe o código do jogador a ser editado: ");
				cod = dados.nextInt();
				
				cod = dados.nextInt();
				util.p(util.t(50));
				util.l();
				jogador.alterar(cod);
				util.l();

				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 17 :
				cabecalhoTab("Deletar Jogador Cadastrado");
				jogador.listar();
				util.l();
				util.p(util.t(50));

				util.p("Informe o código do jogador a ser deletado: ");
				cod = dados.nextInt();
				
				jogador.deletar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 20 :
				cabecalhoTab("PARTIDAS");
				
				/* -------------------- INFORMA SE PARTIDAS JA FORAM GERADAS 
				if(respPartidas == "true"){
					util.p("As partidas deste campeonato ja foram geradas!!");
					partida.listar();
					util.p("Não é possível edita-las. Deseja excluir todas as partidas deste campeonato? s/n: ");
					r = dados.nextLine();
					if(r == "s"){
						partidas.deletar();
					}
				} else {
					util.p("[] Gerar Partidas");
					util.p("Partidas geradas com sucesso!");
				}*/
				
				opcoes(indice);
			break;
			
			case 21 :
				cabecalhoTab("AVALIACOES DOS JOGADORES");
				
				//partida.listar();
				util.l();
				util.p(util.t(50));				
				util.p2("Informe o codigo da partida: ");
				id_part = dados.nextInt();
				dados.nextLine();

				jogador.listar();
				util.l();
				util.p(util.t(50));				
				util.p2("Informe o codigo do jogador: ");
				id_joga = dados.nextInt();		
				
				if(id_part > 0 && id_joga > 0){
					util.p("[23] Adicionar Nova Avaliacao");
					util.p("[24] Listar Avaliacoes");
					util.p("[25] Editar Avaliacao Cadastrada");
					util.p("[26] Deletar Avaliacao Cadastrada");
				}
				
				opcoes(indice);
			break;
			
			case 22 :
				cabecalhoTab("GOLS");
				
				//partida.listar();
				util.l();
				util.p(util.t(50));				
				util.p2("Informe o codigo da partida: ");
				id_part = dados.nextInt();
				dados.nextLine();

				equipe.listar();
				util.l();
				util.p(util.t(50));				
				util.p2("Informe o codigo da equipe: ");
				id_equi = dados.nextInt();	
				dados.nextLine();
				
				jogador.listar();
				util.l();
				util.p(util.t(50));				
				util.p2("Informe o codigo do jogador: ");
				id_joga = dados.nextInt();		
				
				if(id_part > 0 && id_equi > 0 && id_joga > 0){
					util.p("[27] Adicionar Novo Gol ao Jogador");
					util.p("[28] Listar Gols do Jogador");
					util.p("[29] Editar Gol Cadastrado");
					util.p("[30] Deletar Gol Cadastrado");
				}
				
				opcoes(indice);
			break;
				
			case 23 :
				cabecalhoTab("Cadastrar Nova Avaliacao");
				avaliacao.cadastrar(id_part, id_joga);
				opcoes(indice);
			break;	
			
			case 24 :
				cabecalhoTab("Listagem das Avaliacoes Cadastradas");
				avaliacao.listar(id_part, id_joga);
				opcoes(indice);
			break;	
			
			case 25 :
				cabecalhoTab("Editar Avaliacao Cadastrada");
				
				avaliacao.listar(id_part, id_joga);
				util.l();
				util.p(util.t(50));
				util.p("Informe o codigo da avaliacao a ser editada: ");
				cod = dados.nextInt();
				
				util.p(util.t(50));
				util.l();
				avaliacao.alterar(cod);
				util.l();
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 26 :
				cabecalhoTab("Deletar Avaliacao Cadastrada");
				avaliacao.listar(id_part, id_joga);
				util.l();
				util.p(util.t(50));

				util.p("Informe o codigo da avaliacao a ser deletada: ");
				cod = dados.nextInt();

				avaliacao.deletar(cod);
				util.p(util.t(50));
				opcoes(indice);
			break;		
			
			case 27 :
				cabecalhoTab("Cadastrar Novo Gol ao Jogador");
				gol.cadastrar();
				opcoes(indice);
			break;	
			
			case 28 :
				cabecalhoTab("Listagem dos Gols Cadastrados");
				gol.listar();
				opcoes(indice);
			break;	
			
			case 29 :
				cabecalhoTab("Editar Gol Cadastrado");
				gol.listar();
				util.l();
				util.p(util.t(50));

				util.p("Informe o codigo do gol a ser editado: ");
				cod = dados.nextInt();
				
				util.p(util.t(50));
				util.l();
				gol.alterar(cod);
				util.l();
				util.p(util.t(50));
				opcoes(indice);
			break;	
			
			case 30 :
				cabecalhoTab("Deletar Gol Cadastrado");
				gol.listar();
				util.l();
				util.p(util.t(50));

				util.p("Informe o codigo do gol a ser deletado: ");
				cod = dados.nextInt();

				gol.deletar(cod);
				util.p(util.t(50));
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
		
		if ( indice > 0 && indice < 101 ){

			util.p2("Escolha: ");
			tela = dados.nextInt();
			menu(tela);
			
		}
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