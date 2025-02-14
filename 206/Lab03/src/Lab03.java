/**
 * 
 */

/**
 * @author jarmenta
 *
 */
public class Lab03 {

	static int startIdx;
	static int endIdx;
	
	/**
	 * 
	 * This method takes an array and sends it to maxCSSum() to determine
	 * the subsequence with the largest sum + displaySequence() to print out
	 * the results
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = {-5, -1, 4, 2, 1, -3, -10, 6, -1, 3};
		int maxCSSum;
		maxCSSum = maxCSS1(nums);
		System.out.println("The maximum sum of a continuous subsequence is " + maxCSSum);
		displaySequence(nums,startIdx,endIdx);
	}
	
	public static int maxCSS3(int list[])
	{	
		int resetIdx = 0;
		int maxSum = 0;
		int currSum = 0;
		
		for (int ci=0;  ci<list.length; ci++)
		{
			currSum += list[ci];
		
			//Check if the currSum is best yet
			if (currSum >= maxSum){
				maxSum = currSum;
				endIdx = ci;
			}
			
			//If current sum is less than 0, reset
			if (currSum <= 0){
				currSum = 0;
				resetIdx = ci;
			}
			
			//If resetIdx is before endIdx, give StartIdx its value
			if (resetIdx < endIdx){
				startIdx = resetIdx+1;
			}
			
		}
		return maxSum;
	}
	
	// a bit better than brute-force way
		public static int maxCSS2(int list[])
		{
			int maxSum = 0;
			
			for (int si=0; si < list.length; si++)
			{
				int currSum = 0;
				for (int ei=si; ei < list.length; ei++)
				{
					currSum += list[ei]; // currSum = currSum + list[i];
					
					if (currSum > maxSum)
					{
						maxSum = currSum;
						startIdx = si;
						endIdx = ei;
					}
				}
				
			}
			
			return maxSum;
		}

		
		// brute-force look at EVERY subsequence
		public static int maxCSS1(int list[])
		{
			int maxSum = 0;
			
			for (int si=0; si < list.length; si++)
			{
				for (int ei=si; ei < list.length; ei++)
				{
					int currSum = 0;
					for (int i=si; i<=ei; i++)
					{
						currSum += list[i]; // currSum = currSum + list[i];
					}
					
					if (currSum > maxSum)
					{
						maxSum = currSum;
						startIdx = si;
						endIdx = ei;
					}
				}
				
			}
			
			
			return maxSum;
		}
		
	
	/**
	 * 
	 * This method prints the given start index and end index of an
	 * array, and every element in-between. Prints empty subsequence
	 * if start and end are the same element
	 * 
	 * @param list
	 * @param start
	 * @param end
	 */
	public static void displaySequence(int list[], int start, int end)
	{
		System.out.print("Subsequence: ");
		if (startIdx < endIdx)
		{
			System.out.print(list[start] + ", ");
		
			int between = start+1; //number for elements between start & end
		
			while (start < end && between < end){
				System.out.print(list[between] + ", ");
				between++;
			}
			System.out.println(list[end]);
		} 
		else 
		{
			System.out.println("Empty Subsequence");
		}
	}
}
