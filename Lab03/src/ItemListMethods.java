import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class ItemListMethods {

	public static void processList(String inputFile, ArrayList<Item> itemList) throws FileNotFoundException
	{	
		 try 
		 {
			//Open Scanner for file input
			 BufferedReader input = new BufferedReader(new FileReader(inputFile));
			 String line;
			 
			 while (((line) = input.readLine()) != null) //while input has next line, add elements
			 {
				 StringTokenizer stringTokenizer = new StringTokenizer(line, ","); //split line based on commas
				 
				 String item = stringTokenizer.nextElement().toString();
				 double price = Double.parseDouble(stringTokenizer.nextElement().toString());
				 int quantity = Integer.parseInt(stringTokenizer.nextElement().toString());
				 
				 itemList.add( new Item(item, price, quantity)); //create new itemList arrayList elements based on line processed
			 }
			 input.close();
		 }catch (IOException e) 
		 {
			 System.out.println("File Read Error");
		 }
		 
	}
	
	public static void printList(ArrayList<Item> itemList)
	{
		for (int i=0; i<itemList.size(); i++)
		{
			System.out.println(itemList.get(i).toString());
		}
	}

}
	

