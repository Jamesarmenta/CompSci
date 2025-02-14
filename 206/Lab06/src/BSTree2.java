
public class BSTree2 
{
	private int tree[];
	private static final int INVALIDKEY = -1; 
	
	public BSTree2()
	{
		tree = new int[1000];
		
		for (int i=0; i<tree.length;i++)
		{
			tree[i] = INVALIDKEY;
		}
	}
	
	private int leftChild(int idx)
	{
		return idx*2 + 1;
	}
	
	private int rightChild(int idx)
	{
		return idx*2 + 2;
	}
	
	public void insert(int k)
	{
		// k is the key we want to insert into the array/tree
		int i = 0;
		
		while (tree[i] != INVALIDKEY)
		{
			// change tempIdx appropriately
			if (k >= tree[i])
			{
				i = rightChild(i);// move right
			}
			else
			{
				i = leftChild(i);// move left
			}
		}
		
		tree[i] = k;
	}

	public void findMinimum()
	{
		int i = 0;
		int min = 0;
		
		while (tree[i] != INVALIDKEY)
		{
			if (tree[i] < tree[min])//grab min value
			{
				min = i;
			}
			i = i*2 + 1;
		}
		System.out.println("Minimum:");
		System.out.println(tree[min]);
	}
	
	public void findMaximum()
	{
		int i = 0;
		int max = 0;
		
		while (tree[i] != INVALIDKEY)
		{
			if (tree[i] > tree[max])//grab max value
			{
				max = i;
			}
			i = i*2 + 2;
		}
		System.out.println("Maximum:");
		System.out.println(tree[max]);
	}
		
	
	public void inOrderPrint()
	{
		inOrderPrint(0);
	}
	
	public void inOrderPrint(int stRootIdx)
	{
		if (tree[stRootIdx] == INVALIDKEY)
		{
		}
		else
		{
			//recursive
			inOrderPrint(leftChild(stRootIdx)); //left
			System.out.println(tree[stRootIdx]);
			inOrderPrint(rightChild(stRootIdx)); //right
		}
		
	}
}