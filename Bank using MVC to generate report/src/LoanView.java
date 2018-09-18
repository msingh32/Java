

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class LoanView extends JFrame
{

	private static final long serialVersionUID = 1L;
	//Object of daoModels created
			daoModels dao = new daoModels();
			
public LoanView()
{
Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                              Vector<String> column = new Vector<String>();
		try {
			ResultSet rs = dao.getResultSet();
			ResultSetMetaData metaData = rs.getMetaData();
		   	 int columns = metaData.getColumnCount();

			 //generating column names from table
	    	  	  String cols = ""; 
	    	 
	    	    	for (int i = 1; i <= columns ; i++) {
	    	    	   cols = metaData.getColumnName(i);
	    	      	   column.add(cols);
	    	    }
	    	    //generating row data from table
	    	    while (rs.next()) {
	    	       Vector<Object> row = new Vector<Object>(columns);
	    	       int i;
	    	       for (i = 1; i <= columns; i++) {
	    	        row.addElement(rs.getObject(i));
	    	       } 
	    	       data.addElement(row);
	    	    }
	    	    rs.close(); 
	    	   
	    	    DefaultTableModel model = new DefaultTableModel(data,column);
	    		
	    	     JTable table = new JTable(model);
	    	    
		        JFrame frame = new JFrame("Loan Details");
	    		frame.setSize(700, 200);
	    		frame.add(new JScrollPane(table));
	            frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
	    		frame.pack();
	    		frame.setVisible(true);
	            		       		
		  } catch (Exception e) {
			
			e.printStackTrace();
		}
}
}
