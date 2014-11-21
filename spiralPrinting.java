package spiralPrinting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// some branche

// home branche
public class Main {

	public static void main (String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	    
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split(";");
	            
	            if (lineArray.length == 3  ) {
	            	System.out.println(SpiralPrint(lineArray));
	            } 
	        }
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
	public static String SpiralPrint(String[] sent){
		
		int n=Integer.parseInt(sent[0]);
		int m=Integer.parseInt(sent[1]);
		//System.out.print(n + " : "+m+" ");
		if(n>0 && m>0){
			String numbers=sent[2];
			String[] num=numbers.split("\\s");
			String[][] arr=new String[n][m];
			String[] direction=new String[4];
			
			direction[0]="s";
			direction[1]="d";
			direction[2]="b";
			direction[3]="u";
			int i=0;
			
			for(int k=0;k<num.length;k++){
				if(k>0 && k%m==0){
					i++;
				}
				arr[i][k%m]=num[k];		
			}
			int d=0;
			i=0;
			int j=0;
			
		
			for(int t=0;t<num.length;t++){
					//System.out.println(i+":"+j);
					System.out.print(arr[i][j] +" ");
					arr[i][j]=0+"";
						  if(direction[0].equals(direction[d]) && ( j+1>=m || arr[i][j+1]==0+"")){
						d=d+1;	
						i++;
					}else if(direction[0].equals(direction[d]) &&  j+1<m){
						j++;
					}else if(direction[1].equals(direction[d]) && ( i+1==n || arr[i+1][j]==0+"")){
						d=d+1;
						j--;
					}else if(direction[1].equals(direction[d]) && ( i+1<n)){
						i++;
						
					}else if(direction[2].equals(direction[d]) && ( j-1<0 || arr[i][j-1]==0+"")){
						d=d+1;
						i--;
					}else if(direction[2].equals(direction[d]) && ( j-1>=0)){
						j--;
					}else if(direction[3].equals(direction[d]) && ( i-1<0 || arr[i-1][j]==0+"")){
						d=d+1;
						j++;
					}else if(direction[3].equals(direction[d]) && ( i-1>=0)){
						i--;
					}
					
					if(d>=direction.length){
						d=0;
					}
				
			}
				
		}
		
		return "";
	}
	public static String CheckMoveForward(){
		return "";
	}
	
}
