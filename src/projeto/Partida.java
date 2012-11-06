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
			String nome, apelido, mascote;
			smt = bd.conn.createStatement();

			System.out.print("Nome da Equipe: ");
			nome = dados.nextLine();

			System.out.print("Apelido: ");
			apelido = dados.nextLine();

			System.out.print("Mascote: ");
			mascote = dados.nextLine();

			sql = "INSERT INTO equipes(nome, apelido, mascote) " + "values( "
					+ "'" + nome + "', " + "'" + apelido + "', " + "'"
					+ mascote + "')";

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
			String nome, apelido, mascote;
			smt = bd.conn.createStatement();

			System.out.print("Nome da Equipe: ");
			nome = dados.nextLine();

			System.out.print("Apelido: ");
			apelido = dados.nextLine();

			System.out.print("Mascote: ");
			mascote = dados.nextLine();

			sql = "UPDATE equipes set " + "nome= '" + nome + "' , "
					+ "apelido= '" + apelido + "' , " + "mascote= '" + mascote
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
			smt = bd.conn.createStatement(); // createStatement() - Retorna um
												// objeto que representa uma
												// query ou comando
			ResultSet rs; // Contem o resultado da Query
			String sql = "select * from equipes";

			rs = smt.executeQuery(sql); // Executa a Query

			while (rs.next() == true) {
				System.out.println(rs.getInt(1) + "    " + rs.getString(2)
						+ "    " + rs.getString(3) + "    " + rs.getString(4)); // get
																				// -
																				// pegar/usar
			}
			rs.close();
			smt.close();
			bd.conn.close();
		} catch (Exception erro) {
			System.out.println("Um erro aconteceu.");
			System.out.println("Descricao: " + erro.getMessage());
		}
	}

	/**
	 * Deletar partida cadastrada
	 */
	public void deletar(int id) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();

			sql = "delete from equipes " + "where id = " + id;

			smt.execute(sql);
			bd.conn.close();

		} catch (Exception e) {

			util.p("Erro: " + e.getMessage());

		}
	}
}