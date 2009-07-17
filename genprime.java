public class genprime {
	private static boolean isprime(int x)
	{
		int lim, y;
		if (x < 2)
			return false;
		if (x < 4)
			return true;
		if (x == 5)
			return true;
		if (x % 2 == 0)
			return false;
		if (x % 5 == 0)
			return false;
		if ((x + 1) % 6 != 0)
			if ((x - 1) % 6 != 0)
				return false;
		lim = (int)(Math.sqrt((double)x) + 1.0f);
		for (y = 3; y < lim; y += 2)
		{
			if (x % y == 0)
				return false;
		}
		return true;
	}
	
	private static int genprime(int max)
	{
		int count = 0,
		     current = 1;
		while (count < max)
		{
			if (isprime(current))
				count++;
			current++;
		}
		return current - 1;
	}

	public static void main(String[] args)
	{
		int start = Integer.parseInt(args[0]),
		stop = Integer.parseInt(args[1]) + 1,
		last;
		for ( int x = start; x < stop; x += start )
		{
			long starttime = System.nanoTime();
			last = genprime(x);
			long endtime = System.nanoTime();
			double duration = ((double)endtime - (double)starttime) / 1000000000.0;
			System.out.printf ("Found %8d primes in %10.5f seconds (last was %10d)\n",
				x, duration, last);
		}
	}
}
