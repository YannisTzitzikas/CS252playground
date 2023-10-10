package week2;

// TOPICS:
// Responsibilities of each class
// Encapsulation
//
// Use Case:

class  University {
	String name;
	private Tmima[] tmimata  = new Tmima[50];
	private int numOfTmimata =0;
	void addTmima(Tmima t) {
		tmimata[numOfTmimata++] = t;
	}
	public String toString() {
		return name;
		//return name + " " + numOfTmimata  + " " +  tmimata;
	}
	
	University(String name) {
		this.name = name;
	}
	
	University() {
		
	}
}

// Resposiblilities: Na dinei katalogo twn didaskliwn eksaminou
class Tmima  {
	String 		name;
	University  ofUniversity; 
	
	public String toString() {
		return name + " ("  + ofUniversity + ")";
	}
	
	Tmima(String t, University u) {
		name = t;
		ofUniversity = u;
		u.addTmima(this);
	}
}

// Responsibility:  Eggrafh se didasklia, ekdosh analytikhs, ekdosh pytixou
class Spoudastis {
	String name;
	int  AM;
	Tmima tmima;
	
	void enroll(Didaskalia d) { }
	void printAnalytiki() { }
	void ekdoshPtyxiou() {} 
	
	Spoudastis()  {
		System.out.println(">>Creation of a student");
	}
}

class Grad extends Spoudastis {
	Grad()  {
		System.out.println(">>Creation of a grad student");
	}
}



class Eggrafh {
	Didaskalia  didaskaliaMathimatos;
	Spoudastis     student;
	float		grade = 0 ;
	
}

class Mathima {
	String code;
	String title;
	int ECTS; 
	Tmima tmima; 
}

class Didaskon {
	String name;
}


enum Examino { Fall, Spring };

class Didaskalia {
	int year;
	Examino examino;
	Didaskon instructor; 
	Mathima  mathima;
}


class UniversityTest {
  public static void main(String [] a) {
	  University uoc = new University();
	  uoc.name = "Πανεπιστήμιο Κρήτης";
	  
	  University uoa = new University();
	  uoa.name = "Καποδιστριακό Πανεπιστήμιο Αθηνών";
	  
	  Tmima csd = new Tmima("Τμήμα Επιστήμης Υπολογιστών", uoc);
	  Tmima math = new Tmima("Τμήμα Μαθηματικών", uoc);
	  
	  Tmima[] tmimata = {csd, math, new Tmima("Φυσικό",uoc),
			  			 new Tmima("Computer Science, USA", new University("ΜΙΤ"))
	  };
	  
	  for (Tmima t: tmimata ) {
		  System.out.println(t);
	  }
	  
	  
	 // Grad s = new Grad();
	  
	  Grad s2 = new Grad() { public String toString() {return " Αγνωστος τύπος μεταπτυχιακού";}};
	  
	  //System.out.println(s);
	  System.out.println(s2);
	  
	   
	  
	
  }
}
