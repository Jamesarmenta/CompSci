import java.util.Arrays;

public class Primes
{	
	public static int tally = 0;
	
	public static void main(String[] args) 
	{
		boolean[] primes=new boolean[144];
		runnit(primes);
	}

	public static void runnit(boolean[] primes)
	{
		fillarray(primes);

		for(int num=0; num<primes.length;num++)
		{
			if(primes[num])
			{
				System.out.println(num);
				tally++;
			}
		}	
		
		System.out.println("TOTAL:" + tally);
	}

	// will contain true or false values for the first 10,000 integers
	//set up the primesieve
	public static boolean[] fillarray(boolean[] primes) 
	{
		Arrays.fill(primes,true);        // assume all integers are prime.
		primes[0]=primes[1]=false;    // we know 0 and 1 are not prime.

		for (int i=2;i<primes.length;i++) 
		{
			//if the number is prime, 
			//then go through all its multiples and make their values false.
			if(primes[i]) 
			{
				for (int j=2;i*j<primes.length;j++) 
				{
					primes[i*j]=false;
				}
			}
		}
		
		return primes;
	}
}