import java.util.ArrayList;


public class StackOfChars
{
	private ArrayList<String> theStack; 
	
	public StackOfChars()
	{
		theStack = new ArrayList<String>();
	}

	public void push(String s)
	{
		theStack.add(s); // adds to the end
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
	
	public String peek()
	{
		if (isEmpty())
		{
			return null;
		}
		else
		{
			return theStack.get(theStack.size() - 1);
		}
	}

	public boolean isEmpty()
	{
		return theStack.size() == 0;
	}
	
}