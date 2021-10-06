package week1;

import java.util.Scanner;

class Contact {
	int AM=0 ; 
	String name = "Δεν λέω τίποτα.";
	String address = "Κάπου στη γη";
	String allInfo() {
		return "Όνομα: " + name + " AM: " + AM +  " Δνση: " + address ;
	}
}

class ContactsInArray {
	
   public static void main(String[] lala) {
	   
	   System.out.println("Δώσε μου έναν αριθμό μητρώου:");
	   Scanner in = new Scanner(System.in);
	   int aNumber = in.nextInt();
  	   
	   int SIZE = 10;
	   Contact[] contacts = new Contact[SIZE];
	   
	   contacts[0] = new Contact();
	   contacts[0].name ="Γιάννης";
	   contacts[0].AM = aNumber;
	   
	   
	   for (int i=0; i<contacts.length; i++) {
		   contacts[i] = contacts[0];
	   }
	   
	   
	    for (int i=0; i<contacts.length; i++) {
		   System.out.println("Κελί "+ i + ": Πρόσωπο: " + contacts[i].allInfo());
	   }
	   
	   
   }
}
