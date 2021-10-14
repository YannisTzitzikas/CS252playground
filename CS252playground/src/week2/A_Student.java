package week2;

class A_Student {
  private String AT = "000000"; // arithmos tautothtas  // PRIVATE
  protected  int AM = 0;  // PACKAGE -Private + SUBCLASSES  in other packages
  public  String lastName = "anonymous"; // OPEN
  String[]  hobbies = { "programming" };  // PACKAGE -Private
  void  foo() {
	  System.out.println(this.AT);
  }
   public String getInfo() {
	   return "Φοιτητής με Αρ. Ταυτότητας: " + AT + " Αρ. Μητρώου: " + AM + " Όνομα: " + lastName; }
}

class StudentCSD extends A_Student {
	public String getInfo() { 
		return super.getInfo() + " που φητά στο CSD-UOC!";
		//return "CSD STUDENT WITH" + AT + " " + AM + " " + lastName; 
		}
}

class TESTER {
	public static void main(String[] lala) {
		A_Student p1 = new A_Student();
		System.out.println(p1.getInfo());
		
		StudentCSD s1 = new StudentCSD();
		System.out.println(s1.getInfo());
		
		
	}
}