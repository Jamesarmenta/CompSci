
public class Problem3 {

	public static void main(String[] args)
	{
		System.out.println(meth7(9));
		System.out.println("- - - - ");
		System.out.println(rmeth7(9));
	}
	
	static int meth7(int x)
	{
		int y = 0;
		for (int i=1; i<=x; i++)
		{
			if (i%2 ==1) //if odd
			{
				y += i*5;
			}
			else
			{
				y+=i;
			}
		}
		return y;
	}
	
	static int rmeth7(int x)
	{
		return thermeth7(1, 0, x+1);
	}
	
	static int thermeth7(int i, int t, int x)
	{
		if (i==x)
		{
			//if (x % 2==1)
			//{
				//t = t+(i*5);
			//}
			//else
			//{
				//t = t+i;
			//}
			return t;
		}
		if (i % 2==1)
		{
			return thermeth7(i+1,t+(i*5), x);
		}
		else
		{
			return thermeth7(i+1, t+i, x);
		}
	}
	
}
