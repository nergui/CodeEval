package DOUBLE_SQUARES;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        
	        String firstLine = in.readLine();

	        for(String line; (line = in.readLine()) != null; ) {
	            String[] lineArray = line.split("\\s");
	            int N=Integer.parseInt(line);
	            if (lineArray.length > 0) {
	            	System.out.println(checkNumber(N));
	            } 
	        }
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
	public static int checkNumber(int n){
		int count=0;
		if(n==0){
			return 1;
		}
		for(int i=1;i<=Math.sqrt(n);i++){
			double x=Math.sqrt(n-i*i);
			if(Math.round(x)==x && x<i  ){
				count++;
			}
			
		}
		return count;
	}
}
