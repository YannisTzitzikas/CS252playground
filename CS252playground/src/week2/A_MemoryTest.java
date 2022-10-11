/**
 * 
 */
package week2;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 * Date: Code written in class, Oct 14, 2021, modified Oct 11, 2022
 *
 */

// Example of a class with some utility methods (declared as static).
// It does not make sense to create instances for this class
class MyUtils {
	static String getCalendar() { return ".. this is a calendar (still Tue)"; }
	static String getMySocialMediaAddresses() { return null; }
}

class Tuesday {
	public static void main(String[] lala) {
		System.out.println(MyUtils.getCalendar()); // calling a static method of a class
		System.out.println(Math.abs(-5) );
		
		//MyUtils u = new MyUtils();  // new object (instance of class MyUtils)
		//System.out.println(u.getCalendar()); // send the message getCalendar to u
		//System.out.println(MyUtils.getCalendar());
	}
}




class Student {
	static int numOfCreatedStudents =0; // static for the class

	int 		AM = -1;
	String name; 	
	private 	String logBook = ""; // in case we want every instance to keep track of its "history"
	String[]    mylifeInStrings = new String[1000];
	
	void setName(String nm) {
		logBook+=", άλλαξα όνομα σε " + nm;
		name = nm;
	}
	
	//public String toString() { return "Φοιτητής με ΑΜ " + this.AM + " ονομα " + this.name + " (η ιστορία μου είναι " + logBook + ")"; }
		
	Student(int AM){
		this("Not entered yet",AM);
	}
	Student(String onoma) {
		this(onoma + "(δεν έχει ακόμα ΑΜ)", 0);
	}
	
	
	public String toString() {
		return "Φοιτητής με ΑΜ " + this.AM + " και όνομα " + this.name;
	}
	// o pio plhrhs constructor
	Student(String onoma, int am) {
			//this.logBook = "Δημιουργήθηκα με κλήση " + onoma + "  " + am; 
			if (am<0) {
				am = -am; // automatic correction
				//System.out.println("ΒΙΑΙΟΣ ΤΕΡΜΑΤΙΣΜΟΣ");
				//System.exit(3);
			}
			name = onoma;
			AM = am;
			numOfCreatedStudents++; // we use to this to know the # of created objects
		}
	Student() {
		this("Uknown name",-1);
	}
}

class A_MemoryTest {
   public static void main(String[] lala) {
	   
	   Student s1 = new Student("Yannis",2);
	   
	   System.out.println(s1.AM);
	   System.out.println(s1.name);
	   System.out.println(s1);
	   
	   Student s2 = new Student();
	   System.out.println(s2.AM);
	   System.out.println(s2.name);
	   //System.out.println(s2);
	   
	   Student s3 = new Student(11);
	   Student s4 = new Student("Maria");
	   
	   Student[]  students = {s1, s2, s3, s4};
	   for (Student cs: students)
		   System.out.println(cs);
	   
	   System.out.println("# of created objects: " + Student.numOfCreatedStudents);
	   
	   System.out.println(s4.numOfCreatedStudents);
	   
	   System.out.println(s4.toString());
	   System.out.println(s4);
	   /*
	   Object o1 = new Object();
	   System.out.println(o1);  // klisi sthn toString() ths Java pou exei oristei sthn klash Object
	   o1 = s4;
	   System.out.println(o1); // tha klithei h toStriong() thw Object 'h ths Student???
	   */
	   System.out.println("================================");
	   int K=1000*1000; 
	   Student[] worldStudents = new Student[K];  // 1 ek * size of 1 pointer  
	   
	   for (int i=0; i<K; i++) {	   
		   Student s  = new Student(i);
		   worldStudents[i] = worldStudents[0];
		   //worldStudents[i] = s;
		   //worldStudents[i] = s4;
		   //worldStudents[i] = new Student(i);
		   
	   }
	   System.out.println(worldStudents[200]);
	   
	   
	   System.out.println("Ola kala");
		/*
	   
	   
	   
	   
	  // if the method were not static:
	   //MyUtils u = new MyUtils(); System.out.println(u.getCalendar());
	  //System.out.println(MyUtils.getCalendar());
	   
	  
	   
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
	   */
   }
}

/*
this.pedio   :  anafora sto pedio tou trexontos antikeimeno
this(.lala..):  klisi ston constructor pou exei parametrous symvatous me to lala
*/



