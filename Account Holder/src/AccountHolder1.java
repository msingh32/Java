public class AccountHolder1 
{
	 public double balance = 0;
	 public static double annualInterestRate=0.04; 
	 
	/* Here the constructor is initialized which
	sets the balance equal to initial balance*/
	public AccountHolder1(double b)
	 {
		    
		   double balance=0;
		   balance=b+balance;
		   System.out.println(" The New Balance of the Customer is "+balance);
		    
	 	 
	 }
	/* This method makes a deposit into the account.
    @param amount The amount to add to the balance field.*/
	 public void Deposit(double a)
	 {
		    	balance=a;
		    	System.out.println(" The New Balance of the account is"+balance);
		 
	 }
/*	 WithDrawl method withdraws an amount from the account's balance.
@param amount The amount to subtract from balance field*/
	 public void withDrawl(double a)
	 {
	 	double with=0;
		 if(balance<100) 
		 {
		 
			 System.out.println(" You cannot withdraw as the balance is "+balance+" which is less than 100");
		 }
		else{
				balance=balance-with;
			 if(balance<500)
			 {
			System.out.println(" You will be charged $50 as transaction fee because your account balance is below 500");
		 balance-=50;
			 }
		   }	
	 }
	/* method for monthly interest*/
	 public void monthlyInterest()
	 {
		 balance=balance+(balance*(annualInterestRate/12.0));
		 System.out.println(" The new balance of the customer as per revise arte is"+ balance);
	 }
	 /*/**
The modifyMonthlyInterest method updates rate of interest
into the account balance.
@param rateUpdate The rateUpdate sets value of
annualInterestRate.*/
	 public void modifyMonthlyInterestRate( double rateUpdater)
	 {
		 annualInterestRate=rateUpdater/100.00;
	 }
	 /*The toString method is used for string representation of an object*/
	 public String tostring()
	 {
		 String r=String.format("$%.2f",balance);
		 return r;
	 }
	 public void display()
	 {
		 System.out.println(" The balance is "+ balance);
	 }
	
}

