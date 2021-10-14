/**
 * 
 */
package week2;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 * Date: Code written in class, Oct 14, 2021
 *
 */

// Example of a class with some utility methods (declared as static).
// It does not make sense to create instances for this class
class MyUtils {
	static String getCalendar() { return ".. this is a calendar"; }
	static String getMySocialMediaAddresses() { return null; }
}

class Student {
	private String logBook = ""; // in case we want every instance to keep track of its "history"
	int AM = 0;
	private String name; 
	String[] mylifeInStrings = new String[1000];
	
	void setName(String nm) {
		logBook+=", άλλαξα όνομα σε " + nm;
		name = nm;
	}
	
	static int numOfCreatedStudents =0; // static for the class
		
	public String toString() { return "Φοιτητής με ΑΜ " + this.AM + " ονομα " + this.name + " (η ιστορία μου είναι " + logBook + ")"; }
	
	// o pio plhrhs constructor
	Student(String onoma, int am) {
		this.logBook = "Δημιουργήθηκα με κλήση " + onoma + "  " + am; 
		if (am<0) {
			am = -am; // automatic correction
			//System.out.println("ΒΙΑΙΟΣ ΤΕΡΜΑΤΙΣΜΟΣ");
			//System.exit(3);
		}
		name = onoma;
		AM = am;
		numOfCreatedStudents++;
	}
		
	Student(int AM){
		this("Not entered yet",AM);
	}
	Student(String onoma) {
		this(onoma + "(δεν έχει ακόμα ΑΜ)", 0);
	}
	Student() {
		this("Lalakis",0);
		System.out.println("Log: creation of student without AM");
	}
}

class A_MemoryTest {
   public static void main(String[] lala) {
	  // if the method were not static:
	   //MyUtils u = new MyUtils(); System.out.println(u.getCalendar());
	  System.out.println(MyUtils.getCalendar());
	   
	   int K=1000;	   //int K=1000*1000;
	   Student[] worldStudents = new Student[K];   
	   
	   Student tmp = null ;
	   for (int i=0; i<K; i++) {
		   //tmp = new Student(i+1);  // the garbage collector will free the object in the next iteration
		   worldStudents[i] = new Student(i+1);
	   }
	   System.out.println(tmp);
	   System.out.println("Done!");
	   System.out.println(worldStudents[K/2]);
	   
	   System.out.println(new Student());
	   System.out.println(new Student("Yannis"));
	   System.out.println(new Student("Yannis",361));
	   
	   Student maria = new Student("Μαρία",-18);
	   System.out.println(maria);
	   maria.AM = 71;
	   //maria.name = "Mary";
	   maria.setName("Mary");
	   System.out.println(maria);
	   
	   System.out.println("Πλήθος φοιτητών που έχω κατασκευάσει: " + Student.numOfCreatedStudents);
   }
}

/*
this.pedio   :  anafora sto pedio tou trexontos antikeimeno
this(.lala..):  klisi ston constructor pou exei parametrous symvatous me to lala
*/



