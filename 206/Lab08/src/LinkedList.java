public class LinkedList 
{
	public static Node head;

	// default constructor to create an empty linked list
	public LinkedList()
	{
		head = null;
	}

	// constructor that takes in a Node that makes the linked list be of size 1 
	public LinkedList(Node n)
	{
		head = n;
	}
	
	// constructor that takes in a String that gets made into a Node 
	// that makes the linked list be of size 1 
	public LinkedList(int s)
	{
		head = new Node(s);
	}

	public int length()
	{
		return length(head, 0);
	}
	
	private static int length(Node lln, int i)
	{
		if (lln != null)
		{
			i++;
			i = length(lln.next, i);
		}
		
		return i;

	}
	
	public int largest()
	{
		return largest(head, 0);
	}
	
	private static int largest(Node lln, int max)
	{
		if (lln != null)
		{
			if (lln.data > max){
				max = lln.data;
			}
			return max = largest(lln.next, max);
		}
		return max;
		
	}
	
	public int smallest()
	{
		return smallest(head, 999999999);
	}
	
	private static int smallest(Node lln, int min)
	{
		if (lln != null)
		{
			if (lln.data < min){
				min = lln.data;
			}
			return min = smallest(lln.next, min);
		}
		return min;
		
	}
	
	
	// works whether or not linkedL is empty
	public void addToBeginning(Node nodeToBeAdded)
	{
		nodeToBeAdded.next = this.head;
		this.head = nodeToBeAdded;
	}

	public void addToEnd(Node nodeToBeAdded)
	{
		// let's write code assuming linkedL is NOT empty
		Node temp = this.head;
		
		// write code that makes temp become the last Node in the list
		while (temp.next != null)
		{
			temp = temp.next;
		}

		// then add the nodeToBeAdded after temp
		temp.next = nodeToBeAdded;
		
	}
	
}