package projeto;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Avaliacao {

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
	 * Objeto Partida
	 */
	public static Partida partida = new Partida();
	
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
	 * Cadastrar nova avaliacao
	 */
	public void cadastrar(int id_camp, int id_part) {
		
		try {
			
			bd.getConnection();
			
			int id_jogador;
			String nota;
			smt = bd.conn.createStatement();
			
			util.p("Jogadores Cadastrados: ");
			util.l();
			jogador.listar();
			util.l();
			util.p(util.t(50));
			util.l();
			
			util.p2("Informe o código do Jogador: ");
			id_jogador = dados.nextInt();
			dados.nextLine();
			util.p(util.t(50));

			util.p2("Informe a nota do jogador: ");
			nota = dados.nextLine();		

			sql = "INSERT INTO jogadores(id_partidas, id_jogador, nota) " 
				+ "values( "
					+ "'" + id_camp + "', " 
					+ "'" + id_part + "', " 
					+ "'" + id_jogador + "', " 
					+ "'" + nota + "')";

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Alterar dados da avaliacao
	 */
	public void alterar(int id_camp, int id_part, int cod) {
		try {
			
			bd.getConnection();
			
			int id_partida = 0, id_jogador;
			String nota;
			smt = bd.conn.createStatement();
			
			util.p("Partidas Cadastradas: ");
			util.l();
			partida.listar(id_camp);
			util.l();
			util.p(util.t(50));
			util.l();
			
			util.p2("Informe o código da Partida: ");
			id_part = dados.nextInt();
			dados.nextLine();
			util.p(util.t(50));

			util.p("Jogadores Cadastrados: ");
			util.l();
			jogador.listar();
			util.l();
			util.p(util.t(50));
			util.l();
			
			util.p2("Informe o código do Jogador: ");
			id_jogador = dados.nextInt();
			dados.nextLine();
			util.p(util.t(50));
			
			util.p2("Informe a Nota: ");
			nota = dados.nextLine();
			
			sql = "UPDATE avaliacoes set " 
					+ "id_partida = '" + id_partida + "' , "
					+ "id_jogador = '" + id_jogador + "' , " 
					+ "nota = '" + nota;

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Listar avaliacoes cadastradas
	 */
	public void listar(int id_camp, int id_part) {
		try {
			
			bd.getConnection();
			smt = bd.conn.createStatement();
			ResultSet rs; 
			
			String sql = "select a.id, p.local, j.nome, a.nota " +
					"from avaliacoes a, partidas p, jogadores j " +
					"where a.id_partida = p.id and " +
					"a.id_jogador = j.id";

			rs = smt.executeQuery(sql); 
			
			while (rs.next() == true) {
				
				util.p(rs.getInt(1) 
						+ "    " + rs.getString(2)
						+ "    " + rs.getString(3) 
						+ "    " + rs.getInt(4)); 
				
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
	 * Deletar avaliacao cadastrada
	 */
	public void deletar(int cod) {
		
		try {
			
			bd.getConnection();
			smt = bd.conn.createStatement();

			sql = "delete from avaliacoes "
				+ "where id = " + cod;

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

}