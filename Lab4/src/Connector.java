import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Connecting to Database Server
public class Connector
{
	public Connection getConnection()
	{
		Connection connect=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://www.papademas.net/510labs?"+"user=db510&password=510");
		}
		catch(SQLException e)
		{
			System.out.println(" The error is :"+e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}
}
