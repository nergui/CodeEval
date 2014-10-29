package PrimeNumber;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static boolean[] Prime;
	public static int n;

	public static String findPrime(int n) {
		
		Prime = new boolean[(int) (n + 1)];
		for (int i = 1; i <= n; i++)
			Prime[i] = true;

		int num;
		int loc;
		
		for (num = 2; num <= Math.sqrt(n); num++)
			if (Prime[num]) {
				loc = num + num;
				while (loc <= n) {
					Prime[loc] = false;
					loc = loc + num;
				}
			}
		StringBuilder sb=new StringBuilder();
		for (int i = 2; i < Prime.length; i++) {

			if (Prime[i]) 
				sb.append(i+",");

		}
		
		return sb.toString().substring(0, sb.toString().length()-1);
		
	}

	public static void main(String[] args)  {
		 try {
		        File file = new File(args[0]);
		        BufferedReader in = new BufferedReader(new FileReader(file));
		        String line;
		        while ((line = in.readLine()) != null) {
		     	if(Long.parseLong(line)>0){
		     		System.out.println(findPrime(Integer.parseInt(line)));
		     	}
		        	
		        }
		    } catch (IOException e) {
		        System.out.println("File Read Error: " + e.getMessage());
		    }       

	}
}
