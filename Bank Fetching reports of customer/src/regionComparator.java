import java.util.Comparator;

public class regionComparator  implements Comparator <BankRecord> {

	//Region Comparator
	
	public int compare(BankRecord o3, BankRecord o4) {
		// TODO Auto-generated method stub
	int result = o3.getRegion().compareTo(o4.getRegion()); 
	return result;
}
}
