import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.commons.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class BuildExcel 
{
	public static int TALLY = 0;
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Which folder in the desktop would you like to use? (PNG, CAL, SOCA, etc.)");
		Scanner in = new Scanner(System.in);
		String prefix = in.nextLine();
		System.out.println("- - - - - - - - - - - - - - - - ");
		System.out.println();
		
		//CREATE WORKBOOK
		Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("/Users/James/Desktop/" + prefix + ".xls");
	    
	    //NEW SHEET
	    Sheet sheet1 = wb.createSheet("sheet1");
	    
	    //OPEN FOLDER AND GET LIST OF FILES
	    String directory = "/Users/James/Desktop/" + prefix;
	    File folder = new File(directory);
	    
		// gets you the list of files at this folder
		File[] listOfFiles = folder.listFiles();
		
		//CONVERT FILE NAMES TO STRINGS
		String[] fileNames;
		fileNames = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; ++i)
		{
			fileNames[i] = listOfFiles[i].toString().substring(directory.length());
		}
		
		
		//CYCLE THROUGH
		for(int i=1; i < fileNames.length; i++)
		{
		    //NEW ROW
		    Row row = sheet1.createRow(i);
		    
		    //SKU
		    String SKU = fileNames[i].substring(1, prefix.length()+4);
		    row.createCell(0).setCellValue(SKU);
		    		
		    //POST TITLE
		    String postTitleJPG = fileNames[i].substring(SKU.length()+1).replace("-", " ").replace("_", " ").replace(".", " "); //remove unused characters
		    String postTitle = postTitleJPG.substring(0,postTitleJPG.length() - 4);
		    postTitle = postTitle.toLowerCase(); //set title to lower case
		    postTitle = WordUtils.capitalize(postTitle); //capitalize first letter for all words
		    postTitle = SKU + postTitle;
		    row.createCell(1).setCellValue(postTitle);
		    
		    //SIZE CATEGORY
		    String category = "Custom";
		    
		    if (postTitle.contains("20x5")||postTitle.contains("5x20")){category = "20x5";}
		    if (postTitle.contains("36x6")||postTitle.contains("6x36")){category = "36x6";}
		    if (postTitle.contains("16x24")||postTitle.contains("24x16")){category = "16x24";}
		    if (postTitle.contains("8x14")||postTitle.contains("14x8")){category = "8x14";}
		    if (postTitle.contains("12x18")||postTitle.contains("18x12")){category = "12x18";}
		    if (postTitle.contains("24x36")||postTitle.contains("36x24")){category = "24x36";}
		    if (postTitle.contains("28x6")||postTitle.contains("6x28")){category = "28x6";}
		    if (postTitle.contains("12x12")){category = "12x12";}
		    if (postTitle.contains("Plasma")||postTitle.contains("5x20")){category = "Plasma";}
		    
		    row.createCell(2).setCellValue(category);
		    
		    //TAGS
		    //All of the tags need to be first-letter capitalized because that is how the title is formatted. 
		    List<String> Christmas = Arrays.asList("CAL645", "CAL646", "CAL647", "CAL648", "CAL649", "CAL650", "CAL651", "CAL652", "CAL653", "CAL656", "CAL657", "CAL756", "CAL757", "CAL758", "CAL759", "CAL762", "CAL763", "PNG421", "PNG422", "PNG423", "PNG830", "PNG832", "PNG844", "PNG845", "PNG897", "PNGB410", "PNGB412", "PNGB413", "SOER784", "SOER785", "SOER788");
		    List<String> Beach = Arrays.asList("Beach","Seahorse","Ocean","Sea","Surf","Mermaid","Starfish","Sailing", "Pacific","Atlantic");
		    List<String> Hawaii = Arrays.asList("Oahu","Maui","Kauai","Aloha","Mahalo","Island Time","Hawaii","Kailua","Ohana","Poipu");
		    List<String> California = Arrays.asList("California","Bear","Laguna", "Malibu", "Monterrey","Newport", "Huntington", "Manhattan","Jolla","Diego","Angeles","Cruz","Francisco","Diego","Del Mar","Cardiff", "Pch");
		    List<String> Love = Arrays.asList("Love", "Marriage", "Wife");
		    List<String> Maps = Arrays.asList("Map");
		    List<String> Kids = Arrays.asList("CAL456", "CAL459", "CAL461", "CAL462", "CAL463", "CAL464", "CAL518", "CAL519", "CAL520", "CAL541", "CAL542", "CAL548", "CAL552", "CAL560", "CAL562", "CAL563", "CAL569", "CAL570", "CAL571", "CAL574", "CAL576", "CAL577", "CAL578", "CAL601", "CAL890", "DEL064", "DEL120", "PNG728", "PNG729", "PNG731", "PNG732", "PNG733", "PNG738", "PNG739", "PNG740", "PNG744", "PNG746", "PNG748", "PNG751", "PNGB160", "PNGB365", "SOCA288", "SOCA289", "SOCA290", "SOCA291", "SOCA292", "SOCA293", "SOCA297", "SOCA298", "SOCA299", "SOCA300", "SOCA301", "SOCA302", "SOCA342", "SOCA343", "SOCA358", "SOCA619", "SOCA620");
		    //Part numbers must be UPPERCASE
		    
		    List<List<String>> arrayOfArrays = Arrays.asList(Kids, Maps, Love, California, Hawaii, Beach, Christmas);//Add all tag options to array
		    List<String> listOfOptions = Arrays.asList("Kids","Maps","Love","California","Hawaii","Beach", "Christmas");//MUST BE IDENTICAL to above array
		    ArrayList<String> tagsArray = new ArrayList<String>();
		    
		    for(int t = 0; t < arrayOfArrays.size(); t++)//cycle through arrayOfArrays
		    {
		    	for(int s = 0; s < arrayOfArrays.get(t).size(); s++)//cycle through arrayOfArrays inner arrays
		    	{
		    		if(postTitle.contains(arrayOfArrays.get(t).get(s)))
		    				{
		    					tagsArray.add(listOfOptions.get(t));
		    					break;
		    				}
		    	}
		    }
		    String tags = StringUtils.join(tagsArray, "|"); //need the | separator for WooCommerce
		    row.createCell(3).setCellValue(tags);
		    
		    //FINISHED WITH FILE
		    TALLY++;
		    System.out.println(TALLY + " " + postTitle);
		}
	    
		System.out.println("# OF FILES COMPLETED:" + TALLY);
	    //CLOSE AND SAVE
	    wb.write(fileOut);
	    fileOut.close();
	}
	
}
