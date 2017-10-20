import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.lang.Exception;
/**
This program simulates a bank account program and
It takes the initial Balance from the user perspective and passes it to
AccountHolder Constructor
in AccountHolder class to initialize different variables
*/
 public class AccountHolderTest 
 
{

public static void main(String[] args)throws Exception
	{
		//Declaration of Variables
		int num=0,rep=0;
double balance=0,bal=0,with=0;
String strBalance="";

		/*program output to display the current date and time and your
name at the beginning of the output of your program*/
String tm=new SimpleDateFormat("YYYY/MM/DD HH:MM:SS").format(Calendar.getInstance().getTime());
   System.out.println("\n-----Welcome to IIT Bank Account------\n");
System.out.println("Enter the Initial Balance ");
// Creation of a Scanner object to read input.
 Scanner scan=new Scanner(System.in);
   balance=scan.nextDouble();
   AccountHolder1 acc=new AccountHolder1(balance); 	
    
	 
	 	while(true)
    	{
    	try
    	{
    	System.out.println("------------------------");
        System.out.println("Select a Transaction by typing number");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("------------------------");
         num= scan.nextInt();
        switch(num)
        {
        case 1:
        
       	System.out.println("------------------------");
        System.out.println("Select a Transaction by typing number");
        System.out.println("1. CheckBalance");
        System.out.println("2. Deposit the Amount");
        System.out.println("3. Withdraw the Amount");
        System.out.println("4 .Monthly Interest");
        System.out.println("5. Modify Monthly Interest");
        System.out.println("6. Exit");
        System.out.println("-------------------------");
         rep= scan.nextInt();
        
        switch(rep)
        {
        case 1:
       			    System.out.println(" Initial Balance");
					System.out.println("Total balance in your Account is:"+balance);
                     
         break;
        
        case 2:
        double balances=0;
        System.out.println(" Enter the amount to be deposited");
        balances=scan.nextDouble();
		acc.Deposit(balances+balance);        
    	
    	break;
    	
    	case 3:
    	System.out.println("Enter the amount you want to withdraw:");
		balance=scan.nextDouble();
		acc.withDrawl(balance);
	
		 break;
		 
		 case 4:
	 
				System.out.println("Monthly Balance for one year at "+
				(acc.annualInterestRate*100.0) +"% InterestRate");
				System.out.println("Balances");
				System.out.println("Account Balance W. Interest");
				strBalance=acc.tostring();
				System.out.println("Base Amount " + strBalance);
				for (int i=1;i<12;i++)
				{
			//	acc.monthlyInterest();
				strBalance=acc.tostring();
				System.out.println("Month "+i+":"+strBalance);
				}
				System.out.println("Your current Account Balance $:"+strBalance);
					
					 break;
		 case 5:
				System.out.println(" Enter rate of Interest as number");
				double rate=scan.nextDouble();
				if(rate<0 ||rate<1 || rate>100)
				{
				System.out.println("Invalid Number\nTry again:\n");
				}
				else
				{
				acc.modifyMonthlyInterestRate(rate);
				acc.monthlyInterest();
				strBalance=acc.toString();
				System.out.println("Your current Account Balance $:"+strBalance);
				}
				
					 break;
					 
        	
		case 6:
			 {
			 System.out.println(" Successfull exit of the Bank Simulator Application");
			System.exit(0);
			break;
			}
			
		default:

System.out.println("Invalid option, please choose another option");      
break;      
}
case 2:
		 {
		 
		 }
		  		 
}}	catch(Exception e)
{
System.out.println("Something went wrong try again !!");


break;
}

}	 }}		
