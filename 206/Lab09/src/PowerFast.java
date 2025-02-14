public class PowerFast {
	
	public static void main(String[] args)
	{
		int n = 6;
		int e = 1;
		
		long startNanoSeconds = System.nanoTime();
		double p = (power(n,e));
		long endNanoSeconds = System.nanoTime();
		System.out.println(p);
		System.out.println("Power:" + (endNanoSeconds - startNanoSeconds)/(double)Math.pow(10, 9) + "seconds.");
		
		System.out.println("");
		
		startNanoSeconds = System.nanoTime();
		double pfast = powerFast(n,e);
		endNanoSeconds = System.nanoTime();
		System.out.println(pfast);
		System.out.println("Power Fast:" + (endNanoSeconds - startNanoSeconds)/(double)Math.pow(10, 9) + "seconds.");
		System.out.println("");

	}
	
	public static double power(int n, int e)
	{
		int ans = 1;
		return power(n, e, ans);
	}
	
	public static double power(int n, int e, double ans)
	{
		boolean negative = false;
		
		if (e < 0)
		{
			e = e*-1;
			negative = true;
		}
		
		if (e == 0) //base case
		{
			return ans;
		}
		else {
			e--;
			ans = n*power(n,e,ans);
		}
		
		if (negative)
		{
			return 1/ans;
		}
		
		return ans;
	}
	
	public static double powerFast(int n, int e)
	{
		int ans = 1;
		return powerFast(n, e, ans);
	}
	
	public static double powerFast(int n, int e, double ans)
	{
		boolean negative = false;
		
		if (e < 0)
		{
			e = e*-1;
			negative = true;
		}
		if (e == 0) //base case
		{
			return ans;
		}
		if (e ==2)
		{
			return n*n;
		}
		else {
			if (e%2 == 0) //if even
			{
				e-=2;
				ans = n*n*powerFast(n,e,ans);
			}
			else //if odd
			{
				e--;
				ans = n*powerFast(n,e,ans);
			}
		}
		
		if (negative)
		{
			return 1/ans;
		}
		
		return ans;
	}
}
