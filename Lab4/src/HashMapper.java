
/* Name: Ruchika Akhand
 * November 8th, 2017
 * HashMapper.java File
 * Lab 4
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashMapper {

	// Declaring hashmap here
	static Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	// Declaring Arraylist here
	static ArrayList<String> arrayValue = new ArrayList<String>();

	public Map<String, ArrayList<String>> getBankRecords() {
		String line = "";
		StringTokenizer st = null;
		//declaring variables
		int tokenNum = 0;
		int lineNum = 0;
		Date dt = new Date();
		String token_lhs = null, token_rhs = null;

		try {

			@SuppressWarnings("resource")
			
			// To be able to read bank-Details.csv file
			BufferedReader br = new BufferedReader(new FileReader("bank-Detail.csv"));

			// read each record in csv file
			while ((line = br.readLine()) != null) {
				lineNum++;

				// comma is used as a separator 
				st = new StringTokenizer(line, ",");
				tokenNum = 0;
				arrayValue = new ArrayList<String>();
				
				while (st.hasMoreTokens()) {
					tokenNum++;

					if (tokenNum == 1)
						token_lhs = st.nextToken();

					token_rhs = st.nextToken();

					arrayValue.add(token_rhs);

				}

				map.put(token_lhs, arrayValue);

			}

		} catch (Exception e) {

			System.out.println("The CSV file is not being read due to an error : " + e);
		}

		return map;

	}

}
