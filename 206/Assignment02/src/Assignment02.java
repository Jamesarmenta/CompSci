import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * This program reads an input txt file with a student name and score
 * on each line. 
 * 
 * @author jarmenta
 *
 */
public class Assignment02 {

	public static String source;
	
	/**
	 * MAIN METHOD
	 * 
	 * Reads input.txt file and creates Doubly Linked List from input
	 * Sends DLList to Menu Question method
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		// Student Scores
		DLList studentList = new DLList();
		
		//Open Scanner for file input
		source = args[0];
		//source = "src/input.txt";
		Scanner input = new Scanner(new File (source));
		
		int i = 0;
		while (input.hasNextLine()) {
			String name = input.next(); //Get first String
			int score = input.nextInt(); //Get first int
			studentList.addToEnd(new DNode(name, score));
			i++;
		}
		
		//Close Scanner
		input.close();
		
		menuQuestion(studentList); {
		}
	}

	/**
	 * MENU
	 * 
	 * Provides user interface via system output
	 * 
	 **/

	private static void menuQuestion(DLList studentList) {
		
		Scanner input =  new Scanner(System.in);
				
        // Criterion
		System.out.println("1 Add a student and a test score to the list of students / scores.");
		System.out.println("2 Find the score for a particular student.");
        System.out.println("3 Find the student with the maximum score");
        System.out.println("4 Find the student with the minimum score.");
        System.out.println("5 Display the students sorted by test score.");
        System.out.println("6 Delete a student.");
        System.out.println("7 Change a score for a particular student.");
        System.out.println("8 Quit + Save");

        int menuAnswer = 0;
        boolean invalid1 = true;
        
        do{
        	System.out.println("Your Answer:");
        	try {
        		//Input from User
        		menuAnswer = input.nextInt();
        		//Re-prompt if not 1-8
        		if(menuAnswer<1 || menuAnswer>8) {
        			System.out.println("Invalid value! Please enter a number from 1 to 8 for your answer.");
        		} else {
        			invalid1 = false;
        		}
            } 
        	//Re-Prompt If Wrong Type
            catch (Exception e)
                   {
     	   System.out.println("Invalid value! Please enter a number from 1 to 8 for your answer.");
                       input.nextLine();   // Flush garbage from the line characters not Int
                   }
        }while(invalid1);
        
        if( menuAnswer == 1 ){addStudent(studentList);}
        if( menuAnswer == 2 ){searchName(studentList);}
        if( menuAnswer == 3 ){System.out.println("Highest Score:"); findHighest(studentList);}
        if( menuAnswer == 4 ){System.out.println("Lowest Score:"); findLowest(studentList);}
        if( menuAnswer == 5 ){System.out.println("Sorted Scores:"); selectionSort(studentList);}
        if( menuAnswer == 6 ){deleteStudent(studentList);}
        if( menuAnswer == 7 ){changeScore(studentList);}
        if( menuAnswer == 8 ){try {
			printListToFile(studentList);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} System.out.println("File saved. Goodbye!"); 
        try {
			printListToFile(studentList);
		} catch (FileNotFoundException e) {
			// IF output file not found
			e.printStackTrace();
		}}

   }
/***ADD STUDENT AND SCORE
 * 
 * Adds new student score to end of DLList
 * 
 * @param studentList
 */
	public static void addStudent(DLList studentList)
	{
		Scanner input =  new Scanner(System.in);
		System.out.println("Input Name:");
		String addName = input.nextLine();
		System.out.println("Input Score:");
		int addScore = input.nextInt();
		
		studentList.addToEnd(new DNode(addName, addScore));
		menuQuestion(studentList);
	}

/***SEARCH STUDENT NAME
 * 
 * Takes system input and searches for name in DLList
 * 
 * @param studentList
 */
	public static void searchName(DLList studentList)
	{
		Scanner input =  new Scanner(System.in);
		System.out.println("Input Name:");
		String desiredName = input.nextLine();
		
		System.out.println("Result:");
		
		boolean found = false;
	    for (int i = 0; i < studentList.size(); i++)
	    {
	    	if ( studentList.get(i).data.name().contains(desiredName) ) //.searchName(desiredName)) == 1 )
	    	{
	    	   System.out.println(studentList.get(i).data.toString()); //found it!
	    	   found = true;
	           break;
	    	}
	    }
	      
	    if (!found)
	    {
	    	System.out.println("Name not found!");
	    }
	    System.out.println();
	    menuQuestion(studentList);
	}
	      
/***DELETE STUDENT NAME
 * 
 * Searches for name in DLList and deletes it
 * 
 * @param studentList
 */
		public static void deleteStudent(DLList studentList)
		{
			Scanner input =  new Scanner(System.in);
			System.out.println("Input Name:");
			String desiredName = input.nextLine();
			
			boolean found = false;
		    for (int i = 0; i < studentList.size(); i++)
		    {
		    	if ( studentList.get(i).data.name().contains(desiredName) ) //.searchName(desiredName)) == 1 )
		    	{
		    	   System.out.println("Deleted:");
		    	   System.out.println(studentList.get(i).data.toString()); //found it!
		    	   studentList.delete(studentList.get(i).data.name());
		    	   found = true;
		           break;
		    	}
		    }
		      
		    if (!found)
		    {
		    	System.out.println("Name not found!");
		    }
		    System.out.println();
		    menuQuestion(studentList);
		}
		      
	
/***FIND HIGHEST SCORE
 * 
 * Loops through DLList, comparing each score element to current max value
 * until all iterations are through
 * 
 * @param studentList
 */
	private static void findHighest(DLList studentList) 
	{
		int max = 0;
		for (int pass = 0; pass < studentList.size(); pass++){
			for (int i = 1; i < studentList.size() - pass; i++){
				if (studentList.get(i).data.compareTo(studentList.get(max).data) > 0){
					max = i;
				}
			}
		}
		System.out.println(studentList.get(max).data.toString());
		System.out.println();
		menuQuestion(studentList);
	}
	
/***FIND LOWEST SCORE
 * 
 * Loops through DLList, comparing each score element to current min value
 * until all iterations are through
 * 
 * @param studentList
 */
	private static void findLowest(DLList studentList) 
	{
		int max = 0;
		for (int pass = 0; pass < studentList.size(); pass++){
			for (int i = 1; i < studentList.size() - pass; i++){
				if (studentList.get(i).data.compareTo(studentList.get(max).data) < 0){
					max = i;
				}
			}
		}
		System.out.println(studentList.get(max).data.toString());
		System.out.println();
		menuQuestion(studentList);
	}
	
/***SELECTION SORT
 * 
 * Sorts DLList by score
 * 
 * @param studentList
 */
	public static void selectionSort(DLList studentList){
		int indexToSwap = studentList.size() - 1;
		for (int pass=0; pass < studentList.size()-1; pass++){
			int max = 0;
			for (int i = 1; i < studentList.size() - pass; i++){
				if (studentList.get(i).data.compareTo(studentList.get(max).data) > 0){
					max = i;
				}
			}
		
			//swapping mechanism
			StudentScore temp = studentList.get(indexToSwap).data;
			studentList.get(indexToSwap).data = studentList.get(max).data;
			studentList.get(max).data = temp;

			indexToSwap--;
		}
		displayList(studentList);
		System.out.println("");
		menuQuestion(studentList);
	}
	
/***CHANGE STUDENT SCORE
 * 
 * Searches for student name and, if found, changes the score via user input.
 * 
 * @param studentList
 */
		public static void changeScore(DLList studentList)
		{
			Scanner input =  new Scanner(System.in);
			System.out.println("Input Name:");
			String desiredName = input.nextLine();
			
			System.out.println("Result:");
			
			boolean found = false;
		    for (int i = 0; i < studentList.size(); i++)
		    {
		    	if ( studentList.get(i).data.name().contains(desiredName) ) //.searchName(desiredName)) == 1 )
		    	{
		    	   System.out.println(studentList.get(i).data.toString()); //found it!
		    	   found = true;
		    	   
		    	   System.out.println("Replace Score With:");
		    	   int replaceScore = input.nextInt();
		    	   
		    	   studentList.get(i).data = new StudentScore(studentList.get(i).data.name() ,replaceScore);
		    	   
		           break;
		    	}
		    }
		      
		    if (!found)
		    {
		    	System.out.println("Name not found!");
		    }
		    System.out.println();
		    menuQuestion(studentList);
		}
	
/***DISPLAY LIST
 * 
 * Prints DLList in order via system output
 * 
 * @param studentList
 */
	public static void displayList(DLList studentList){
		for (int i=0; i<studentList.size(); i++){
			System.out.println(studentList.get(i).data.toString());
		}
	}
	
/***PRINT LIST TO DOCUMENT
 * 
 * Prints DLList to source file, overwriting previous info
 * 
 * @param studentList
 * @throws FileNotFoundException
 */
	public static void printListToFile(DLList studentList) throws FileNotFoundException{
		PrintWriter pw;

		try
		{
			//Open printer
			pw = new PrintWriter(new FileOutputStream(source, false)); //true for append, false for overwrite
			
			for (int i=0; i<studentList.size(); i++){
				pw.println(studentList.get(i).data.toString());
			}
			
			//Close 
			pw.close();
		}
		catch (IOException ioe)
		{
		}
	
	}
}