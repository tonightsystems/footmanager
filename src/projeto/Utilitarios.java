package projeto;

public class Utilitarios {

	/**
	 * Imprime nova linha com texto no console
	 * 
	 * @param string texto Texto a ser impresso. Obrigatorio.
	 */
	public void p(Object texto){
		System.out.println(texto);
	}
	
	/**
	 * Imprime uma linha vazia no console
	 */
	public void l(){
		System.out.println();
	}
	
	/**
	 * Limpar a tela
	 */
	public void cls(){
		for(int i = 0; i < 15; i++)
			l();
	}

}
