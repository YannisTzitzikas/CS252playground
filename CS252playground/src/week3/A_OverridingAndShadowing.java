/**
 * 
 */
package week3;

class Ugrad { 
	int DM = 140;  int perYear() { return DM/4; }
}

class Grad extends Ugrad { 
	int DM = 28; 
	int perYear() { return DM/2; };
	int super_perYear() {return super.perYear();}
	int superDM() {return super.DM; } 
	int UgradCastDM() {return ((Ugrad)this).DM; }
}

class TestShadowingAndOverriding {
	public static void main(String[] lala) {
	
	Grad g = new Grad();
	System.out.println(g.DM);              // 28
	System.out.println(g.perYear());       // 14
	System.out.println(g.super_perYear()); // 35
	System.out.println(g.superDM()); 	   //140
	System.out.println(g.UgradCastDM());   //140
	Ugrad u = (Ugrad) g;
	System.out.println(u.DM);              //140
	System.out.println(u.perYear()); }   //  14
	
}