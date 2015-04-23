import java.util.ArrayList;


public class Stack 
{
	private ArrayList<Integer> theStack; 
	
	public Stack()
	{
		theStack = new ArrayList<Integer>();
	}

	public boolean isEmpty()
	{
		return theStack.size() == 0;
	}

	public void push(int num)
	{
		theStack.add(num); // adds to the end, obv. alters the stack
	}

	public int pop()
	{
		if (isEmpty())
		{
			return -1;
		}
		else
		{
			return theStack.remove(theStack.size() - 1); // this does alter the Stack
		}
	}

	public int peek()
	{
		return theStack.get(theStack.size() - 1); // doesn't alter the Stack
	}
}