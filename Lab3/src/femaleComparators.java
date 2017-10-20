import java.util.*;


public class femaleComparators implements Comparator <BankRecord> {

	//Female Comparator
	public int compare(BankRecord o1, BankRecord o2) {
	
		return o1.getSex().compareTo(o2.getSex());
				
			}}
