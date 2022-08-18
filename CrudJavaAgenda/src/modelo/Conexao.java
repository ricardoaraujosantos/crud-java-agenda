package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USERNAME = "root";

	private static final String PASSWORD = "Ry@n0903";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

	public static Connection createConnectionToMySQL() throws Exception {

		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}
}
