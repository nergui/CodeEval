package REVERSE_GROUPS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main (String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split("\\s");
	    
	            if (lineArray.length > 0) {
	            	checkNumber(line);
	            } 
	        }
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }             
	
	}
	
	public static void checkNumber(String str){
	  String[] s=str.split(";");
	  int n =Integer.parseInt(s[1]);
	  str=s[0];
	  String[] sub=str.split(",");
	  if(n>0 && sub.length>0){
		  
	   
	  Hashtable<Integer, Queue<String>> hb =new Hashtable<>();
	
	  for(int i=0;i<n;i++){
		  Queue<String> q=new LinkedList<String>();
		  hb.put(new Integer(i), q);
	
	  }
	  for(int i=0;i<sub.length/n*n;i++){
		  hb.get(i%n).add(sub[i]);	  
	  }
	  StringBuilder sb=new StringBuilder();
	  boolean flag=true;
	  while(flag){
		  for(int j=n-1;j>=0;j--){
			  if(!hb.get(j).isEmpty()){
				  sb.append(hb.get(j).poll()+",");
				  
			  }else{
				  flag=false;
			  }
		  }  
	  }
	  
	  for(int i=sub.length/n*n;i<sub.length;i++){
			  sb.append(sub[i]+",");  
	  }
	  System.out.println(sb.toString().substring(0,sb.toString().length()-1));
	
	}
	}

}
