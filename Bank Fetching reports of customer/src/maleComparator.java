import java.util.*;

public class maleComparator implements Comparator <BankRecord> {

	//Male Comparator
	
	public int compare(BankRecord o1, BankRecord o2) {
		// TODO Auto-generated method stub
		//first sort
		int result=o1.getSex().compareTo(o2.getSex()); 
				
					return result;
				
			}
	

}
