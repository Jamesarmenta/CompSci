
import java.io.FileInputStream;
import java.io.IOException;

public class JavaSourceBalance 
{
	public static String source;
	
	public static void main(String args[]) throws IOException
	{
		Stack theStack = new Stack();
		
		//Open Scanner for file input
	    source = args[0];
		//source = "src/input.txt";
		FileInputStream input = new FileInputStream(source);
	      char current;
	      while (input.available() > 0) 
	      {
	        current = (char) input.read();
	       
	        if (current == '{')//if we find open curly brace
	        {
	        	theStack.push(Character.toString(current)); // adds to the end
	        }
	      
	        if (current == '}')
	        {
	        	if (theStack.isEmpty())
	        	{
	        		theStack.push(Character.toString(current));
	        		break;
	        	}
	        	theStack.pop(); //if we find close curly brace, pop from the stack
	        }
	      
	      }
	      
	      if (theStack.isEmpty())//if we have pushed and popped an even amount of times
	      {
	    	  System.out.println("Braces are even!");
	      }
	      else //leftover(s) remain in the stack
	      {
	    	  System.out.println("Nope. Braces are not balanced!");
	      }
		
	}
	
}