public class UseList {

	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList(new Node("Skidmore"));
		
		list.addToEnd(new Node("Add to end U"));
		list.addToEnd(new Node("Add to end U"));
		list.addToEnd(new Node("Add to end U"));
		list.addToEnd(new Node("Add to end U"));
		list.addToEnd(new Node("Add to end U"));
		
		System.out.println("the length of the list is: " + list.length());


	}

}
