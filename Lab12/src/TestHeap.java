
public class TestHeap {

	public static void main(String[] args)
	{
		Heap theHeap = new Heap();
		
		theHeap.add("First", 1);
		theHeap.add("Second", 2);
		theHeap.add("Third", 3);
		theHeap.add("Fourth", 4);
		theHeap.add("Fifth", 5);
		theHeap.add("Sixth", 6);
		theHeap.add("Seventh", 7);
		theHeap.add("Eighth", 8);
		theHeap.add("Eighth", 9);
		theHeap.add("Eighth", 2);
		
		
		theHeap.remove();
		theHeap.remove();
		
		
		theHeap.print();
		
	}
}
