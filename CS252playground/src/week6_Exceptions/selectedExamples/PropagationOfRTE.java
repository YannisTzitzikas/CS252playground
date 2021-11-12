package week6_Exceptions.selectedExamples;

/*
 * Βλέπουμε των διαδίδεται μια unchecked εξαίρεση ακόμα και αν 
 * δεν είναι δηλωμένη.
 */


 class PropagationOfRuntimeExceptions {

	 // this method creates a runtime (unchecked) exception
	 static void method1()  {
		 int a = 1/0; // this will create a runtime (unchecked) exception
	 }
	 
	 // this method does not catch anything
	 static void method2() {
		 method1();
	 }
	 
	 
	 public static void main(String[] a) {
		
		 try {
			 method2(); 
		 } catch (Exception e) {
			 System.out.println("Bingo I catched the exception: "+ e);
			 main(null); // recursive call to main!
		 } catch (Error e) {
			 System.out.println("Mallon ... kollhsa :( "+ e);
		 }
		 System.out.println("I am ok..");
		 
	 }
	 
}
 

