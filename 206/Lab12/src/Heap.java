
public class Heap 
{
	private ItemAndPriority theHeap[];
	public int idxToAddTo; 

	public Heap()
	{
		theHeap = new ItemAndPriority[1000];
		idxToAddTo = 0;
	}

	public void add(String s, int priority)
	{
		ItemAndPriority toAdd = new ItemAndPriority(s, priority);
		add(toAdd);
	}

	private int parentIdx(int childIdx)
	{
		return (childIdx - 1)/2;
	}

	private int leftChildIdx(int parentIdx)
	{
		return parentIdx * 2 + 1;
	}

	private int rightChildIdx(int parentIdx)
	{
		return parentIdx * 2 + 2;
	}

	public void add(ItemAndPriority iap)
	{
		theHeap[idxToAddTo] = iap;
		int idxOfChild = idxToAddTo;

		idxToAddTo++;
		// now we upward reheapify

		// stop when we get to ROOT OR stop after we shouldn't swap (meaning parent was larger than child)
		while ((idxOfChild != 0) && 
				(theHeap[idxOfChild].getPriority() > theHeap[parentIdx(idxOfChild)].getPriority()))
		{
			//swap them
			ItemAndPriority temp = theHeap[idxOfChild];
			theHeap[idxOfChild] = theHeap[parentIdx(idxOfChild)];
			theHeap[parentIdx(idxOfChild)] = temp;

			idxOfChild = parentIdx(idxOfChild); // to move up the tree
		}


	}


	public String remove()
	{
		String toReturn = theHeap[0].getData();
		idxToAddTo--;
		theHeap[0] = theHeap[idxToAddTo]; // put last element in ROOT
		int lastActualElementIdx = idxToAddTo - 1;

		int parentIdx = 0;

		//need to set parentIdx inside the loop so that we can move down the tree

		//downward reheapify
		while (true)
		{
			// stop when we have no children (leaf)
			if (leftChildIdx(parentIdx) > lastActualElementIdx)
			{
				break; // we have no children
			}
			else
			{
				// do we only have one child (on the left)?
				if (rightChildIdx(parentIdx) > lastActualElementIdx)
				{
					if (theHeap[parentIdx].getPriority() < theHeap[leftChildIdx(parentIdx)].getPriority())
					{
						// swap with left child
						ItemAndPriority temp = theHeap[parentIdx];
						theHeap[parentIdx] = theHeap[leftChildIdx(parentIdx)];
						theHeap[leftChildIdx(parentIdx)] = temp;
						parentIdx = leftChildIdx(parentIdx);
					}
					else
					{
						break;
					}
				}
				else
				{
					// find larger child
					int largerChildPriority = 
							Math.max(theHeap[leftChildIdx(parentIdx)].getPriority(),
									theHeap[rightChildIdx(parentIdx)].getPriority());

					if (theHeap[parentIdx].getPriority() < largerChildPriority)
					{
						// swap 
						if (largerChildPriority == theHeap[leftChildIdx(parentIdx)].getPriority())
						{
							// swap with left child
							ItemAndPriority temp = theHeap[parentIdx];
							theHeap[parentIdx] = theHeap[leftChildIdx(parentIdx)];
							theHeap[leftChildIdx(parentIdx)] = temp;
							parentIdx = leftChildIdx(parentIdx);
						}
						else
						{
							// swap with right child
							ItemAndPriority temp = theHeap[parentIdx];
							theHeap[parentIdx] = theHeap[rightChildIdx(parentIdx)];
							theHeap[rightChildIdx(parentIdx)] = temp;
							parentIdx = rightChildIdx(parentIdx);
						}

					}
					else
					{
						// don't swap, we're done
						// children are less than parent
						break;
					}

				}
			}



		}

		return toReturn;
	}
	
	public void print()
	{
		int level=0;
		System.out.println("Level " + level + ": " + theHeap[0].getData() + ", " + theHeap[0].getPriority());

		int currIdx=1;
		while(currIdx < idxToAddTo)
		{
			level = (int)(Math.log10(currIdx+1)/Math.log10(2)); // log base 2 of currIdx
			
			//double d = 1e-10; // 1 * 10 to the -10
			System.out.println("Level " + level + ": " + theHeap[currIdx].getData() + ", " + theHeap[currIdx].getPriority());
			currIdx++;
		}
	}
}