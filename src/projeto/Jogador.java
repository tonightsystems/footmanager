package projeto;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import projeto.Conexao;
import projeto.Utilitarios;

public class Jogador {

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
	 * Objeto Equipe
	 */
	public static Equipe equipe = new Equipe();
	
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
	 * Cadastrar novo jogador
	 */
	public void cadastrar( ) {
		try {
			bd.getConnection();
			String nome, cpf;
			int celular, telefone, id_equipe;
			smt = bd.conn.createStatement();
			
			System.out.print("Nome do jogador: "); 
			nome = dados.nextLine();
					
			System.out.print("Cpf: ");    
			cpf = dados.nextLine();
						
			System.out.print("Celular: ");
			celular = dados.nextInt();
			
			System.out.print("Telefone: ");
			telefone = dados.nextInt();

			util.l();
			util.p(util.t(50));
			equipe.listar();
			util.l();

			util.p2("Informe o codigo da equipe a qual pertence: ");
			id_equipe = dados.nextInt();
			util.p(util.t(50));
			
			sql = "INSERT INTO jogadores(nome, cpf, celular, telefone, id_equipe) " 
					+ "values( "
					+ "'" + nome + "', " 
					+ "'" + cpf + "', " 
					+ "'" + celular + "', " 
					+ "'" + telefone + "', " 
					+ "'" + id_equipe + "')";
			
			smt.execute(sql);
			util.l();
			util.p("Jogador inserido com sucesso!");
			
			bd.conn.close();
			
		} catch (Exception e) {
			
			util.p("Erro: " + e.getMessage());
			
		}
	}

	/**
	 * Alterar dados do jogador
	 */
	public void alterar(int id) {
		try {
			bd.getConnection();
			String nome;
			int cpf, celular, telefone, id_equipe;
			smt = bd.conn.createStatement();

			System.out.print("Nome do jogador: "); 
			nome = dados.nextLine();
					
			System.out.print("Cpf: ");    
			cpf = dados.nextInt();
			dados.nextLine();
		
			System.out.print("Celular: ");
			celular = dados.nextInt();
			dados.nextLine();
			
			System.out.print("Telefone: ");
			telefone = dados.nextInt();	
			dados.nextLine();
			
			util.l();
			util.p(util.t(50));
			equipe.listar();
			util.l();

			util.p2("Informe o codigo da equipe a qual pertence: ");
			id_equipe = dados.nextInt();
			util.p(util.t(50));
			
			sql = "UPDATE jogadores set " 
				+ "nome= '" + nome + "' , " 
				+ "cpf= '" + cpf + "' , " 
				+ "celular= '" + celular + "' ,"
				+ "telefone= '" + telefone + "' , " 
				+ "id_equipe= '" + id_equipe + "' " 
				+ "where id=" + id;
			
			smt.execute(sql);
			util.p("Jogador alterado com sucesso!");
			
			bd.conn.close();
			
		} catch (Exception e) {
			
			util.p("Erro: " + e.getMessage());
			
		}
	}
	
	/**
	 * Listar jogador cadastrado
	 */
	public void listar( ) {
		try {
			util.p("Jogadores Cadastrados: ");
			util.l();
			bd.getConnection();
			smt = bd.conn.createStatement(); //createStatement() - Retorna um objeto que representa uma query ou comando
			ResultSet rs; //Contem o resultado da Query
			
			String sql = "select * from jogadores order by nome";
			
			rs = smt.executeQuery(sql); //Executa a Query
			
			while( rs.next() == true ){
				  System.out.println( rs.getInt(1) + "    " + rs.getString(2) + "    " + rs.getString(3)+ "    " + rs.getString(4)); //get - pegar/usar
				}
				rs.close();
				smt.close();
				bd.conn.close();
			}
			catch( Exception erro  ){
				System.out.println("Um erro aconteceu.");
				System.out.println("Descricao: " + erro.getMessage() );
			}
	}
	
	/**
	 * Deletar jogador cadastrado
	 */
	public void deletar(int id) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();
			
			sql = "delete from jogadores " 
				+ "where id = " + id;
			
			smt.execute(sql);
			util.p("Jogador deletado com sucesso!");
			bd.conn.close();
			
		} catch (Exception e) {
			
			util.p("Erro: " + e.getMessage());
			
		}
	}
}
