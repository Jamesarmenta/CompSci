
public class test {
	
	public static double[] list = new double[101];
	
	public static void main(String[] args)
	{
		
		for(int i=0; i < list.length; i++)
		{
			list[i] = -1;
		}
		
		System.out.println(tryit2(16));
	}
	
	public static double tryit(int num)
	{
		if (num<=3)
		{
			return num;
		}
		else
		{
			return (tryit(num-1)*tryit(num-2)/tryit(num-3));	
		}
	}
	
	public static double tryit2(int num)
	{
		if (num<=3)
		{
			list[num] = num;
		}
		if (list[num] == -1)
		{
			list[num] = tryit2(num-1)*tryit2(num-2)/tryit2(num-3);	
		}
			return list[num];
	}
}
