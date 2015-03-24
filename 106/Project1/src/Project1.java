/**@author James Armenta
 * @see http://stackoverflow.com/questions/18583106/java-assigning-user-input-to-variable-change-counter
 * @see http://bytes.com/topic/java/answers/770759-rounding-up-float-value
 * @see http://www.javaprogrammingforums.com/java-programming-tutorials/297-java-program-format-double-value-2-decimal-places.html
 */

import java.util.*;
import java.text.*;

public class Project1 {

    /*Formatting for currency */
    public static DecimalFormat MONEY = new DecimalFormat("$0.00");
    public static DecimalFormat CENTS = new DecimalFormat(".00");
    public static DecimalFormat PERCENT = new DecimalFormat("00.0%");
	
    public static void main(String[] args){

    	Scanner input =  new Scanner(System.in);

        /* Get total of bill from input*/
        System.out.print("Bill total: $");
        double billTotal = input.nextDouble();

        /* Get tip percentage from input*/
        System.out.print("Tip percentage: %");
        double tipPercent = input.nextDouble();
        double tipPercentDecimal = tipPercent / 100;
        
        /* Multiply total and tip percentage */
        double tipAmount = tipPercentDecimal * billTotal;
        
        /*Add billTotal and tipAmount for totalPayment*/
    	double totalPayment = billTotal + tipAmount;
        
        /*Print formatted tip amount and total payment */
        System.out.println("Tip Amount: " + MONEY.format(tipAmount));
        System.out.println("Total Payment: " + MONEY.format(totalPayment));
        

        double roundedTip = roundingOptions(tipAmount, billTotal, totalPayment);
        
        /*Print rounded tip amount */
        System.out.print("");
        System.out.println("Rounded Tip Amount: " + MONEY.format(roundedTip));
    }
    public static double roundingOptions(double tipAmount, double billTotal, double totalPayment) {
        
        /*Round up to closest dollar from total payment (bill + tip)*/
        double roundedPayment = (double)Math.ceil(totalPayment);
        
        /*Subtract exact total payment from rounded payment to get remainder*/
        double roundedCents = roundedPayment - totalPayment;
        
        /* If exact tip is even, don't offer anything. Else- offer round up option*/
        if( roundedCents == 00 ){
            System.out.print("");
         }else{
             System.out.println("*Round up $" + CENTS.format(roundedCents) + " for a Total Payment of " + MONEY.format(roundedPayment) + " - a tip of " + PERCENT.format(((roundedCents + tipAmount) / billTotal)));
         }
        
        /* Compute roundedTip*/
        double roundedTip = roundedCents + tipAmount;
        
        /*Send variables roundedTip to main method*/
        return roundedTip;
    }
    	
    
    
}