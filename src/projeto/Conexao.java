package projeto;
import projeto.Utilitarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conexao {
	
	/**
	 * Utilitarios
	 */
	public static Utilitarios util = new Utilitarios();
	
	/**
	 * String de conexão com o banco
	 */
	private static String connectionString;
	
	/**
	 * Connection
	 */
	private static Connection conn;
	
	/**
	 * Statement
	 */
	private static Statement smt;
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionString = "jdbc:mysql://localhost/footmanager?user=root&password=root";
			conn = DriverManager.getConnection( connectionString );
			smt = conn.createStatement();
		} catch (Exception e) {
			util.p("Erro:" + e.getMessage());
		}
	}

}
