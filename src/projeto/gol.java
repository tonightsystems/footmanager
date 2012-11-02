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
	public void cadastrar() {
		try {
			bd.getConnection();
			String jogador, equipe, contra;
			smt = bd.conn.createStatement();
			
			util.p("Qual equipe fez o gol?");
			equipe = dados.nextLine();
			
			util.p("O gol foi contra(s ou n)?");
			contra = dados.nextLine();
			
			util.p("Qual jogador fez o gol?");
			jogador = dados.nextLine();
			
			sql = "INSERT INTO gols(equipe, contra, jogador) " 
					+ "values( "
					+ "'" + equipe + "', " 
					+ "'" + contra + "', " 
					+ "'" + jogador + "')";
			
			smt.execute(sql);
			bd.conn.close();
		} catch (Exception e) {
			util.p("Erro: " + e.getMessage());			
		}
	} 
	public static void main(String[] args) {
		
	}

}
