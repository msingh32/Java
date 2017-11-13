/* Name: Ruchika Akhand
 * November 8th, 2017
 * persistentObject.java File
 * Lab 4
 */

import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")

/*Encapsulating  java.util.Date object and the Hashmap object from HashMapper 
 * into a serializable class called persistentObject
 */
public class persistentObject implements Serializable
{
	private Map<String,ArrayList<String>> me=new HashMap<String,ArrayList<String>>();
	private java.util.Date date;
	
	public persistentObject(java.util.Date dt, Map<String, ArrayList<String>> mr) {
		
		this.setDate(dt);
		this.setBankRecord(mr);
	}
	public Map<String,ArrayList<String>>getBankRecords()
	{
		return me;
	}
	public void setBankRecord(Map<String,ArrayList<String>> BankRecord)
	{
		this.me=BankRecord;
	}
	public Date getDate()
	{
		return (Date) date;
	}
	public void setDate(java.util.Date dt)
	{
		this.date=dt;
	}
	
}
