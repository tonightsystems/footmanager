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
	
	/**
	 * Efetua a conexao com o banco
	 * 
	 * @return null
	 */
	public Connection getConnection(){
		try {
			//Carrega driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			//String de conexao
			connectionString = "jdbc:mysql://localhost/footmanager?user=root&password=root";
			//Faz a conexao entre o driver e a String
			conn = DriverManager.getConnection( connectionString );
		} catch (Exception e) {
			util.p("Erro:" + e.getMessage());
		}
		
		return null;
	}
}
