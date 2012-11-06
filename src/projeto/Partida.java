package projeto;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Partida {

	/**
	 * Recebe os dados informados pelo usuario
	 * 
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
	 * Objeto Campeonato
	 */
	public static Campeonato camp = new Campeonato();

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
	 * Cadastrar nova partida
	 */
	public void cadastrar() {
		try {
			bd.getConnection();
			
			int id_camp, equipe1, equipe2;
			String dt_hra, local;
			smt = bd.conn.createStatement();

			camp.listar();
			util.p2("Informe o código do campeonato: ");
			id_camp = dados.nextInt();
			dados.nextInt();
			
			equipe.listar();
			util.p("Informe o código da 1° Equipe: ");
			equipe1 = dados.nextInt();
			dados.nextInt();
			
			util.p("Informe o código da 2° Equipe: ");
			equipe2 = dados.nextInt();
			dados.nextInt();

			util.p("Informe a data e a hora da Partida: ");
			dt_hra = dados.nextLine();
			
			util.p("Informe o local da Partida: ");
			local = dados.nextLine();		

			sql = "INSERT INTO partidas(id_campeonato, id_equipe_1, id_equipe_2, data_e_hora, local) " + "values( "
					+ "'" + id_camp + "', " 
					+ "'" + equipe1 + "', " 
					+ "'" + equipe2 + "', " 
					+ "'" + dt_hra + "', " 
					+ "'" + local + "')";

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Alterar dados da partida
	 */
	public void alterar(int id) {
		try {
			bd.getConnection();
			
			int id_camp, equipe1, equipe2;
			String dt_hra, local;
			smt = bd.conn.createStatement();

			camp.listar();
			util.p2("Informe o código do campeonato: ");
			id_camp = dados.nextInt();
			dados.nextInt();
			
			equipe.listar();
			util.p("Informe o código da 1° Equipe: ");
			equipe1 = dados.nextInt();
			dados.nextInt();
			
			util.p("Informe o código da 2° Equipe: ");
			equipe2 = dados.nextInt();
			dados.nextInt();

			util.p("Informe a data e a hora da Partida: ");
			dt_hra = dados.nextLine();
			
			util.p("Informe o local da Partida: ");
			local = dados.nextLine();
			
			sql = "UPDATE partidas set " 
					+ "id_campeonato= '" + id_camp + "' , "
					+ "id_equipe_1= '" + equipe1 + "' , " 
					+ "id_equipe_2= '" + equipe2 + "' , " 
					+ "data_e_hora= '" + dt_hra + "' , " 
					+ "local= '" + local			
					+ "' " + "where id=" + id;

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Listar partidas cadastradas
	 */
	public void listar() {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();
			ResultSet rs; 
			String sql = "select * from partidas";

			rs = smt.executeQuery(sql); 
			
			while (rs.next() == true) {
				util.p(rs.getInt(1) 
						+ "    " + rs.getInt(2)
						+ "    " + rs.getInt(3) 
						+ "    " + rs.getInt(4)
						+ "    " + rs.getString(5)
						+ "    " + rs.getString(6)); 
			}
			
			rs.close();
			smt.close();
			bd.conn.close();
			
		} catch (Exception erro) {
			
			util.p("Um erro aconteceu.");
			util.p("Descricao: " + erro.getMessage());
			
		}
	}

	/**
	 * Deletar partida cadastrada
	 */
	public void deletar(int id) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();

			sql = "delete from partidas " + "where id = " + id;

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}
}