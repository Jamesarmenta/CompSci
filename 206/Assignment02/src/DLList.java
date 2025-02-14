public class DLList 
{
	private DNode head;
    private DNode tail;
    private StudentScore data;

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
	public DLList(StudentScore data)
	{
		head = new DNode(data);
		tail = head;
	}

	/**
	 * ADD TO END
	 * 
	 * Adds node to end of DLList
	 * 
	 * @param nodeToBeAdded
	 */
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
	
	/**
	 * SIZE
	 * 
	 * Loops through DLList until Node = null
	 * Returns size of list
	 * 
	 * @return size 
	 */
	
	public int size()
	{
		int size = 0;
		DNode temp = head;
		
		while (temp != null)
		{
			temp = temp.next;
			size++;
		}
		
		return size;
	}

	
	/**
	 * GET
	 * 
	 * Iterates through DLList until specified index has been reached
	 * 
	 * @param idxToFind
	 * @return DNode
	 */
	public DNode get(int idxToFind)
	{
		DNode temp = head;
		
		for (int i = 0; i < idxToFind; i++)
		{
			temp = temp.next;
		}
		
		return temp;
	}
	
	
	/**
	 * DELETE
	 * 
	 * Searches for and deletes DNode containing sought-after String
	 * 
	 * @param toDeleteStr
	 * @return
	 */
	public boolean delete(String toDeleteStr)
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
			if (head.data.name() == toDeleteStr)// if the head contains the thing to delete
			{
				// we want to delete the head
				head = head.next;
				head.prev = null;
				deleted = true;
			}
			
			if (tail.data.name() == toDeleteStr)// if the tail contains the thing to delete
			{
				tail = tail.prev;// assign tail to second to last
				tail.next = null;
				deleted = true;
			}
			if (deleted != true)
			{
				while ((temp.next != null) && !(temp.next.data.name() == toDeleteStr))
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
	
}