import java.util.Scanner;


public class Balance {

	public static void main(String[] args)
	{
		String braces = "{{}}{";
		StackOfChars theStack = new StackOfChars();

		char[] arr = braces.toCharArray();

		for(int i = 0; i<arr.length; i++)
		{
			if (arr[i] == '{')//if we find open curly brace
			{
				theStack.push(arr[i]+""); // adds to the end
			}

			if (arr[i] == '}')
			{
				if (theStack.isEmpty())
				{
					theStack.push(arr[i]+"");
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


