
/* Name: Ruchika Akhand

 * November 8th, 2017
 * Connector.java File
 * Lab 4
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

// This class allows us to connect to Professor's database server!
public class Connector {
	public Connection getConnection() {
		Connection connect = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			// link given to use to connect
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/510labs?" + "user=db510&password=510");
			//error trapping
		}catch (SQLException e) {
			System.out.println(" The error is :" + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
	}
}
