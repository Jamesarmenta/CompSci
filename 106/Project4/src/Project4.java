/**
 * @author jarmenta
 * @see http://stackoverflow.com/questions/3681242/java-how-to-parse-double-from-regex
 * @see http://stackoverflow.com/questions/6734521/getting-a-double-out-of-a-string
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;


public class Project4 {

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
		//Open PrintStream for file output
		PrintStream output = new PrintStream(new File("src/output.txt"));
		
		//Declare account variables
		double checkingAccount = 0;
		double savingsAccount = 0;
		double creditAccount = 0;
		
		//While input has line, print to output
		while (input.hasNextLine()) {
			
			String line = input.nextLine();
			
			//Check for opening balance
			if(line.contains("Opening")){
			    if(line.contains("Checking")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            checkingAccount+= amount;
			            System.out.println(amount);
			        }
			    } if(line.contains("Savings")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            savingsAccount+= amount;
			            System.out.println(amount);
			        }
			    } if(line.contains("Credit")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            creditAccount+= amount;
			            System.out.println(amount);
			        }
			    }
			}
			//Check for withdrawal
			if(line.contains("Withdrawal")){
			    if(line.contains("Checking")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            checkingAccount-= amount;
			            System.out.println(amount);
			        }
			    } if(line.contains("Savings")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            savingsAccount-= amount;
			            System.out.println(amount);
			        }
			    } if(line.contains("Credit")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            creditAccount-= amount;
			            System.out.println(amount);
			        }
			    }
			}
			//Check for deposit
			if(line.contains("Deposit")){
			    if(line.contains("Checking")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            checkingAccount+= amount;
			            System.out.println(amount);
			        }
			    } if(line.contains("Savings")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            savingsAccount+= amount;
			            System.out.println(amount);
			        }
			    } if(line.contains("Credit")){
			    	Matcher m = Pattern.compile("(\\d+\\.\\d+)").matcher(line);
			        while (m.find()) {
			            double amount = Double.parseDouble(m.group(1));
			            creditAccount+= amount;
			            System.out.println(amount);
			        }
			    }
			}
			
		} //Exit while loop
		
		System.out.println("CHECKING ACCOUNT: " + checkingAccount);
		System.out.println("SAVINGS ACCOUNT: " + savingsAccount);
		System.out.println("CREDIT ACCOUNT: " + creditAccount);
		
		output.println("CHECKING ACCOUNT: " + checkingAccount);
		output.println("SAVINGS ACCOUNT: " + savingsAccount);
		output.println("CREDIT ACCOUNT: " + creditAccount);
		
		output.close();
		input.close();
	}
}
