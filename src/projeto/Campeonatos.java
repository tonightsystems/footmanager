package projeto;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import projeto.Conexao;
import projeto.Utilitarios;

public class Campeonatos {
		
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
	 * Statement
	 */
	private static Statement smt;
	
	/**
	 * Declaracao da variavel SQL
	 */
	private static String sql = "";
	
	/**
	 * Cadastrar novo campeonato
	 */
	public void cadastrar() {
		try {
			bd.getConnection();
			String nome, data_inicio, data_termino;
			smt = bd.conn.createStatement();
			
			util.p("Nome do Campeonato: "); 
			nome = dados.nextLine();
					
			util.p("Data de Inicio: ");    
			data_inicio = dados.nextLine();
			
			util.p("Data de Termino: ");
			data_termino = dados.nextLine();	
			
			sql = "INSERT INTO campeonatos(nome, data_inicio, data_termino) " 
					+ "values( "
					+ "'" + nome + "', " 
					+ "'" + data_inicio + "', " 
					+ "'" + data_termino + "')";
			
			smt.execute(sql);
			bd.conn.close();
			
		} catch (Exception e) {
			util.p("Erro: " + e.getMessage());
		}
	}

	/**
	 * Alterar dados da equipe
	 */
	public void alterar(int id) {
		try {
			bd.getConnection();
			String nome, data_inicio, data_termino;
			smt = bd.conn.createStatement();
			
			util.p("Nome do Campeonato: "); 
			nome = dados.nextLine();
					
			util.p("Data de Inicio: ");    
			data_inicio = dados.nextLine();
			
			util.p("Data de Termino: ");
			data_termino = dados.nextLine();
			
			sql = "UPDATE campeonatos set " 
				+ "nome= '" + nome + "' , " 
				+ "data_inicio= '" + data_inicio + "' , " 
				+ "data_termino= '" + data_termino + "' "
				+ "where id=" + id;
			
			smt.execute(sql);
			bd.conn.close();
			
		} catch (Exception e) {
			
			util.p("Erro: " + e.getMessage());
			
		}
	}
	
	/**
	 * Listar campeonatos cadastrados
	 */
	public void listar( ) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();
			ResultSet rs;
			String sql = "select * from campeonatos";
			
			rs = smt.executeQuery(sql);
			
			while( rs.next() == true ){
				  System.out.println( rs.getInt(1) + "    " + rs.getString(2) + "    " + rs.getString(3)+ "    " + rs.getString(4));
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
	 * Deletar campeonato cadastrado
	 */
	public void deletar(int id) {
		try {
			bd.getConnection();
			smt = bd.conn.createStatement();
			
			sql = "delete from campeonatos " 
					+ "where id = " + id;
			
			smt.execute(sql);
			bd.conn.close();
			
		} catch (Exception e) {
			
			util.p("Erro: " + e.getMessage());
			
		}
	}
}
