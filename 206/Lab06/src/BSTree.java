public class BSTree 
{
	public BSTNode root;

	// default constructor to create an empty Tree
	public BSTree()
	{
		root = null;
	}

	// constructor that takes in a Node that makes the tree be of size 1 
	public BSTree(BSTNode k)
	{
		root = k;
	}
	
	// constructor that takes in a int that gets made into a Node 
	// that makes the tree be of size 1 
	public BSTree(int k)
	{
		root = new BSTNode(k);
	}
	
	public void findMaximum()
	{
		int max = root.key;
		BSTNode temp = this.root;
		
		while (temp != null)
		{
			if (max < temp.key)//grab max value
			{
				max = temp.key;
			}
			
			temp = temp.right;
		}
		System.out.println("Maximum:");
		System.out.println(max);
	}
	
	public void findMinimum()
	{
		int min = root.key;
		BSTNode temp = this.root;
		
		while (temp != null)
		{
			if (min > temp.key)//grab min value
			{
				min = temp.key;
			}
			
			temp = temp.left;
		}
		System.out.println("Minimum:");
		System.out.println(min);
	}
	
	public boolean insert(int n)
	{
		BSTNode nodeToBeAdded = new BSTNode(n);
		BSTNode temp = this.root;
		boolean inserted = false;
		
		if(root == null) //If no root exists
		{
			root = nodeToBeAdded;
			inserted = true;
		}
		else
		{
			while (!inserted){
				if (nodeToBeAdded.key < temp.key)//if nodeToBeAdded is less than temp, look left
				{
					if (temp.left != null)//if spot is not empty
					{
						temp = temp.left; //Look left
					}
					else
					{
						// if spot is empty, insert nodeToBeAdded
						nodeToBeAdded.parent = temp;
						temp.left = nodeToBeAdded;
						inserted = true;
					}
				}
				else
				{
					if (temp.right != null)//if spot is not empty
					{
						temp = temp.right; //Look right
					}
					else
					{
						// if spot is empty, insert nodeToBeAdded
						nodeToBeAdded.parent = temp;
						temp.right = nodeToBeAdded;
						inserted = true;
					}
				}
			}

		}

		if (inserted == false){System.out.println("Could not insert");}
		return inserted;
	}
	
	
	
	////////////////////////////////////
	
	public void inOrderPrint()
	   {
		inOrderPrint(root);
	   }
	
	private void inOrderPrint(BSTNode stRoot)
	   {
		if (stRoot != null)
	        {
			inOrderPrint(stRoot.left);
			System.out.println(stRoot.key);
			inOrderPrint(stRoot.right);
	        }
	   }
	
	
	
}