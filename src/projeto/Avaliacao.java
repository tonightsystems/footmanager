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
	public void cadastrar(int id_part, int id_joga) {
		
		try {
			
			bd.getConnection();
			String nota;
			smt = bd.conn.createStatement();

			util.p2("Informe a nota do jogador: ");
			nota = dados.nextLine();		

			sql = "INSERT INTO avaliacoes(id_partida, id_jogador, nota) " 
				+ "values( "
					+ "'" + id_part + "', " 
					+ "'" + id_joga + "', " 
					+ "'" + nota + "')";

			smt.execute(sql);
			util.l();
			util.p("Avaliacao inserida com sucesso!");
			
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Alterar dados da avaliacao
	 */
	public void alterar(int cod, int id_aval) {
		try {
			
			bd.getConnection();
			
			int id_part = 0, id_joga,nota;
			smt = bd.conn.createStatement();
			
			util.l();
			partida.listar(cod);
			util.l();
			util.p2("Informe o codigo da nova Partida: ");
			id_part = dados.nextInt();
			dados.nextLine();
			util.p(util.t(50));

			util.l();
			jogador.listar();
			util.l();	
			util.p2("Informe o codigo do novo Jogador: ");
			id_joga = dados.nextInt();
			dados.nextLine();
			
			util.p(util.t(50));
			
			util.p2("Informe a Nota: ");
			nota = dados.nextInt();
			dados.nextLine();
			util.l();
			
			sql = "UPDATE avaliacoes set " 
					+ "id_partida = '" + id_part + "' , "
					+ "id_jogador = '" + id_joga + "' , " 
					+ "nota = ' " + nota + "' "
					+ "where id = " + cod;

			smt.execute(sql);
			util.p("Avaliacao alterada com sucesso!");
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

	/**
	 * Listar avaliacoes cadastradas
	 */
	public void listar(int id_part, int id_joga) {
		try {
			util.p("Avaliacoes Cadastradas: ");
			util.l();
			bd.getConnection();
			smt = bd.conn.createStatement();
			ResultSet rs; 
			
			String sql = "select a.id, j.nome, a.nota " +
					"from avaliacoes a, partidas p, jogadores j " +
					"where " + id_part + " = p.id and " +
					id_joga + " = j.id";

			rs = smt.executeQuery(sql); 
			
			while (rs.next() == true) {
				
				util.p(rs.getInt(1) 
						+ "    " + rs.getString(2)
						+ "    " + rs.getInt(3)); 
				
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
	public void deletar(int id_aval) {
		
		try {
			
			bd.getConnection();
			smt = bd.conn.createStatement();

			sql = "delete from avaliacoes "
				+ "where id = " + id_aval;

			smt.execute(sql);
			util.p("Avaliacao deletada com sucesso!");
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}

}