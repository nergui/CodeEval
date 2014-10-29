package FirstNonRepatedChar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Main {
	public static void main(String[] args)  {
		 BufferedReader in=null;
		 File file =null;
		 try {
		         file = new File(args[0]);
		       in = new BufferedReader(new FileReader(file));
		        String line;
		        while ((line = in.readLine()) != null) {
		        	   String[] lineArray = line.split("\\s");
		               if (lineArray.length > 0) {
		            	   compute(line);
		               } 
		        
		        }
		    } catch (IOException e) {
		        System.out.println("File Read Error: " + e.getMessage());
		    }  finally{
		    	if(in==null){

		    	}
		    }
	}
	public static void compute( String line )
	{	
		Hashtable<Character, Object> ht=new Hashtable<>();
		Object o1=new Object();
		Object o2=new Object();
		for(int i=0;i<line.length();i++){
			if(ht.get(line.charAt(i))==null){
				ht.put(line.charAt(i), o1);
			}else if(ht.get(line.charAt(i)).equals(o1)){
				ht.put(line.charAt(i), o2);
			}
			
		}
		
	for(int i=0;i<line.length();i++){
		char c=line.charAt(i);
		if(ht.get(c)==o1){
			System.out.println(c);
			break;
		}
	}
		
		
		
	}	
	
}