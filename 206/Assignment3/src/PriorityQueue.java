
public class PriorityQueue 
{
	private QueueOfInts pQ[];
	private int size;
	private int priorityOfLowestItem;
	
	public PriorityQueue(int numberOfPriorities)
	{
		pQ = new QueueOfInts[numberOfPriorities];
		for (int i=0; i< pQ.length; i++)
		{
			pQ[i] = new QueueOfInts();
		}
		size = 0;
		priorityOfLowestItem = -1;
	}
	
	public void enqueue(int intToAdd, int priority)
	{
		size++;

		pQ[priority].enqueue(intToAdd);
		
		if (priorityOfLowestItem == -1)
		{
			priorityOfLowestItem = priority;
		}
		
		if (priority < priorityOfLowestItem)
		{
			priorityOfLowestItem = priority;
		}
		
	}
	
	public int dequeue()
	{
		if (isEmpty())
		{
			return 0;
		}
		
		int intToReturn;
		
		intToReturn = pQ[priorityOfLowestItem].dequeue();
		size--;
		if (size == 0)
		{
			priorityOfLowestItem = -1;
		}
		else
		{
			for ( ; priorityOfLowestItem < pQ.length; priorityOfLowestItem++)
			{
				if (!pQ[priorityOfLowestItem].isEmpty())
				{
					break;
				}
			}
		}
		
		
		return intToReturn;
	}
	
	public boolean isEmpty()
	{
		
		return size == 0;
	}
}