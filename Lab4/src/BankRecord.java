import java.io.*;
import java.util.*;
import java.text.*;

//BankRecord using the client abstract method and generate the client records from .csv file;

public class BankRecord extends client
{
	
	static BankRecord[] rObj=new BankRecord[600];
	static List<List<String>>array=new ArrayList<List<String>>();
	
	//create instances for variable
	
	private String id,region,sex,married,save_acct,current_act,mortage,pep,car,children;
	private double income;
	private int age;
	
	//Getter and Setter for each instances
	
	public void setCar(String car)
	{
		this.car=car;
	}
	
	public String getCar()
	{
		return car;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return id;
	}
	public void setRegion(String region)
	{
		this.region=region;
	}
	
	public String getRegion()
	{
		return region;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	
	public String getSex()
	{
		return sex;
	}
		public void setMarried(String married)
	{
		this.married=married;
	}
	
	public String getMarried()
	{
		return married;
	}
		public void setSave_acct(String save_acct)
	{
		this.save_acct=save_acct;
	}
	
	public String getSave_acct()
	{
		return save_acct;
	}
		public void setCurrent_act(String current_act)
	{
		this.current_act=current_act;
	}
	
	public String getCurrent_act()
	{
		return current_act;
	}
		public void setMortage(String mortage)
	{
		this.mortage=mortage;
	}
	
	public String getMortage()
	{
		return mortage;
	}
		public void setPep(String pep)
	{
		this.pep=pep;
	}
	
	public String getPep()
	{
		return pep;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setChildren(String children)
	{
		this.children=children;
	}
	
	public String getChildren()
	{
		return children;
	}
		public void setIncome(double income)
	{
		this.income=income;
	}
	
	public double getIncome()
	{
		return income;
	}
	
	/*readData() method reading all the record data from the Bank-detail.csv file in your path 
	into an array*/

public void readData()
      
	{
		String line="";
		//try and catch included while reading a file
		
	try
	{	BufferedReader br=new BufferedReader(new FileReader("bank-Detail.csv"));
	//	String line=br.readLine();
		int i=0;
		while((line=br.readLine())!=null)
		{
			array.add(Arrays.asList(line.split(",")));
			i++;
		}
	}catch(Exception e)
		{
			System.out.println(e);
		}
		
	processData();
	}
	
	/*processData() method takes all the record data from array and add the 
	 data into each of  instance fields via setters*/
	 
	public void processData()
	{
		int i=0;;
	for(List<String> dbData:array)
	{
	rObj[i]=new BankRecord();
	rObj[i].setId(dbData.get(0));
	rObj[i].setAge(Integer.parseInt(dbData.get(1)));
	rObj[i].setSex(dbData.get(2));
	rObj[i].setRegion(dbData.get(3));
	rObj[i].setIncome(Double.parseDouble(dbData.get(4)));
	rObj[i].setMarried(dbData.get(5));
	rObj[i].setChildren(dbData.get(6));
	rObj[i].setCar(dbData.get(7));
	rObj[i].setSave_acct(dbData.get(8));
	rObj[i].setCurrent_act(dbData.get(9));
	rObj[i].setMortage(dbData.get(10));
	rObj[i].setPep(dbData.get(11));	

i++;
	}
//	printData();	
	}
	
	/* printData() method should print the first 25 records to the console via getters.
	  Print records are in the fields:ID, AGE, SEX, REGION, INCOME, and MORTGAGE.*/ 

	void printData()
	{
		String timeStamp;
		timeStamp=new SimpleDateFormat("YYYY/MM/DD HH:MM:SS").format(Calendar.getInstance().getTime());
		System.out.println("Current Date= "+timeStamp+"\n Programmed by Mili Singh");
		System.out.println("\n");
		System.out.println("\t\t\t-----Welcome to IIT Bank Report------\n");
		System.out.println("\tID\t\tAGE\t  SEX\t     REGION\t   INCOME\tMORTAGE");
		for(int j=0;j<25;j++)
		{
			System.out.format("\t%5s,%10s,%10s,\t%10s,\t%10s%10s\n",rObj[j].getId(),rObj[j].getAge(),rObj[j].getSex(),rObj[j].getRegion(),rObj[j].getIncome(),rObj[j].getMortage());
		}
	}
public static void main(String[] args)
	{
	BankRecord bk=new BankRecord();
	bk.readData();
	}
}

