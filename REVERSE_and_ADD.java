package REVERSE_and_ADD;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
	public static void main (String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split("\\s");
	    
	            if (lineArray.length > 0 &&  Integer.parseInt(line)<10000) {
	            	System.out.println(compute(Integer.parseInt(line)));
	            } 
	        }
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }             
	
	}
	public static String compute(int n )
	{	int i;
	
		for(i=0;i<100;i++){
			
				String rev=new StringBuilder(n+"").reverse().toString();
				n=n+Integer.parseInt(rev);
				if(isPalindrome(n)){
					i++;
					return i+" "+n;
				}
		}
		
		return "";
		
	}	
	public static boolean isPalindrome(int n){
		String s=n+"";
		if(s.equals(new StringBuilder(s).reverse().toString())){
			return true;	
		}else{
			return false;
		}
		
	}
}