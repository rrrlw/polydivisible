import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Calculate
{
	private static ArrayList<Integer> lens;
	private static BigInteger base;
	private static int bInt,
					   counter;
	private static PrintWriter fout;
	public static void main(String[] args) throws IOException
	{
		//2 command line arguments: base, output file
		bInt = Integer.parseInt(args[0]);
		base = BigInteger.valueOf(bInt);
		fout = new PrintWriter(new FileWriter(args[1]));
		
		//calculate and print all polydivisible numbers for that base
		counter = 0;
		long start = 0, end = 0;
		start = System.currentTimeMillis();
		for (int i = 1; i < bInt; i++)
			allPoly(BigInteger.valueOf(i), BigInteger.ONE);
		end = System.currentTimeMillis();
		
		//close output file stream, print termination msg
		fout.close();
		System.out.println(counter + " polydivisibles in base " + bInt + "; " + (end - start) / 1000.0 + " sec to calculate.");
	}
	private static void allPoly(BigInteger curr, BigInteger numDigits)
	{
		//store current one into file and increment counter
		counter++;
		fout.println(curr.toString(bInt));
		
		//try every possible addition
		curr = curr.multiply(base);
		BigInteger temp,
				   tempDig = numDigits.add(BigInteger.ONE);
		for (BigInteger i = BigInteger.ZERO; i.compareTo(base) < 0; i = i.add(BigInteger.ONE))
		{
			temp = curr.add(i);
			if (temp.mod(tempDig).equals(BigInteger.ZERO))
				allPoly(temp, tempDig);
		}
	}
}