import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daoModels extends BankRecord
{
	Connector connect=new Connector();
	private Statement statement=null;
	
	// Method to create table m_sing_tab in database
	
	public void createTable() throws Exception
	{
		try
		{
			statement=connect.getConnection().createStatement();
			String sql1=" Drop table if exists m_sing_tab ";
			String sql="CREATE TABLE m_sing_tab"+
			"(pid Integer not NULL AUTO_INCREMENT,"+
			"ID varchar(7),"+
			"INCOME numeric(8,2),"+
			"PEP varchar(3),"+
			"PRIMARY KEY(pid))";
			//Sql statement executed to drop the table if it already exists
			statement.executeUpdate(sql1);
			//Sql statement executed to create table
			statement.executeUpdate(sql);
			System.out.println(" Created Table in Given database.");
			statement.close();
			
		}
			catch(SQLException e)
			{
				System.out.println(" The error is :"+e);
			}
	}
	//Insert method to insert data in table m_sing_tab
	
	public void inserts(BankRecord[] rObj) throws Exception
	{
		try
		{
			statement=connect.getConnection().createStatement();
			String sql=null;
			for(int i=0;i<rObj.length;++i)
			{
			sql="INSERT INTO m_sing_tab(ID,INCOME,PEP)"+
			"VALUES('"+rObj[i].getId()+"','"+rObj[i].getIncome()+"','"+rObj[i].getPep()+"')";
			statement.executeUpdate(sql);
		}
		System.out.println(" Inserted records into the table.......");
		statement.close();
			}
	catch(SQLException e)
		{
		System.out.println(" The error in the program is :"+e);
		}
	}
	
	//method to view the details from the table m_sing_tab
	
	public ResultSet getResultSet() throws Exception
	{
		ResultSet rs=null;
		try
		{
			statement=connect.getConnection().createStatement();
			String sql="Select id,income,pep from m_sing_tab order by pep desc";
			rs=statement.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println(" The Error is:"+e);
		}
		return rs;
	}	
	
}
