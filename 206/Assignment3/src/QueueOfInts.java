public class QueueOfInts 
{
	
	// put off the problem of wraparound for now
	private int theQ[];
	private int rear; // the index of the place just before the place to enQ to
	private int front; // index of the place from which to deQ
	private int numElements;
	private final int MAXSIZE = 100;
	public QueueOfInts()
	{
		theQ = new int[MAXSIZE];
		rear = -1;
		front = 0;
		numElements = 0;
	}
	
	public void enqueue(int intToAdd)
	{
		theQ[++rear] = intToAdd;
		numElements++;
	}
	

	public int dequeue()
	{
		// we should check to see if empty for b4 processing this
		numElements--;
		return theQ[front++];
	}
	
	public boolean isEmpty()
	{
		return numElements == 0;
	}

	
}