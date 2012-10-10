import java.util.Scanner;
public class telas {

	/**
	 * Versao do sistema
	 * 
	 * @type {String}
	 */
	public static String versao = "0.1 alpha";
	
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
		cabecalho();
		menu(tela);
	}
	
	/**
	 * Imprime o menu e as telas no console
	 */
	public static void menu(int indice){
		p(t(50));
		switch(indice){
		
			case 1 :
				p("[2] Campeonatos");
				p("[3] Equipes");
				p("[4] Jogadores");
				l();
				p("[0] Sair");
			break;
			
			case 2 :
				pagina(indice);
				p("[5] Adicionar novo campeonato");
				p("[6] Listar campeonatos");
				voltarSair();
			break;
			
			case 3 :
				pagina(indice);
				p("[7] Cadastrar nova equipe");
				p("[8] Visualizar equipes");
				voltarSair();
			break;
			
			case 4 :
				pagina(indice);
				p("[9] Cadastrar novo jogador");
				p("[10] Visualizar jogadores");
				voltarSair();
			break;
			
			case 5 :
				pagina(indice);
				p("Nome do Campeonato: "); 
				teste = dados.nextLine(); 
				dados.nextLine();
				p("Data de início: ");     
				teste = dados.nextLine(); 
				p("Data de término: ");    
				teste = dados.nextLine();
				dados.nextLine();
				voltarSair();
			break;
			
			case 6 :
				pagina(indice);
				p("Campeonato	Data de início	Data de término"); 
				
				//teste impressao
				p("testeteste	testetesteteste	testetesteteste");
				p("testeteste	testetesteteste	testetesteteste");
				l();
				
				p(t(50));
				voltarSair();
			break;	
			
			case 7 :
				pagina(indice);
				p("Nome da Equipe: "); 
				teste = dados.nextLine();
				dados.nextLine();
				p("Apelido: ");        
				teste = dados.nextLine();
				p("Mascote: ");        
				teste = dados.nextLine();
				voltarSair();
			break;	
			
			case 8 :
				pagina(indice);
				p("Equipe		Data de início	  Data de término"); 
				
				//teste impressao
				p("testeteste	testetesteteste	  testetesteteste");
				p("testeteste	testetesteteste	  testetesteteste");
				l();
				
				p(t(50));
				voltarSair();
			break;	
			
			case 9 :
				pagina(indice);
				p("Nome do Jogador: ");    
				teste = dados.nextLine();
				dados.nextLine();
				p("CPF: ");                
				teste = dados.nextLine();
				p("Telefone fixo: ");      
				teste = dados.nextLine();
				p("Celular: ");            
				teste = dados.nextLine();
				voltarSair();
			break;
			
			case 10 :
				pagina(indice);
				p("Jogador		CPF	Telefone fixo	Celular"); 
				//teste impressao
				p("testeteste	teste   testeteste 	testeteste");
				p("testeteste	teste	testeteste	testeteste");
				l();
				
				voltarSair();
			break;	
			
			case 100 :
				menu(anterior);
			break;
			
			default :
				p("Saindo...");
			break;
		}
		p(t(50));
		l();
		if ( indice > 0 && indice < 11 ){
			p("Escolha: ");
			tela = dados.nextInt();
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
			l();
	}
	
	/**
	 * Imprime cabecalho da tabela
	 */
	public static void cabeTab(int titulo){
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
		
		l();
		p(t(50));
		p(titulo2);
		p(t(50));
		l();
	}
	
	/**
	 * Salva os dados necessarios para acessar a tela que o usuario estava visualizando anteriormente
	 * 
	 * @param indice
	 */
	public static void pagina(int indice){
		int variavel = 1;
		
		cabeTab(indice);
		anterior = variavel;
		variavel = indice;
	}
	
	/**
	 * Imprime as opcoes 'voltar' e 'sair' na tela
	 */
	public static void voltarSair(){
		l();
		p("[1] Menu Principal	[100] Voltar	[0] Sair");
	}
}
