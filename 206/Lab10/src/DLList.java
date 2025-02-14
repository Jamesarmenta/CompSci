public class DLList 
{
	private DNode head;
	private DNode tail;
	private String data;

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
	public DLList(String data)
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
	public boolean delete()
	{
		DNode temp = head;
		boolean deleted = false;

		if (head == null)// need to handle empty list
		{
			System.out.println("Could not delete");
			deleted = false;
		}
		else
		{
			head = temp.next;
		}
		return deleted;
	}

}