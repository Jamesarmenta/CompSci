public class UseList {

	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList(new Node(6000));
		
		list.addToEnd(new Node(5));
		list.addToEnd(new Node(500));
		list.addToEnd(new Node(1000));
		list.addToEnd(new Node(2));
		list.addToEnd(new Node(3));
		
		System.out.println("the smallest of the list is: " + list.smallest());


	}

}
