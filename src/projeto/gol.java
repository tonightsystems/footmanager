package projeto;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import projeto.Conexao;
import projeto.Utilitarios;

public class gol {
	
	/**
	 * Recebe os dados informados pelo usuario
	 * @type {Scanner}
	 */
	Scanner dados = new Scanner(System.in);
	
	/**
	 * Objeto Conexao
	 */
	public static Conexao bd = new Conexao();
	
	/**
	 * Objeto Utilitarios
	 */
	public static Utilitarios util = new Utilitarios();
	
	/**
	 * Objeto Equipe
	 */
	public static Equipe equipe = new Equipe();
	
	/**
	 * Statement
	 */
	private static Statement smt;
	
	/**
	 * Declaracao da variavel SQL
	 */
	private static String sql = "";
	
	/**
	 * Cadastrar novo gol	
	 */
	public static void main(String[] args) {
		
	}

}
