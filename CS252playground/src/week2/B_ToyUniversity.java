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
		return name + " " + numOfTmimata  + " " +  tmimata;
	}
}

// Resposiblilities: Na dinei katalogo twn didaskliwn eksaminou
class Tmima  {
	 String 		name;
	University  ofUniversity; 
	
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
	  
	  System.out.println(uoc);
	  
	
  }
}
