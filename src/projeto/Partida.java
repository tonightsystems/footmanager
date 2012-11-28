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
	public void cadastrar(int id_camp) {
		
		try {
			
			bd.getConnection();
			
			int equipe1 = 0, equipe2 = 0;
			String dt_hra, local;
			smt = bd.conn.createStatement();

			equipe.listar();
			util.l();
			util.p(util.t(50));
			util.l();
			
			util.p2("Informe o código da 1° Equipe: ");
			equipe1 = dados.nextInt();
			dados.nextLine();
			
			util.p2("Informe o código da 2° Equipe: ");
			equipe2 = dados.nextInt();
			dados.nextLine();
			util.p(util.t(50));
			
			util.p2("Informe a data e a hora da Partida: ");
			dt_hra = dados.nextLine();
			
			util.p2("Informe o local da Partida: ");
			local = dados.nextLine();		
			util.l();

			sql = "INSERT INTO partidas(id_campeonato, id_equipe_1, id_equipe_2, data_e_hora, local) " 
				+ "values( "
					+ "'" + id_camp + "', " 
					+ "'" + equipe1 + "', " 
					+ "'" + equipe2 + "', " 
					+ "'" + dt_hra + "', " 
					+ "'" + local + "')";

			smt.execute(sql);			
			util.p("Partida inserida com sucesso!");
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Alterar dados da partida
	 */
	public void alterar(int id_camp, int id_part) {
		try {
			
			bd.getConnection();
			
			int equipe1, equipe2;
			String dt_hra, local;
			smt = bd.conn.createStatement();
			
			equipe.listar();
			util.l();
			util.p(util.t(50));
			util.l();
			
			util.p2("Informe o código da 1° Equipe: ");
			equipe1 = dados.nextInt();
			dados.nextLine();
			
			util.p2("Informe o código da 2° Equipe: ");
			equipe2 = dados.nextInt();
			dados.nextLine();

			util.p2("Informe a data e a hora da Partida: ");
			dt_hra = dados.nextLine();
			
			util.p2("Informe o local da Partida: ");
			local = dados.nextLine();
			util.l();
			
			sql = "UPDATE partidas set " 
					+ "id_campeonato= '" + id_camp + "' , "
					+ "id_equipe_1= '" + equipe1 + "' , " 
					+ "id_equipe_2= '" + equipe2 + "' , " 
					+ "data_e_hora= '" + dt_hra + "' , " 
					+ "local= '" + local + "' "			
					+ "where id=" + id_part;

			smt.execute(sql);
			util.p("Partida alterada com sucesso!");
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Listar partidas cadastradas
	 */
	public void listar(int id_camp) {
		try {
			util.p("Partidas Cadastradas: ");
			util.l();
			bd.getConnection();
			smt = bd.conn.createStatement();
			ResultSet rs; 
			
			String sql = "select p.id, c.nome, e.nome, p.data_e_hora, p.local " +
					"from partidas p, campeonatos c, equipes e " +
					"where c.id = p.id_campeonato and " +
					"e.id = p.id_equipe_1";

			rs = smt.executeQuery(sql); 
			
			while (rs.next() == true) {
				
				util.p(rs.getInt(1) 
						+ "    " + rs.getString(2)
						+ "    " + rs.getString(3) 
						+ "    " + rs.getString(4)
						+ "    " + rs.getString(5)); 
				
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
	public void deletar(int id_camp) {
		
		try {
			
			bd.getConnection();
			smt = bd.conn.createStatement();

			sql = "delete from partidas " 
				+ "where id = " + id_camp;

			smt.execute(sql);
			util.p("Partida deletada com sucesso!");
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}
}