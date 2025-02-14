public class DLList 
{
	private DNode head;
    private DNode tail;

	// default constructor to create an empty linked list
	public DLList()
	{
		head = null;
		tail = null;
	}

	// constructor that takes in a Node that makes the linked list be of size 1 
	public DLList(DNode n)
	{
		head = n;
		tail = head;
	}
	
	// constructor that takes in a int that gets made into a Node 
	// that makes the linked list be of size 1 
	public DLList(int n)
	{
		head = new DNode(n);
		tail = head;
	}

	public void printList()
	{
		if(head != null)
		{
			DNode temp = this.head;
			
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
	
	public void printListBackwards()
	{
		if(tail != null)
		{
			DNode temp = this.tail;
			
			while (temp != null)
			{
				System.out.println(temp.data);
				temp = temp.prev;
			}
		} 
		else
		{
			System.out.println("List is empty");
		}
	}
	
	// works whether or not linkedL is empty
	public void addToBeginning(DNode nodeToBeAdded)
	{
		if (head !=null)
		{
			if (head.next == null)
			{
				nodeToBeAdded.next = head;
				head.prev = nodeToBeAdded;
				tail = head;
				head = nodeToBeAdded;
			}
			else{
				nodeToBeAdded.next = head;
				head.prev = nodeToBeAdded;
				head = nodeToBeAdded;
			}
		}
		else
		{
			head = nodeToBeAdded;
		}
		
		// we are now checking to see if the list was empty prior to use adding the node above
		if (tail == null)
		{
			tail = head;
		}
	}

	public void addToEnd(DNode nodeToBeAdded)
	{
		
		if (tail != null)
		{
			// add node to end
			tail.next = nodeToBeAdded;
			// declare tail as end Node
			nodeToBeAdded.prev = tail;
			tail = nodeToBeAdded;
		}
		else
		{
			head = nodeToBeAdded;
			tail = nodeToBeAdded;
		}
	}

	public DNode searchForNode(int dataToFind)
	{
		DNode temp = head;
		
		while (temp != null && !(temp.data == dataToFind))
		{
			temp = temp.next;
		}
		
		if(temp == null)
		{
			System.out.println("Could not find searched node");
		}
		
		return temp;
	}

	
	public boolean replace(int findStr, int replaceInt)
	{
		DNode n = searchForNode(findStr);
		
		if (n != null)
		{
			if(tail.data == n.data)
			{
				tail.data = replaceInt;
			}
			else
			{
				n.data = replaceInt;
			}
			return true;
		}
		else
		{
			System.out.println("Could not replace");
			return false;
		}
	}
	
	public boolean delete(int toDeleteInt)
	{
		DNode temp = head;
		DNode prevtemp;
		boolean deleted = false;

		if (head == null)// need to handle empty list
		{
			System.out.println("Could not delete");
			deleted = false;
		}
		else
		{
			if (head.data == toDeleteInt)// if the head contains the thing to delete
			{
				// we want to delete the head
				head = head.next;
				head.prev = null;
				deleted = true;
			}
			
			if (tail.data == toDeleteInt)// if the tail contains the thing to delete
			{
				tail = tail.prev;// assign tail to second to last
				tail.next = null;
				deleted = true;
			}
			if (deleted != true)
			{
				while ((temp.next != null) && !(temp.next.data == toDeleteInt))
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
					prevtemp = temp;
					temp.next = temp.next.next; 
					temp = temp.next;
					temp.prev = prevtemp;
					deleted = true;
					// sets the next reference of the Node prior to the one we want to delete
					// to be the Node after the one we want to delete
				}
			}
		}
		return deleted;
	}

		
	
	public boolean addBefore(int intToFind, int intToAdd)
	{
		DNode nodeToAdd = new DNode(intToAdd);
		DNode temp = head;
		boolean added;
		
		DNode foundNode = searchForNode(intToFind);
		
		if (foundNode == null) //No, could not find in search
		{
			System.out.println("Could not addBefore");
			added = false;
			return added;
		}
		if (head.data == foundNode.data) // Yes, did find in search in head position
		{
			added = true;
			//set node to Node after nodeToAdd as current head
			head.prev = nodeToAdd;
			nodeToAdd.next = head;
			// set added Node as head
			head = nodeToAdd;
		}
		else
		{
			while (!(temp.next.equals(foundNode)))// Yes, did find in search
			{
				temp = temp.next;
			}
			
			temp.next = nodeToAdd;
			nodeToAdd.next = foundNode;
			foundNode.prev = nodeToAdd;
			nodeToAdd.prev = temp;
			added = true;
			
		}
		return added;
	}
	
	public boolean addAfter(int intToFind, int intToAdd)
	{
		DNode nodeToAdd = new DNode(intToAdd);
		DNode prevtemp;
		boolean added;
		
		DNode foundNode = searchForNode(intToFind);
		
		if (foundNode == null)
		{
			System.out.println("Could not addAfter");
			added = false;
			return added;
		}
		if (tail.data == foundNode.data)// If found in tail
		{
			added = true;
			nodeToAdd.prev = tail;
			tail.next = nodeToAdd;
			tail = nodeToAdd;
		}
		else
		{
			added = true;
			nodeToAdd.next = foundNode.next;
			prevtemp = foundNode.next;
			foundNode.next = nodeToAdd;
			nodeToAdd.prev = foundNode;
			prevtemp.prev = nodeToAdd;
		}
		
		return added;
	}
	
	public void clear()
	{
		head = null;
		tail = null;
	}
	
}