package projeto;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import projeto.Conexao;
import projeto.Utilitarios;
import projeto.Equipe;

public class Gol {
	
	/**
	 * Recebe os dados informados pelo usuario
	 * @type {Scanner}
	 */
	static Scanner dados = new Scanner(System.in);
	
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
	 * MŽtodo para cadastrar novo gol	
	 */
	public static void cadastrar() {
		try {
			bd.getConnection();
			int jogador, time;
			String contra;
			smt = bd.conn.createStatement();
			
			util.p("Qual equipe fez o gol?");
			equipe.listar();
			time = dados.nextInt();
			dados.nextLine();
			
			util.p("O gol foi contra(s ou n)?");
			contra = dados.nextLine();
			
			util.p("Qual jogador fez o gol?");
			jogador = dados.nextInt();
			
			sql = "INSERT INTO gols(equipe, contra, jogador) " 
					+ "values( "
					+ "'" + time + "', " 
					+ "'" + contra + "', " 
					+ "'" + jogador + "')";
			
			smt.execute(sql);
			bd.conn.close();
		} catch (Exception e) {
			util.p("Erro: " + e.getMessage());			
		}
	}
	
	/**
	 * MŽtodo para editar os gols cadastrados
	 */
	public void editar(int id) {
		try {
			bd.getConnection();
			int jogador, time;
			String contra;
			smt = bd.conn.createStatement();
			
			util.p("Qual equipe fez o gol?");
			time = dados.nextInt();
			dados.nextLine();
			
			util.p("O gol foi contra(s ou n)?");
			contra = dados.nextLine();
			
			util.p("Qual jogador fez o gol?");
			jogador = dados.nextInt();
			
			sql = "UPIDATE gols set"
			+ "equipe= '" + time + "' , " 
			+ "contra= '" + contra + "' , " 
			+ "jogador= '" + jogador + "' "
			+ "where id=" + id;
			
			smt.execute(sql);
			bd.conn.close();
			
		} catch (Exception e) {
			util.p("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * MŽtodo para deletar gols
	 */
	public void deletar(int id) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();
			
			sql = "delete from gols " 
					+ "where id = " + id;
			
			smt.execute(sql);
			bd.conn.close();
			
		} catch (Exception e) {	
				util.p("Erro: " + e.getMessage());
		}
	}
}
