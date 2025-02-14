
public class PriorityQueue {
	
	private Heap theHeap = new Heap();
	
	public PriorityQueue()
	{
		Heap theHeap = new Heap();
	}
	
	public void enqueue(String s, int p)
	{
		theHeap.add(s, p);
	}
	
	public String dequeue()
	{
		return theHeap.remove();
	}
	
	public boolean isEmpty()
	{
		return theHeap.idxToAddTo==0; //empty if the index to add to is 0
	}
	
	public void printByLevels()
	{
		theHeap.print();
	}

}
