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
	 * Metodo para cadastrar novo gol	
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
	 * Metodo para editar os gols cadastrados
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
			
			sql = "UPDATE gols set"
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
	 * Listar gols cadastrados
	 */
	public void listar( ) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement(); 
			ResultSet rs; 
			String sql = "select * from gols";
			
			rs = smt.executeQuery(sql); 
			
			while( rs.next() == true ){
				  util.p( rs.getInt(1) + "    " + rs.getInt(2) + "    " + rs.getString(3)+ "    " + rs.getInt(4)); 
				}
				rs.close();
				smt.close();
				bd.conn.close();
			}
			catch( Exception erro  ){
				util.p("Um erro aconteceu.");
				util.p("Descricao: " + erro.getMessage() );
			}
	}
	
	/**
	 * Metodo para deletar gols
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
