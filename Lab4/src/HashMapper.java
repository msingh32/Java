import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class HashMapper 
{
	
	 //Declare HashMap
    static Map<String, ArrayList<String>> mp=new HashMap<String, ArrayList<String>>();
    //Declare Arraylist
     static ArrayList<String> arrVal = new ArrayList<String>();
	 public Map<String,ArrayList<String>>getBankRecords()
	 {
		 String line = "";
	     StringTokenizer st = null;
	     int lineNumber = 0; 
	     int tokenNumber = 0;
	     Date dt=new Date();
		 String token_lhs = null,token_rhs=null;
		 
			        try { 

	               @SuppressWarnings("resource")
	               //BufferedReader Declared to readbank-Details.csv file
				BufferedReader br = new BufferedReader(new FileReader("bank-Detail.csv"));
	              
	                          //read comma separated file line by line
	                           while ((line = br.readLine()) != null) {
	               lineNumber++;
	               
	                  //use comma as token separator
	                st = new StringTokenizer(line, ",");
	                tokenNumber=0;
	                arrVal= new ArrayList<String>();
	                            while (st.hasMoreTokens()) {
	                tokenNumber++;

	                if(tokenNumber==1)
	                		token_lhs=st.nextToken();
	       
	                            token_rhs= st.nextToken();
	                            
	                            arrVal.add(token_rhs);
	                         

	                            }
	                            
	                            mp.put(token_lhs,arrVal);
	                                                          
	                        }
	                    	                    

	}
			        catch (Exception e)
			        {
	               System.out.println("CSV file cannot be read : " + e);
	                }
					return mp;
	        	
	    }
	

	}
