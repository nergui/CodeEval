
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Main {
	public class point{
		private double x;
		private double y;
		public point(double mx1, double my1){
			x=mx1;
			y=my1;
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		
	}
	public class line{
		private point p1;
		private point p2;

		public line(point mp1, point mp2){
			p1=mp1;
			p2=mp2;
		}

		public point getP1() {
			return p1;
		}

		public void setP1(point p1) {
			this.p1 = p1;
		}

		public point getP2() {
			return p2;
		}

		public void setP2(point p2) {
			this.p2 = p2;
		}
		
		
	}
	public static Hashtable<Integer, line> bridges= new Hashtable<>();
	public static line mLine;
	public static void main(String[] args) {
		
		try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        
	        String line;
	        while ((line = in.readLine()) != null) {
	        	String[] l=line.split(":");	
	        	if(l.length==2){
	        		String[] lineArray=clearBrackets(l[1]);
	        		point p1= new Main().new point(Double.parseDouble(lineArray[0]),Double.parseDouble(lineArray[1]));
	        		point p2=new Main().new point(Double.parseDouble(lineArray[2]), Double.parseDouble(lineArray[3]));
		        	mLine = new Main().new line(p1,p2 );
		        	bridges.put(new Integer(l[0]), mLine);
	        	}
	        }
	        compute();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }  

	}
	private static void compute() {
		
		
		Hashtable<Integer,Hashtable<Integer,Integer> > map=new Hashtable<Integer,Hashtable<Integer,Integer>>();
		
		for (Integer key : bridges.keySet()) {
			
			map.put(key, new Hashtable<Integer,Integer>());
			
		}
		for (Integer key : bridges.keySet()) {
			line l1 =bridges.get(key);
				
			for (Integer ke : bridges.keySet()) {
				
				line l2 =bridges.get(ke);
				if(InterSect(l1, l2)){
					map.get(key).put(ke,ke);
				}
				
					
			}
		}
		
		int t;
	
		while((t= getLognestHashtableByKey(map)) !=0){
			Hashtable<Integer, Integer> temp=map.get(t);
			
			for (Integer key : temp.keySet()) {
				if(map.get(key).get(t)!=null){
					//System.out.println(key+":"+t);
					map.get(key).remove(t);	
				}
				
			}
			map.remove(t);
			
		}
		
		ArrayList<Integer> v = new ArrayList<Integer>(map.keySet());
		Collections.sort(v);
		for (Integer key : v) {    
		    System.out.println(key);  
		}  
		
		
		
	}
	public static int getLognestHashtableByKey(Hashtable<Integer, Hashtable<Integer, Integer>> map){
		int max=0;
		int tulhuur=0;
		
		for (Integer key : map.keySet()) {
			if(map.get(key).size()>max){
				max=map.get(key).size();
				tulhuur=key;
			}
		}
		
    	return tulhuur;
	}
	
	public static String[] clearBrackets(String line){
	
    	line=line.replaceAll("\\[|\\]","");
    	line=line.replaceAll("\\(|\\)","");
    	String[] lineArray = line.split(",");
    	
    	
    	return lineArray;
	}
	
	
	public static boolean InterSect(line l1, line l2){
		point A,B,C,D;
		A=l1.getP1();
		B=l1.getP2();
		C=l2.getP1();
		D=l2.getP2();
		return ccw(A,C,D) != ccw(B,C,D) && ccw(A,B,C) != ccw(A,B,D);
	}
	public static boolean ccw(point a,point b,point c){
		
		return (c.getY()-a.getY())*(b.getX()-a.getX())>(b.getY()-a.getY())*(c.getX()-a.getX());
	}
	
	
	
}