package projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import projeto.Conexao;
import projeto.Utilitarios;
public class Equipe {
	
	/**
	 * Objeto Utilitarios
	 */
	public static Utilitarios util = new Utilitarios();
	
	/**
	 * Objeto Conexao
	 */
	public static Conexao bd = new Conexao();
	
	/**
	 * String de conex‹o com o banco
	 */
	private static String connectionString;
	
	/**
	 * Connection
	 */
	private static Connection conn;
	
	private static String sql = "";
	
	
	/**
	 * Statement
	 */
	private static Statement smt;
	
	/**
	 * Cadastra nova equipe
	 * 
	 * @param nome
	 * @param apelido
	 * @param mascote
	 */
	private void cadastrar( String nome, String apelido, String mascote ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionString = "jdbc:mysql://localhost/footmanager?user=root&password=root";
			conn = DriverManager.getConnection( connectionString );
			sql = "INSERT INTO equipes ( null, '" + nome +"', '" + apelido +"', '"+ mascote +"')";
			smt = conn.createStatement();
			smt.execute(sql);
		} catch (Exception e) {
			util.p("Erro: " + e.getMessage());
		}
	}

}
