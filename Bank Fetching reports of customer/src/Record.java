import java.io.*;
import java.util.*;
import java.text.*;

//Record class extends BankRecord
public class Record extends BankRecord
 {
	private static FileWriter fr=null;//Declaration File Writer
	
	// Constructor Created
	public Record()
	{
		try
		{
			fr=new FileWriter("IITBankDataAnalysis.txt");
		}
		catch (IOException e)
		{
			System.out.println(" The Error is:  "+e);
		}
	}

	public static void main(String[] args) 
	{
		Record r = new Record();
		r.readData();
		femaleComparators();
		maleComparator();
		avgComparator();
		maxminComparator();
		
		try // Exception Handling
		{
			fr.close();	
		}
		catch (IOException e)
		{
			System.out.println(" The Error is:  "+e);
		}
	}		
	
	/*Female Comparators function created for generating number of females with both
	 a mortgage and savings account per location*/
		
	public static void femaleComparators()
	
	{
		Arrays.sort(rObj,new femaleComparators());
		int i;
		int innerCity=0,rural=0,subUrban=0,town=0;
		for(i=0;i<rObj.length;i++)
			
		{
			if((rObj[i].getSex().equals("FEMALE") 
			&& rObj[i].getMortage().equals("YES") 
			&& rObj[i].getSave_acct().equals("YES") 
			&& rObj[i].getRegion().equals("INNER_CITY")))
				
			{
				innerCity=innerCity+1;;
			
			}	
			 else if((rObj[i].getSex().equals("FEMALE")
			&& rObj[i].getMortage().equals("YES")
			&& rObj[i].getSave_acct().equals("YES")
			&& rObj[i].getRegion().equals("RURAL")))
				
			{
				rural=rural+1;
			
			}
			 else if((rObj[i].getSex().equals("FEMALE") 
					&& rObj[i].getMortage().equals("YES") 
					&& rObj[i].getSave_acct().equals("YES") 
					&& rObj[i].getRegion().equals("SUBURBAN")))
				
			{
				subUrban=subUrban+1;
			
			}
			else if((rObj[i].getSex().equals("FEMALE") 
					&& rObj[i].getMortage().equals("YES") 
					&& rObj[i].getSave_acct().equals("YES") 
					&& rObj[i].getRegion().equals("TOWN")))
				
			{
				town=town+1;
			
			}
		
		}
			
		try
		{
			String timeStamp;
			timeStamp=new SimpleDateFormat("YYYY/MM/DD HH:MM:SS").format(Calendar.getInstance().getTime());
			fr.write(String.format("Current Date= "+timeStamp+"\n"+" Programmed by Mili Singh"+"%n"));
			fr.write(String.format("\t"+"-----Welcome to  Data Analysis Report of IIT Bank------"+"%n"+"%n"));
    	    fr.write(String.format("%n"));
			fr.write(String.format("Females with Mortgage and Savings Acct in Inner City Location :" +innerCity+ "%n"));
			fr.write(String.format("Females with Mortgage and Savings Acct in Rural Location : "+ rural+ "%n"));
			fr.write(String.format("Females with Mortgage and Savings Acct in Suburban Location :"+ subUrban+"%n"));
			fr.write(String.format("Females with Mortgage and Savings Acct in Town Location :"+ town +"%n"));
			fr.write(String.format("===================================================="));
			
			
		}
		catch(IOException e)
		{
			System.out.println(" The Error is:  "+e);
		}
		
		
	}
	
	//Male Comparator created for generating number of males with both a car and 1 child per location
	public static void maleComparator()
	{
		Arrays.sort(rObj,new maleComparator());
		int i;
		int innerCityMale=0,ruralMale=0,subUrbanMale=0,townMale=0;
		for(i=0;i<rObj.length;i++)
			
		{
				
			if(rObj[i].getSex().equals("MALE") 
					&& rObj[i].getCar().equals("YES") && rObj[i].getChildren().equals("1")
					&& rObj[i].getRegion().equals("INNER_CITY"))
				
			{
				innerCityMale=innerCityMale+1;
			
			}
			else if(rObj[i].getSex().equals("MALE") 
					&& rObj[i].getCar().equals("YES") 
					&& rObj[i].getChildren().equals("1")
					&& rObj[i].getRegion().equals("RURAL"))
				
			{
				ruralMale=ruralMale+1;
			
			}
			else if(rObj[i].getSex().equals("MALE") 
					&& rObj[i].getCar().equals("YES") 
					&& rObj[i].getChildren().equals("1")
					&& rObj[i].getRegion().equals("SUBURBAN"))
				
			{
				subUrbanMale=subUrbanMale+1;
			
			}
			if(rObj[i].getSex().equals("MALE") 
					&& rObj[i].getCar().equals("YES") 
					&& rObj[i].getChildren().equals("1")
					&& rObj[i].getRegion().equals("TOWN"))
				
			{
				townMale=townMale+1;
			
			}
		}		
				try
		{
			
           
			fr.write(String.format("%nMales with 1 Child and a Car in Inner City Location :"+ innerCityMale +"%n"));
			fr.write(String.format("Males with 1 Child and a Car in Rural Location :"+ ruralMale +"%n"));
			fr.write(String.format("Males with 1 Child and a Car in Suburban Location :"+ subUrbanMale +"%n"));
			fr.write(String.format("Males with 1 Child and a Car in Town Location :"+ townMale +"%n"));
			fr.write(String.format("===================================================="));
			
		}
		catch(IOException e)
		{
			System.out.println(" The Error is:  "+e);
		}
			
	}
	
	//Average Comparators created to calculate average income  per location
	public static void avgComparator()
	{
		Arrays.sort(rObj, new avgComparator());
		
		double avgInnerCity = 0, avgRural=0, avgsubUrban=0, avgTown=0;
		double result=0;
		int innerCity=0,Rural=0, subUrban=0,Town=0;
		for(int i = 0;i<rObj.length;i++)
		{
			if(rObj[i].getRegion().equals("INNER_CITY"))
			{
				avgInnerCity=avgInnerCity+rObj[i].getIncome();
				innerCity++;
			}
			if(rObj[i].getRegion().equals("RURAL"))
			{
				avgRural=avgRural+rObj[i].getIncome();
				Rural++;
			}
			if(rObj[i].getRegion().equals("SUBURBAN"))
			{
				avgsubUrban=avgsubUrban+rObj[i].getIncome();
				subUrban++;
			}
			if(rObj[i].getRegion().equals("TOWN"))
			{
				avgTown=avgTown+rObj[i].getIncome();
				Town++;
			}
			
		}
		avgInnerCity=(avgInnerCity/innerCity);
		avgRural=(avgRural/Rural);
		avgsubUrban=avgsubUrban/subUrban;
		avgTown=avgTown/Town;
		try
		{
			fr.write(String.format("%n"));
			fr.write(String.format("Average Income In Inner city Location is : $%6.2f",avgInnerCity));
			fr.write(String.format("%n"));
			fr.write(String.format("Average Income In Rural Location is : $%6.2f", avgRural , "%n"));
			fr.write(String.format("%n"));
			fr.write(String.format("Average Income In Suburban Location is: $%6.2f", avgsubUrban , "%n"));
			fr.write(String.format("%n"));
			fr.write(String.format("Average Income In Town Location is: $%6.2f", avgTown , "%n"));
			fr.write(String.format("%n%n"));
			fr.write(String.format("===================================================="));

			
			
		}
		catch (IOException e)
		{
		System.out.println(" The Error is:  "+e);

		}
		
	}
	
	//Maxmin comparator created to calculate maximum and minimum income per location
	private static void maxminComparator()
	{
		Arrays.sort(rObj,new regionComparator());
		double inCiMax=0,ruMax=0,subMax=0,tMax =0;
		for(int i=0;i<rObj.length;i++)
		{
			if(rObj[i].getRegion().equals("INNER_CITY") && rObj[i].getIncome() > inCiMax)
			{
				inCiMax=rObj[i].getIncome();
			}
			if(rObj[i].getRegion().equals("RURAL") && rObj[i].getIncome() > ruMax)
			{
				ruMax = rObj[i].getIncome();
			}
			if(rObj[i].getRegion().equals("SUBURBAN") && rObj[i].getIncome() > subMax)
			{
				subMax = rObj[i].getIncome();
			}
			if(rObj[i].getRegion().equals("TOWN") && rObj[i].getIncome() > tMax)
			{
				tMax = rObj[i].getIncome();
			}
		}
		//we need to initialize a starting point hence we assign max value from above to min values//
		double inCiMin= ruMax, ruMin = ruMax, subMin = ruMax, tMin = ruMax;
		for(int i=0;i<rObj.length;i++)
		{
			if(rObj[i].getRegion().equals("INNER_CITY") && rObj[i].getIncome() < inCiMin)
			{
				inCiMin = rObj[i].getIncome();
			}
			if(rObj[i].getRegion().equals("RURAL") && rObj[i].getIncome() < ruMin)
			{
				ruMin = rObj[i].getIncome();
			}
			if(rObj[i].getRegion().equals("SUBURBAN") && rObj[i].getIncome() < subMin)
			{
				subMin = rObj[i].getIncome();
			}
			if(rObj[i].getRegion().equals("TOWN") && rObj[i].getIncome()< tMin)
			{
				tMin= rObj[i].getIncome();
			}
		}	
	try
	{
		fr.write(String.format("%n"+"Maximum Income in Inner city location is : $ " + inCiMax
				+"%n"+"Maximum Income in Rural location is: $ " + ruMax
				+"%n"+"Maximum Income in Suburban location is: $" + subMax
				+"%n"+"Maximum Income in Town location is: $ " + tMax +"\n"));
					fr.write(String.format("%n%n"));
		fr.write(String.format("===================================================="));

		fr.write(String.format("%n"+"%n"+"Minimum Income in Inner city location is : $" + inCiMin
				+"%n"+"Minimum Income in Rural location is: $" + ruMin
				+"%n"+"Minimum Income in Suburban location is: $" + subMin
				+"%n"+"Minimum Income in Town location is: $" + tMin));
	}
	catch (IOException e)
	{
		System.out.println(" The Error is:  "+e);

	}
	
	}
}