/**
 * 
 */
package week15_Java8;

class  CA { } // concrete class

abstract class ACA extends CA  { } // an abstract class can extend a concrete class!!!

class CACA extends ACA {} 

public class Ζ_strangeCases {
	CA ca1 = new CA();
	//CA ca2 = new ACA(); // compile error
    CA ca3 = new CACA(); 
    
}
