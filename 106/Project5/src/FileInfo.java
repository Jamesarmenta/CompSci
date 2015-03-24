import java.io.*;
import java.util.*;

public class FileInfo {
	public static int numLines = 0;

	/**
	 * A method to return the number of lines in the input file
	 * 
	 * @return int number of rows in text file
	 */
	public static int numLines() throws FileNotFoundException {
		int numLines = 0;
		Scanner fileReader = new Scanner(new File(Project5.inputFile));
		while (fileReader.hasNextLine()) {
			fileReader.nextLine();
			numLines++;
		}
		fileReader.close();
		
		return numLines;
	}
}