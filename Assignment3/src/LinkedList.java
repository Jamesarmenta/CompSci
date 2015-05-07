
public class LinkedList 
{
	public Node head;

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

	// works whether or not linkedL is empty
	public void addToBeginning(Node nodeToBeAdded)
	{
		nodeToBeAdded.next = this.head;
		this.head = nodeToBeAdded;
	}

	public void addToEnd(Node nodeToBeAdded)
	{
		Node temp = this.head;
		
		while (temp.next != null)
		{
			temp = temp.next;
		}

		temp.next = nodeToBeAdded;
		
	}
	
	public boolean search(int dataToFind)
	{
		Node temp = head;
		
		while (temp != null)
		{
			if (temp.data == dataToFind)
			{
				return true;
			}
			temp = temp.next;
		}
		
		return false;
	}

	public Node searchForNode(int dataToFind)
	{
		Node temp = head;
		
		while (temp != null && !(temp.data == dataToFind))
		{
			temp = temp.next;
		}
		
		return temp;
		
	}

	
	public boolean replace(int findStr, int replaceStr)
	{
		Node n = searchForNode(findStr);
		
		if (n != null)
		{
			n.data = replaceStr;
			return true;
		}
		
		return false;
	}
	
	public boolean delete(int toDeleteStr)
	{
		Node temp = head;
		boolean deleted;
		
		if (head == null)
		{
			deleted = false;
		}
		else
		{
			// if the head contains the thing to delete
			if (head.data == toDeleteStr)
			{
				// we want to delete the head
				head = head.next;
				deleted = true;
			}
			else
			{
				// we want to continue down the list as long as we have not
				// gotten to the end of the list and we have not found the 
				// node to delete
				while ((temp.next != null) && temp.next.data != toDeleteStr)
				{
					temp = temp.next;
				}
	
				// we have either temp.next == null OR we have found it at temp.next.data
				if (temp.next == null) // means we didn't find 
				{
					deleted = false;
				}
				else
				{
					// 	means we found it at temp.next.data
					temp.next = temp.next.next; 
					deleted = true;
					// sets the next reference of the Node prior to the one we want to delete
					// to be the Node after the one we want to delete
				}
			}
		}
		
		return deleted;
	}
	
	public boolean addAfter(int stringToFind, int stringToAdd)
	{
		Node nodeToAdd = new Node(stringToAdd);
		boolean added;
		
		Node foundNode = searchForNode(stringToFind);
		
		if (foundNode == null)
		{
			added = false;
		}
		else
		{
			added = true;
			nodeToAdd.next = foundNode.next;
			foundNode.next = nodeToAdd;
		}
		
		
		return added;
	}
	
	public int length()
	{
		int numOfElements = 1;
		return length(head, numOfElements);
	}
	
	public int length(Node lln, int counter)
	{
		if (lln == null)
			return 0;
		else
		{
			if (lln.next == null)
				return counter;
			else
			{
				return counter + length(lln.next, counter);
			}
		}
	}
	
	
	
}