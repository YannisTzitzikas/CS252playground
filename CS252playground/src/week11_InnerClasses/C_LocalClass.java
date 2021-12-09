package week11_InnerClasses;

/**
 * Example of a local inner clsss
 * @author tzitzik
 *
 */

class EnclosingClassL {
	  String name = "Local class example";

	  public void aMethod( final int h, int w ) {
	    int j = 20; final int k = 30;

	    class LocalClass {
	      public void aMethod() {
	        System.out.println( h );
	        //System.out.println( w ); ERROR w is not final
	        // System.out.println( j ); ERROR j is not final
	 	System.out.println( k );
		// System.out.println( i ); ERROR i is not declared yet
		System.out.println( name); // normal member access 
	    }}

	    LocalClass l = new LocalClass(); l.aMethod();
	    final int i = 10; }

	    public static void main(String a[]) {
	      EnclosingClassL c = new EnclosingClassL(); 
	      c.aMethod( 10, 50 ); 
	      }
	  }

