import java.util.ArrayList;


public class Stack 
{
	private ArrayList<String> theStack; 
	
	public Stack()
	{
		theStack = new ArrayList<String>();
	}

	public void push(String color)
	{
		theStack.add(color); // adds to the end
	}

	public String pop()
	{
		if (isEmpty())
		{
			return null;
		}
		else
		{
			return theStack.remove(theStack.size() - 1);
		}
	}

	public boolean isEmpty()
	{
		return theStack.size() == 0;
	}
	
}