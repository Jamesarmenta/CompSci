/**
 * @author jarmenta
 * @see http://stackoverflow.com/questions/3681242/java-how-to-parse-double-from-regex
 * @see http://stackoverflow.com/questions/6734521/getting-a-double-out-of-a-string
 */

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.io.FileReader;


public class Project4Alt {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * 
	 * A method that scans each line of a bank statement,
	 * takes the transaction type, and keeps a balanced amount
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//Open Scanner for file input
		Scanner input = new Scanner(new File ("src/input.txt"));
		
		//Declare # of lines variable
		int numLines = 0;
		
		//Count number of lines in input.txt
		while (input.hasNextLine()) {
			input.nextLine();
			numLines++;
		}
		
		//Declare array types
		String[] date = new String[numLines];
		String[] account = new String[numLines];
		String[] transaction = new String[numLines];
		double[] amount = new double[numLines];

		int i = 0;
		
		Scanner fileReader = new Scanner(new File ("src/input.txt"));
			//While input has line, print to output
			while (fileReader.hasNext()) {
			
					//Get the date
					date[i] = fileReader.next();
					
					//Get Account type
					account[i] = fileReader.next();
					//Check if two-words
					if(account[i].contains("Credit")){
					account[i] = account[i] + " " + fileReader.next();
					}
					
					//Get Transaction type
					transaction[i] = fileReader.next();
					//Check if two-words
					if(transaction[i].contains("Opening")){
					transaction[i] = transaction[i] + " " + fileReader.next();
					}
					
					//Get Amount
					amount[i] = fileReader.nextDouble();
					
					i++;
					        
				}
			double checking = 0;
			double savings = 0;
			double credit = 0;
			for(i = 0 < date.length; i++;){
				if (account[i].equals""){
					
				}
			}
			
		
		System.out.println((Arrays.toString(date)));
		System.out.println((Arrays.toString(account)));
		System.out.println((Arrays.toString(transaction)));
		System.out.println((Arrays.toString(amount)));
		
		
		input.close();
	}}



