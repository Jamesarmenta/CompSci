
public class TestPriorityQueue {

	public static void main(String args[])
	{
		PriorityQueue theQ = new PriorityQueue(3);
		
		theQ.enqueue("THIS IS PRIORITY 3, FIRST IN LINE", 3);
		theQ.enqueue("PRIORITY 2, second in line", 2);
		theQ.enqueue("THIS IS PRIORITY 3, THIRD IN LINE", 3);
		//theQ.enqueue("priority 1, fourth in line", 1);
		//theQ.enqueue("priority 1, fifth in line...", 1);
		//theQ.enqueue("PRIORITY 2, last in line", 2);
		
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();

	}
	
	
}
