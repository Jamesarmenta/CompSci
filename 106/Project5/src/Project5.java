import java.io.*;
import java.util.*;


/**
 * @author jarmenta
 *
 */
public class Project5 {
	//Define source of input file
	public static String inputFile = "src/input.txt";
	
	/**
	 * A method to initiate the parser and line analysis
	 * which then prints results
	 * @param args
	 */
	public static void main(String[] args)throws FileNotFoundException {
		Parser parser = new Parser();
		//Initiate parser
		parser.lineByLine();
		
		System.out.println("Average Wage Amount Per Year of Schooling:");
		//Initiate analyze class & divide result by number of lines from input file (people)
		System.out.println(parser.analyze()/FileInfo.numLines());
	}

}
