
public class QueueOfStrings 
{
	public DLList theQ; // enqueue to the end, dequeue from the beginning
	
	public QueueOfStrings()
	{
		theQ = new DLList(); // creates an empty array list 
	}
	
	public void enqueue(String s)
	{	
		DNode d = new DNode(s);
		theQ.addToEnd(d);  // adds to the end
	}

	public boolean dequeue()
	{
		if (isEmpty())
		{
			System.out.println("Cannot dequeue because queue is empty");
			return false;
		}
		else
		{
			System.out.println("Dequeued: " + theQ.get(0).data);
			return theQ.delete(); // remove from the beginning
		}
	}
	
	public boolean isEmpty()
	{
		return theQ.size() == 0;
	}
	
	public void get(int n)
	{
		System.out.println("Got: " + theQ.get(n).data);
	}

}