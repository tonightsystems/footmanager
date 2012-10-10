import java.util.Scanner;
public class telas {

	/**
	 * Versao do sistema
	 * 
	 * @type {String}
	 */
	public static String versao = "0.1 alpha";

	/**
	 * Guarda a tela acessado no momento
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
	 * Recebe os dados informado pelo usuário
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
				p("[5] Adicionar novo campeonato");
				p("[6] Listar camponatos");
				p("[0] Sair");
			break;
			default :
				p("Saindo...");
			break;
		}
		p(t(50));
		l();
		if ( indice > 0){
			p("Escolha: ");
			tela = dados.nextInt();
			menu(tela);
		}
		l();
	}
	
	/**
	 * Imprime cabealho do programa no console
	 */
	public static void cabecalho(){
		p(t(150));
		p("FOOTMANAGER      v" + versao);
		p(t(150));
		l();
	}
	
	/**
	 * Imprime um traco no console
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

}
