package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cn {
	static Connection connection;
	public static Connection createConnection() throws Exception{
			// Load Class Driver it can may throw exception
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establish Connection
			String user = "root";
			String password = "sagar12345";
			String url = "jdbc:mysql://localhost:3306/student_management_system";
		
			connection = DriverManager.getConnection(url, user, password);
			
		return connection;
	
	}
}
