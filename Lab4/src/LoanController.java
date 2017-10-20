import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class LoanController extends BankRecord
{
	private static long diff,diff1,diff2=0;
	
	//Serializing the persistent object to a file called bankrecords.ser
	
	public static void SerializeObject(persistentObject pO)
	{
		long beginTime,endTime;
		beginTime=System.currentTimeMillis();
	try
	{
	/*
	* Code to serialize or persist the object
	*/
	FileOutputStream fileoutput = new FileOutputStream("bankrecords.ser");
	ObjectOutputStream out=new ObjectOutputStream(fileoutput);
	out.writeObject(pO);
	out.close();
	fileoutput.close();
	}
	catch(Exception e)
	{
		System.out.println(" The Error of the application is"+e);
	}
	
	// Calculation of time required to DeSerialize from bankrecords.ser
	
	endTime=System.currentTimeMillis();
	diff=endTime-beginTime;
	}
	
	//DeSerializing the persistent object from a file called bankrecords.ser
	
	public static persistentObject DeSerializeObject()
	{
	/*
	* Code to deserialize the object
	*/
	long beginTime,endTime;
	beginTime=System.currentTimeMillis();
		persistentObject newBankRecords=null;
		try
		{
	FileInputStream fin = new FileInputStream("bankrecords.ser");
	ObjectInputStream inObject=new ObjectInputStream(fin);
	newBankRecords =( persistentObject )inObject.readObject();
	
	 inObject.close();
	 fin.close();
		}
	catch( Exception e )
	{
		
		System.out.println(" The Error of the application is"+e);
		
	}
// Calculation of time required to DeSerialize from bankrecords.ser
		
		endTime=System.currentTimeMillis();
		diff1=endTime-beginTime;
		return newBankRecords;
	}

//Main program 
	
	public static void main(String args[])
	{
		//Date variable declared 
		Date dt=new Date();		
		//BankRecord Object Created
		BankRecord br=new BankRecord();
		//daoModels object created to execute necessary Sql operations
		daoModels dao=new daoModels();
		br.readData();
		//HashMapper object created to call HashMaped data from bankrecord
		HashMapper bankRecords=new HashMapper();
		Map<String, ArrayList<String>> mr=bankRecords.getBankRecords();
		//Persistent object created encapsulating hashmap and date
		persistentObject pO=new persistentObject(dt,mr);
		//serialization method called
		SerializeObject(pO);
		//DeSerialization method called
		DeSerializeObject();
		diff2=diff1-diff;
		try
		{
			
			System.out.println("Current Date= "+dt+"\n"+" Programmed by Mili Singh"+"\n");
			System.out.println("\t"+"-----Welcome to  Data Analysis Report of IIT Bank------"+"\n"+"\n");
			//Table Created in Database
			dao.createTable();
			System.out.println();
			//Value Inserted in Database from Bank-Detail.csv
			dao.inserts(rObj);
			System.out.println();
			//View the Details in JFrame
			new LoanView();
			//Application is made to sleep for 5 sec which is equal to 5000 millisecods
			Thread.sleep(5000);
			//Serialized Time is displayed
			System.out.println(" The file is serialized from bankrecords.ser in "+diff);
			System.out.println();
			//Deserialized time is displayed
			System.out.println(" The file is Deserialized from bankrecords.ser in "+diff1);
			System.out.println();
			//Difference in Serialization and Deserialization is displayed
			System.out.println(" The file is Serialized and Deserialized from bankrecords.ser in "+diff2);
			System.out.println();
			//Hash Map Size id Declared
			System.out.println(" Final Hash Map size is:"+mr.size()+""+dt);
			System.out.println();
			//Hash Map value is displayed
			System.out.println(" Final Hash Map Values are displayed as is:"+mr);
			
		}
		catch(Exception e)
		{
			System.out.println(" The Error of the application is :"+e);
		}
	}
}

