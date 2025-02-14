import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab4 {

	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line, text="";
		
		//Array for words
		String[] wordArray = new String[12];
		int arrayIndex = 0;

		while(true)
		{
			line = br.readLine();
			text = text + line;
			if (line == null) 
			{
				break;
			}
		}
		
		for(int i = 0; i < text.length() + 2; i++)
		{
			String pattern = "([A-Za-z']+)";
			// Create a Pattern object
			Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			Matcher m = r.matcher(text);
			if (m.find( )) 
			{
				System.out.println("Found value: " + m.group(1));//Found a word
				wordArray[arrayIndex] = m.group(1);//Add word to arrray
				arrayIndex++;//Next index next time

				text = text.substring(m.end(), text.length());
			}
		}
		System.out.println("");
		System.out.println("Array of words:");
		System.out.println(Arrays.toString(wordArray));//prints null. Could be optimized with ArrayList, but not specified in instructions

	}
}
