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
	 * Objeto Jogador
	 */
	public static Jogador jogador = new Jogador();
	
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
	public static void cadastrar(int id_part, int id_joga) {
		try {
			bd.getConnection();
			int id_equipe;
			String gol_contra;
			smt = bd.conn.createStatement();
			
			equipe.listar();
			util.l();
			util.p2("Informe a equipe que fez o gol: ");
			id_equipe = dados.nextInt();
			dados.nextLine();
			
			util.p2("O gol foi contra(1- sim ou 2- nao): ");
			gol_contra = dados.nextLine();
			util.l();
			util.p(util.t(50));		
			util.l();		
			
			sql = "INSERT INTO gols(id_partida, id_equipe, id_jogador, gol_contra) " 
					+ "values( "
					+ "'" + id_part + "', " 
					+ "'" + id_equipe + "', " 
					+ "'" + id_joga + "', " 
					+ "'" + gol_contra + "')";
			
			smt.execute(sql);
			util.p("Gol inserido com sucesso!");
			
			bd.conn.close();
		} catch (Exception e) {
			util.p("Erro: " + e.getMessage());			
		}
	}
	
	/**
	 * Metodo para alterar os gols cadastrados
	 */
	public void alterar(int id_part) {
		try {
			bd.getConnection();
			int id_equipe, id_joga;
			String gol_contra;
			smt = bd.conn.createStatement();

			equipe.listar();
			util.l();
			util.p2("Informe a equipe que fez o gol: ");
			id_equipe = dados.nextInt();
			dados.nextLine();
			
			util.p2("O gol foi contra(1- sim ou 2- nao): ");
			gol_contra = dados.nextLine();
			util.l();
			util.p(util.t(50));		
			util.l();		

			jogador.listar();
			util.l();
			util.p2("Informe o jogador que fez o gol: ");
			id_joga = dados.nextInt();
			dados.nextLine();
			
			sql = "UPDATE gols set"
				+ "id_partida= " + id_part + " , " 
				+ "id_equipe= " + id_equipe + " , " 
				+ "id_jogador= " + id_joga + " , " 
				+ "gol_contra= " + gol_contra 
				+ " where id= " + id_part;
			
			smt.execute(sql);
			util.p("Gol alterado com sucesso!");
			
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
			util.p("Gols Cadastrados: ");
			util.l();
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
			util.p("Gol deletado com sucesso!");
			
			bd.conn.close();
			
		} catch (Exception e) {	
				util.p("Erro: " + e.getMessage());
		}
	}

}
