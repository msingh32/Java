
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//This class
public class daoModels extends BankRecord
{
	Connector connect= new Connector();
	private Statement statement = null;
	
	// Method to create table r_akha_tab in database
	public void createTable() throws Exception
	{
		try
		{
			statement=connect.getConnection().createStatement();
			String sql="CREATE TABLE IF NOT EXISTS m_sing_tab "+
			"(pid Integer not NULL AUTO_INCREMENT,"+
			"ID varchar(7),"+
			"INCOME numeric(8,2),"+
			"PEP varchar(3),"+
			"PRIMARY KEY(pid))";
			//Sql statement executed to create table
			statement.executeUpdate(sql);
			System.out.println(" A table is created in the database..........");
			statement.close();
			
		}
			catch(SQLException e)
			{
				System.out.println(" The error is :"+e);
			}
	}
	
	//This method inserts data in table r_akha_tab
	public void inserts(BankRecord[] brobj) throws Exception
	{
		try
		{
			statement=connect.getConnection().createStatement();
			String sql=null;
			int i;
			for(i = 0; i<brobj.length; ++i)
			{
			sql="INSERT INTO m_sing_tab(ID,INCOME,PEP)"+
			"VALUES('"+brobj[i].getId()+"','"+brobj[i].getIncome()+"','"+brobj[i].getPep()+"')";
			statement.executeUpdate(sql);
		}
		System.out.println(" Records are inserted into the table...........");
		statement.close();
			}
	catch(SQLException e)
		{
		System.out.println(" The error in this program is :"+e);
		}
	}
	
	
	//This method allows us to see data from the table r_akha_tab	
	public ResultSet getResultSet() throws Exception
	{
		ResultSet rs=null;
		try
		{
			statement=connect.getConnection().createStatement();
			String sql="Select id, income, pep from m_sing_tab order by pep desc";
			rs=statement.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println(" The Error is:"+e);
		}
		return rs;
	}	
	
}
