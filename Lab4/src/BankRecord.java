
import java.io.*;
import java.util.*;
import java.text.*;

//BankRecord using the client abstract method and generate the client records from .csv file;
public class BankRecord extends client {
	
	//creating bankrecord object here 
	static BankRecord[] brobj=new BankRecord[600];
	static List<List<String>>array=new ArrayList<List<String>>();
	
	//declaring variables
	private String Id; 
	private String Region; 
	private String sex;
	private String Married;
	private String Saveact; 
	private String Currentact;
	private String Mortgage;
	private String Pep;
	private String Car;
	private String Children;
	private double Income;
	private int Age;
	
	//Getter and Setter for each instances
	
	public void setCar(String car)
	{
		this.Car=car;
	}
	
	public String getCar()
	{
		return Car;
	}
	public void setId(String id)
	{
		this.Id=id;
	}
	
	public String getId()
	{
		return Id;
	}
	public void setRegion(String region)
	{
		this.Region=region;
	}
	
	public String getRegion()
	{
		return Region;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public String getSex()
	{
		return sex;
	}
		public void setMarried(String married)
	{
		this.Married=married;
	}
	
	public String getMarried()
	{
		return Married;
	}
		public void setSave_acct(String save_acct)
	{
		this.Saveact=save_acct;
	}
	
	public String getSave_acct()
	{
		return Saveact;
	}
		public void setCurrent_act(String current_act)
	{
		this.Currentact=current_act;
	}
	
	public String getCurrent_act()
	{
		return Currentact;
	}
		public void setMortgage(String mortgage)
	{
		this.Mortgage=mortgage;
	}
	
	public String getMortgage()
	{
		return Mortgage;
	}
		public void setPep(String pep)
	{
		this.Pep=pep;
	}
	
	public String getPep()
	{
		return Pep;
	}
	public void setAge(int age)
	{
		this.Age = age;
	}
	
	public int getAge()
	{
		return Age;
	}
	
	public void setChildren(String children)
	{
		this.Children = children;
	}
	
	public String getChildren()
	{
		return Children;
	}
		public void setIncome(double income)
	{
		this.Income = income;
	}
	
	public double getIncome()
	{
		return Income;
	}
	
	
	//method reads in the data from the csv file into an arraylist 
	public void readData()

	{
		String line="";
		//try and catch included while reading a file
		
	try {	
		//initialize reader object 
		BufferedReader br=new BufferedReader(new FileReader("bank-Detail.csv"));
	
		int i = 0;
		//read each record in csv file
		while((line=br.readLine())!=null)
		{
			//parse each record in csv file by a comma
			//into a list stored in the arraylist -> Arrays
			array.add(Arrays.asList(line.split(",")));
			i++;
		}
	}catch(Exception e)
		{
			System.out.println(e);
		}
	
	//call this function for processing record data 
	processData();
	}
	
	 
	public void processData() {
	int i = 0;
	
	for(List<String> dbData:array)
	{
			//initialize array of object bank record as object 
			brobj[i]=new BankRecord();
			//call setters and get data
			brobj[i].setId(dbData.get(0));
			brobj[i].setAge(Integer.parseInt(dbData.get(1)));
			brobj[i].setSex(dbData.get(2));
			brobj[i].setRegion(dbData.get(3));
			brobj[i].setIncome(Double.parseDouble(dbData.get(4)));
			brobj[i].setMarried(dbData.get(5));
			brobj[i].setChildren(dbData.get(6));
			brobj[i].setCar(dbData.get(7));
			brobj[i].setSave_acct(dbData.get(8));
			brobj[i].setCurrent_act(dbData.get(9));
			brobj[i].setMortgage(dbData.get(10));
			brobj[i].setPep(dbData.get(11));	

			i++;
	}
	
	}
	
	//Method to print the first 25 records for various fields via my getters 
	void printData()
	{
		String timeStamp;
		//code given to us to display the time/date when program is executed 
		timeStamp=new SimpleDateFormat("YYYY/MM/DD HH:MM:SS").format(Calendar.getInstance().getTime());
		System.out.println("Current Date= "+timeStamp+"\n Programmed by student Ruchika Akhand");
		System.out.println("\n");
		System.out.println("\t\tIIT Bank’s Data Analysis Results!");
		System.out.println("----------------------------------------------");
		System.out.println("\tID\t\tAGE\t  SEX\t         REGION\t       INCOME\t       \t MORTGAGE");
		for(int i = 0; i < 25; i++)
		{
			//formatting/printing the values 
			System.out.format("\t%5s%10s%10s\t%10s\t%10s%10s\n",brobj[i].getId(),brobj[i].getAge(),
					brobj[i].getSex(),brobj[i].getRegion(),
					brobj[i].getIncome(),
					brobj[i].getMortgage());
		}
	}
}

