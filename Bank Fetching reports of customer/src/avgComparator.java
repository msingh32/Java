import java.util.Comparator;

	public class avgComparator implements Comparator <BankRecord> {

		//Average comparator 
		
		public int compare(BankRecord o5, BankRecord o6) {
			// TODO Auto-generated method stub
			int result=o5.getRegion().compareTo(o6.getRegion());
			if(result!=0)
			{
				return result;
			}
			return Double.compare(o5.getIncome(),o6.getIncome());
			
		}

}

