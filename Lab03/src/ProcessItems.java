import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author James
 *
 */
public class ProcessItems {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		String inputFile = "src/csvinput.txt";
			
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		ItemListMethods.processList(inputFile, itemList);
		ItemListMethods.printList(itemList);

	}

}
