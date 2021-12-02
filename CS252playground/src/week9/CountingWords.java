package week9;


import java.io.*;
import java.util.*;

class Mysterious {	
  public  void dowork( String param ) {
   if ( param==null ) {	 System.exit( 1 );  }
   StreamTokenizer in = null;
   try {
       in = new StreamTokenizer( new BufferedReader (
	                         new FileReader ( param ) ) ); 
   } catch ( FileNotFoundException e ) {
	    System.err.println( e.getMessage() );
	    System.exit(1);
   }
   try {
	    TreeMap map = new TreeMap();
	    Integer one = new Integer(1);
	    while ( ( in.nextToken() != in.TT_EOF ) ) { // while we haven't reached EOF
			if ( in.ttype == in.TT_WORD ) { // the current token is a word
			    Integer freq = ( Integer ) map.get(in.sval); //in.sval is the token
			    if ( freq == null )
			    	freq = one;
			    else
			    	freq = new Integer( freq.intValue() + 1 );
			    map.put( in.sval, freq ); // 
			}
	    }
	    
	    SortedSet tmp = new TreeSet(map.keySet());
    	    String z = (String)tmp.last();
    	    System.out.println(z + " " + map.get(z));
    	// optional
    	   // System.out.println(map);
	} catch ( IOException e ) {
		System.err.println(e.getMessage() );
		System.exit( 1 );
	}
  }
}
class mtester {
	public static void main( String args[] ) {
		
		int zz = 0; zz=zz+1; zz=zz + 1 ;  
		String tmp1 = "C:\\Users\\tzitzik\\Documents\\YandT\\Yannis\\My_Program_Files\\Java-Programs\\252-COURSE\\src\\lectures\\Week9\\CountingWords.java"; 
		
		
		Mysterious m = new Mysterious();
		m.dowork(tmp1);
}
}
