package week6_Exceptions.selectedExamples;
class StudentNotFoundException extends Exception { }

class StudentCatalog { 
   int getAMOf(String s) throws StudentNotFoundException   { return 0;}
}
class GradStudentCatalog extends StudentCatalog { 
  int getAMOf(String s)  { 
	  try { 
		  return super.getAMOf(s);
	  } catch(StudentNotFoundException e) {
	     System.out.println(e);
	     return 1;
	  }
  }
}
class Test {
	public static void main(String[] args) {
		Student s = new GradStudent();
		try { 
			System.out.println(s.getAMOf("Yannis")); 
		} catch(Exception e) {System.out.println(e);}
	}
}
