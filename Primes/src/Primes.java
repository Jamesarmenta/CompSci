import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes
{	

	public static void main(String[] args) 
	{
		int TALLY = 0;
		int SPAN = 9999-1000+2;
		
		int[] numbers = new int[SPAN];
		int[] list = new int[SPAN];
		
		//populate array
		for(int p = 0; p < SPAN; p++)
		{
			numbers[p] = p;
		}
		
		//analyze
		for(int i = 1000; i < SPAN+999; i++)
		{
			int[] num = new int[10];
			for(int x = 0; x < num.length+1; x++)
			{
				numbers[x] = 0;
			}
			
			int thousands = (int) Math.floor(i/1000);
			int hundreds = (int) Math.floor((i-(thousands*1000))/100);
			int tens = (int) Math.floor((i-(thousands*1000)-(hundreds*100))/10);
			int ones = (int) Math.floor((i-(thousands*1000)-(hundreds*100)-(tens*10))/1);
			
			num[thousands] = num[thousands]+1;
			num[hundreds] = num[hundreds]+1;
			num[tens] = num[tens]+1;
			num[ones] = num[ones]+1;
			
			for(int y = 0; y < num.length; y++)
			{
				if(num[y]>1 || i%2==1)
				{
					System.out.println(i);
					TALLY++;
					break;
				}
			}
		}
		
		System.out.println("TOTAL:" + TALLY);
		
	}
}