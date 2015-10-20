public class LinkedList 
{
	public Node head;
	public Node tail;

	// default constructor to create an empty linked list
	public LinkedList()
	{
		head = null;
		tail = null;
	}

	// constructor that takes in a Node that makes the linked list be of size 1 
	public LinkedList(Node n)
	{
		head = n;
		tail = head;
	}
	
	// constructor that takes in a String that gets made into a Node 
	// that makes the linked list be of size 1 
	public LinkedList(String s)
	{
		head = new Node(s);
		tail = head;
	}

	public void printList()
	{
		if(head != null)
		{
			Node temp = this.head;
			
			while (temp != null)
			{
				System.out.println(temp.data);
				temp = temp.next;
			}
		} 
		else
		{
			System.out.println("List is empty");
		}
	}
	
	// works whether or not linkedL is empty
	public void addToBeginning(Node nodeToBeAdded)
	{
		nodeToBeAdded.next = this.head;
		this.head = nodeToBeAdded;
		
		// we are now checking to see if the list was empty prior to use adding the node above
		if (tail == null)
		{
			tail = head;
		}
	}

	public void addToEnd(Node nodeToBeAdded)
	{
		
		if (tail != null)
		{
			// add node to end
			tail.next = nodeToBeAdded;
			// declare tail as end Node
			tail = nodeToBeAdded;
		}
		else
		{
			head = nodeToBeAdded;
			tail = nodeToBeAdded;
		}
	}

	public Node searchForNode(String dataToFind)
	{
		Node temp = head;
		
		while (temp != null && !(temp.data.equals(dataToFind)))
		{
			temp = temp.next;
		}
		
		if(temp != null)
		{} 
		else 
		{System.out.println("Could not find searched node");}
		
		return temp;
	}

	
	public boolean replace(String findStr, String replaceStr)
	{
		Node n = searchForNode(findStr);
		
		if (n != null)
		{
			while (tail.data.equals(n.data))
			{
				tail.data = replaceStr;
			}
			n.data = replaceStr;
			return true;
		}
		
		System.out.println("Could not replace");
		return false;
	}
	
	public boolean delete(String toDeleteStr)
	{
		Node temp = head;
		boolean deleted;
		
		// need to handle empty list
		if (head == null)
		{
			System.out.println("Could not delete");
			deleted = false;
		}
		else
		{
			// if the head contains the thing to delete
			if (head.data.equals(toDeleteStr))
			{
				// we want to delete the head
				head = head.next;
				deleted = true;
			}
			
			// if the tail contains the thing to delete
			if (tail.data.equals(toDeleteStr))
			{
				// we want to delete the tail
				tail = null;
				
				// write code that makes temp become the last Node in the list
				while (temp.next != null)
				{
					temp = temp.next;
				}

				// assign tail to last Node
				tail = temp;
				
				deleted = true;
			}
			else
			{
				// we want to continue down the list as long as we have not
				// gotten to the end of the list and we have not found the 
				// node to delete
				while ((temp.next != null) && !(temp.next.data.equals(toDeleteStr)))
				{
					temp = temp.next;
				}
	
				// we have either temp.next == null OR we have found it at temp.next.data
				if (temp.next == null) // means we didn't find 
				{
					System.out.println("Could not delete");
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
	
	public boolean addBefore(String stringToFind, String stringToAdd)
	{
		Node nodeToAdd = new Node(stringToAdd);
		Node temp = head;
		boolean added;
		
		Node foundNode = searchForNode(stringToFind);
		
		if (foundNode == null)
		{
			System.out.println("Could not addBefore");
			added = false;
			return added;
		}
		if (head.data.equals(foundNode.data))
		{
			added = true;
			//set node to Node after nodeToAdd as current head
			nodeToAdd.next = head;
			// set added Node as head
			head = nodeToAdd;
		}
		else
		{
			while (!(temp.next.equals(foundNode)))
			{
				temp = temp.next;
			}
			
			temp.next = nodeToAdd;
			nodeToAdd.next = foundNode;
			added = true;
			
		}
		return added;
	}
	
	public boolean addAfter(String stringToFind, String stringToAdd)
	{
		Node nodeToAdd = new Node(stringToAdd);
		boolean added;
		
		Node foundNode = searchForNode(stringToFind);
		
		if (foundNode == null)
		{
			System.out.println("Could not addAfter");
			added = false;
		}
		if (tail.data.equals(foundNode.data))
		{
			added = true;
			nodeToAdd.next = foundNode.next;
			foundNode.next = nodeToAdd;
			tail = nodeToAdd;
		}
		else
		{
			added = true;
			nodeToAdd.next = foundNode.next;
			foundNode.next = nodeToAdd;
		}
		
		return added;
	}
	
	public void clear()
	{
		head = null;
		tail = null;
	}
	
}