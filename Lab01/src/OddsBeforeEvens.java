import java.util.*;

/**
 * @author jarmenta
 *
 */
public class OddsBeforeEvens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int list[] = {5, 6, 3, 1, 10, 7, 8, 11, 201, 198, 43};

		System.out.println("Original list:");
		printArray(list);

		moveOddsBeforeEvens(list);

		System.out.println("\nOdds before evens list:");
		printArray(list);

	}
	
	public static void moveOddsBeforeEvens(  int list[] )
	{   
	      for ( int pass = 1; pass < list.length; pass++ )
	      {
	           for ( int i = 0; i < (list.length - pass); i++ )
	           {
	                if ( list[i] % 2 == 0)  
	                {     
	                      swap( list, i, i + 1 );
	                } // end if
	           } // end inner for loop (i)
	      }  // end outer for loop (pass)
	} // end method bubbleSort

	public static void swap( int nums[], int first, int second )
	{
	    int hold;
	    hold           = nums[ first ];
	    nums[ first ]  = nums[ second ];
	    nums[ second ] = hold;
	}

	
	public static void printArray(int list[]){
		
		for (int i = 0; i < list.length; i++)
		System.out.print(list[i] + " ");

	}

}
