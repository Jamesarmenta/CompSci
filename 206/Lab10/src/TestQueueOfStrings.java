
public class TestQueueOfStrings {

	public static void main(String[] args) {
		QueueOfStrings theQ = new QueueOfStrings();
		
		theQ.enqueue("the");
		theQ.enqueue("dog");
		theQ.enqueue("runs");
		theQ.enqueue("far");
		
		//theQ.get(0);
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		
		

	}

}
