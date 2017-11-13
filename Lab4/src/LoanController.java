/* Name: Ruchika Akhand
 * November 8th, 2017
 * LoanController.java File
 * Lab 4
 */

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class LoanController extends BankRecord
{
	private static long diff = 0;
	private static long diff1 = 0;
	private static long diff2 = 0;
	
	//Serializing the persistent object to a file called bankrecords.ser
	
	public static void SerializeObject(persistentObject pO)
	{
		long beginTime;
		long endTime;
		beginTime = System.currentTimeMillis();
	try
	{
	
	//To serialize/persist the object
	FileOutputStream fileoutput = new FileOutputStream("bankrecords.ser");
	ObjectOutputStream out=new ObjectOutputStream(fileoutput);
	out.writeObject(pO);
	out.close();
	fileoutput.close();
	}
	catch(Exception e)
	{
		System.out.println(" There is an error of" + e);
	}
	
	// Calculation of time required to DeSerialize from bankrecords.ser
	
	endTime=System.currentTimeMillis();
	diff=endTime-beginTime;
	}
	
	//DeSerializing the persistent object from a file called bankrecords.ser
	
	public static persistentObject DeSerializeObject()
	{
	
	//Code to deserialize the object
	
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
		
		System.out.println(" There is an error of "+e);
		
	}
// Calculation of time required to DeSerialize from bankrecords.ser
		
		endTime=System.currentTimeMillis();
		diff1=endTime-beginTime;
		return newBankRecords;
	}


	//main method 
	public static void main(String args[])
	{
		//Date variable declared 
		Date dt=new Date();		
		//BankRecord Object Created
		BankRecord br=new BankRecord();
		//daoModels object created to execute necessary SQL operations
		daoModels dao=new daoModels();
		br.readData();
		//HashMapper object created to call HashMaped data from bankrecord
		HashMapper bankRecords=new HashMapper();
		Map<String, ArrayList<String>> mr=bankRecords.getBankRecords();
		//Persistent object created encapsulating hashmap and date
		persistentObject pO=new persistentObject(dt,mr);
		//calling serialization method 
		SerializeObject(pO);
		//DeSerialization method called
		DeSerializeObject();
		diff2=diff1-diff;
		try
		{
			//different values are displayed in this section of code
			System.out.println("Current Date= "+dt+"\n"+" Programmed by student Mili Singh"+"\n");
			System.out.println("\t"+"Welcome to  Data Analysis Report of IIT Bank"+"\n"+"\n");
			System.out.println("--------------------------------------------------------");
			//Table Created in Database
			dao.createTable();
			System.out.println();
			//Value Inserted in Database from Bank-Detail.csv
			dao.inserts(brobj);
			System.out.println();
			//View the Details in JFrame
			new LoanView();
			//Application is made to sleep for 5 sec which is equal to 5000 milliseconds
			Thread.sleep(5000);
			//Serialized Time is displayed
			System.out.println(" The file is serialized from bankrecords.ser in "+diff);
			System.out.println();
			//Deserialized time is displayed
			System.out.println(" The file is deserialized from bankrecords.ser in "+diff1);
			System.out.println();
			//Difference in Serialization and Deserialization is displayed
			System.out.println(" The file is serialized and deserialized from bankrecords.ser in "+ diff2);
			System.out.println();
			System.out.println(" The final hashmap size is: "+mr.size()+""+dt);
			System.out.println();
			System.out.println(" The final hashmap values are displayed as:"+mr);
			
		}
		catch(Exception e)
		{
			System.out.println(" There is an error of :"+e);
		}
	}
}

