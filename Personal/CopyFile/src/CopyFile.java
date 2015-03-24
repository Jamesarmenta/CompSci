import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class CopyFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		//Open Scanner for file input
		Scanner input = new Scanner(new File ("/Users/James/Desktop/List.txt"));
		
		//While input has line, print to output
		while (input.hasNextLine()) {
					
		String line = input.nextLine();
		
		findName(line);
		}
	}

		public static String findName(String line)
		{
		
		String currentNumber = line;
		
		File folder = new File("/Users/James/Desktop/Design/Clients/SOCA/PNG Numbers/SOCA Numbers/");
		// gets you the list of files at this folder
		File[] listOfFiles = folder.listFiles();
		// loop through each of the files looking for filenames that match
		for(int i = 0; i < listOfFiles.length; i++){
		    String filename = listOfFiles[i].getName();
		    if(filename.startsWith(currentNumber)){
		        System.out.println(filename);
		        duplicateFile(filename);
		    }
		}
		return currentNumber;
	}
	
	public static void duplicateFile(String filename) {
		File sourceFile = new File("/Users/James/Desktop/Design/Clients/SOCA/PNG Numbers/SOCA Numbers/" + filename);

		File destFile = new File(
				"/Users/James/Desktop/OUTPUT/" + filename);

		/* verify whether file exist in source location */
		if (!sourceFile.exists()) {
			System.out.println("Source File Not Found!");
		}

		/* if file not exist then create one */
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
				
				System.out.println("FILE CREATED");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {

			/**
			 * getChannel() returns unique FileChannel object associated a file
			 * output stream.
			 */
			source = new FileInputStream(sourceFile).getChannel();

			destination = new FileOutputStream(destFile).getChannel();

			if (destination != null && source != null) {
				destination.transferFrom(source, 0, source.size());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}