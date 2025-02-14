
public class MergeCode {

	public static void main(String[] args) {
		int list[] = {10, 12, 80, 85, 90, 13, 18, 70, 86, 88};

		merge(list, 0, 4, 7);

		for (int i=0; i<list.length; i++){
			System.out.print(list[i] + " ");
		}
		
		System.out.println();
		//System.out.println("Is it:");
		//System.out.println("100 90 6 15 30 40 45 50 3 9 7");
	}

	public static int[] merge(int list[], int start, int mid, int end)
	{
		int firstPartIdx = start;
		int secondPartIdx = mid+1;
		int firstPartLength = (mid+1)-start;
		int secondPartLength = end-mid;
		int smallestPart;
		
		int[] temp = new int[firstPartLength+secondPartLength]; 

		for (int i=0;i<temp.length; i++)
		{		
			if (firstPartIdx > mid || secondPartIdx > end) //if i has surpassed one of the lengths
			{
				if (firstPartIdx > mid) //if index of firstPart has surpassed length, use only the secondPart
				{
					temp[i] = list[secondPartIdx];
					secondPartIdx++;
				}
				else
				{
					temp[i] = list[firstPartIdx]; //if index of secondPart has surpassed length, use only the firstPart
					firstPartIdx++;
				}
			}
			else
			{

				if (list[firstPartIdx] < list[secondPartIdx]) //compare first part element with second part element & assign smaller int
				{
					temp[i] = list[firstPartIdx];
					firstPartIdx++;
				}
				else
				{
					temp[i] = list[secondPartIdx];
					secondPartIdx++;
				}
			}
		}
		
		for (int i=start, tempIdx = 0; i<temp.length+start; i++, tempIdx++) //merge two arrays
		{
			list[i] = temp[tempIdx];
		}

		return list;
	}
}
