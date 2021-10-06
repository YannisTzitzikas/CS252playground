package week1;

public class Foititis {
	String AT; // αριθμός ταυτότητας. 
	
	protected String department = "csd-uoc" ; 
	
	private static int numberOfStudentsCreated; 	
	
	static int getNumberOfStudentsCreated() {
		return numberOfStudentsCreated;
	}
	int birthYear = -1;
	int AM =0 ; 
	String name; 
	String[] activities; // = { "Μπιλιάρδο" }; 
	
	
	String activitiesToString() {
		String retString =""; 
		
		if (activities!=null) {
			for (int i=0; i< activities.length; i++ ) {
				retString += activities[i] + " ";
			}
		}
		return retString;
	}
	
	public String toString() {
		return "Φοιτ. του τμήματος  " + department +  "  με όνομα " + name + " και ΑΜ " + AM + " γεννηθ. το " + birthYear + "\n\t Του αρέσει: " + activitiesToString();
	}
		
	
	
	Foititis(Foititis original) {
		this(original.AM, original.name);
	}
	public Foititis() {
		numberOfStudentsCreated++;
		//this(0,"ΟΚανένας");
	}
	
	Foititis(int am) {
		this(am,"Δεν ξέρω πως τον λένε");
	}
	
	public Foititis(String name) {
		this(0,name);
	}
		
	
	public Foititis(int AM, String name) {
		if (AM>0)   // check validity of parameters
			this.AM = AM;
		else 
			this.AM = -AM;  //  auto correction
		this.name = name;
		numberOfStudentsCreated++;
	}
}


class MyApp {
	public static void main(String[] a) {
		System.out.println("STARTED");
		Foititis f1 = new Foititis(-2, "Yannis");
		
		f1.AT = "2";
		
		
		Foititis f2 = new Foititis();
		Foititis f3 = new Foititis("Παναγιώτης Παναγιώτου του Παναγιώτη");
		Foititis f4 = new Foititis(245);
		
	    f4.department = "Μαθηματικό";
		
		Foititis f5 = new Foititis(f4); 
		
		//Foititis f6 = (Foititis)f4.clone();
		
		
		
		//Foititis f5 = f4;
		//f5.department = "CSD again";
		
		//f4.numberOfStudentsCreated =300;	
		/*
		String[] tmps = { "Πινγ Πονγκ", "Κολύμπι", "Cinema" };
		f3.activities = tmps;
		*/
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(f5);
		System.out.println("Πλήθος στιγμιοτύπων που έχουν δημιουργηθεί: " + Foititis.getNumberOfStudentsCreated());
	}
}
