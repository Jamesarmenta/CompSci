import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class Competition {

	private double amount;



	/**
	 * A method that proposes questions,
	 * asks for user input,
	 * and assigns value to mouse types
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		//Open Scanner for file input
		Scanner input =  new Scanner(System.in);
		
		DecimalFormat df = new DecimalFormat("####0.00");
		
        System.out.println("How many numbers do you want to enter?");
        int num = input.nextInt();
        int[] candyPieces = new int[num];
        int[] siblings = new int[num];
        System.out.println("Enter the candy pieces and then siblings");
        for (int i = 0 ; i < candyPieces.length; i++ ) 
            {
                candyPieces[i] = input.nextInt();
                siblings[i] = input.nextInt();
            }
        
        System.out.println("results:");
        for (int i = 0 ; i < candyPieces.length; i++ ) 
            {
        	int result = Math.max(0, (candyPieces[i] - (candyPieces[i]%siblings[i]))/siblings[i]);
                System.out.println("You get " + result + " piece(s) and your dad gets " + (candyPieces[i]%siblings[i]) + " piece(s).");
            }
	}


	
    public Competition(double amount) {
    	//Assign variables/characteristics to Person array
    	this.amount = amount;

    }
}