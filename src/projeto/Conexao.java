package projeto;
import projeto.Utilitarios;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
	
	/**
	 * Objeto Utilitarios
	 */
	public static Utilitarios util = new Utilitarios();
	
	/**
	 * String de conexao com o banco
	 */
	private static String connectionString;
	
	/**
	 * Connection
	 */
	Connection conn;
	

	public Connection getConnection(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); //Carrega driver JDBC
			connectionString = "jdbc:mysql://localhost/footmanager?user=root&password=root"; //String de conexao
			conn = DriverManager.getConnection( connectionString ); //Faz a conexao entre o driver e a String
			
		} catch (Exception e) {
			
			util.p("Erro:" + e.getMessage());
			
		}
		return null;
	}
}
