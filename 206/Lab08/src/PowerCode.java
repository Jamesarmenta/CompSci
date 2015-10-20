public class PowerCode {
	public static void main(String[] args)
	{
		System.out.println(power(20,-4));
	}
	
	public static int power(int n, int e)
	{
		int ans = 1;
		return power(n, e, ans);
	}
	
	public static int power(int n, int e, int ans)
	{
		if (e < 1) //base case
		{
			return ans;
		}
		else {
			e--;
			ans = n*power(n,e,ans);
		}
		
		return ans;
	}
}
