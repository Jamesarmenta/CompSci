public class DivideConquer {
	public static void main(String[] args) 
	{
		int myNums[] = {1, 3, 5, 7, 11, 1111, 8};
		System.out.println("Original:");
		printList(myNums);
		System.out.println("Odds Before Evens:");
		divide(myNums);
	}

	public static void divide(int list[])
	{
		divide(list, 0, list.length-1);
	}

	// sIdx is the index of the first element of the sublist
	// eIdx is the index of the last element of the sublist
	public static void divide(int list[], int sIdx, int eIdx)
	{
		// base case
		if (eIdx - sIdx == 0) // sublist is length 1
		{
			return;
		}

		int midIdx = (sIdx + eIdx) / 2; // we know that it is integer div.
		divide(list, sIdx, midIdx);
		divide(list, midIdx+1, eIdx);

		conquer(list, sIdx, midIdx, eIdx);
	}

	public static void conquer(int list[], int sIdx, int midIdx, int eIdx)
	{
		int tempList[] = new int[eIdx - sIdx + 1];

		int leftIdx = sIdx;
		int rightIdx = midIdx + 1;
		// i represents the index of where we're putting a value into tempList
		int i=0;
		while (leftIdx <= midIdx && rightIdx <= eIdx)
		{
			if (list[leftIdx] %2 == 0)
			{
				tempList[i] = list[rightIdx];
				rightIdx++;
			}
			else
			{
				tempList[i] = list[leftIdx];
				leftIdx++;
			}
			i++;
		}


		// only one of these two while loop will iterate >0 times

		// copy all the elements still on the left into the temp
		while (leftIdx <= midIdx)
		{
			tempList[i] = list[leftIdx]; 
			i++;
			leftIdx++;
		}

		// copy all the elements still on the right into the temp
		while (rightIdx <= eIdx)
		{
			tempList[i] = list[rightIdx]; 
			i++;
			rightIdx++;
		}

		int listIdx = sIdx;
		// i is good as an index to tempList, but we need something
		// else as the index to list
		for (int j=0; j < tempList.length; j++, listIdx++)
		{
			list[listIdx] = tempList[j];
		}
		
		//print on last go-around
		if(i == list.length)
		{
			printList(list);
		}
	}


	public static void printList(int list[])
	{
		for (int i=0; i< list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}