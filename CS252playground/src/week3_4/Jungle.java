package week3_4;

/*
 * Author: Yannis Tzitzikas 
 * Version V2, 2024
 */
class Animal {
	String name = "living being";
	void saySomething() {} ; // δεν κάνει τίποτα
	void reactToEarthQuake() { // 2 φορές λέει κάτι
		saySomething(); 
		saySomething();
	}; 
}

class Dog extends Animal {
	void saySomething() { System.out.print("[  Γαβ]");} //override
	Dog() {
		name = "αγριόσκυλο";
	}
}

class Cat extends Animal {
	String name = "Γάτα";  // extra attribute!
	void saySomething() { System.out.print("[Nιάου]");}  
	void reactToEarthQuake() { 
		super.saySomething();
		super.saySomething();
		//super.reactToEarthQuake();
		System.out.print("[Δεν μασάω] είμαι " + name);} 
	Cat() {
		super.name = "ΓΑΤΑ";
	}
}


class DogEMAK extends Dog {   // εκπαιδευμένος σκύλος
	void reactToEarthQuake() { 
		super.reactToEarthQuake(); // κάνει ό,τι και ένας "νορμάλ" σκύλος
		System.out.print("[ φσιτ]"); // και επιπλέον "σφυρίζει"
	};
}

class Fish extends Animal {
	void saySomething() 	 { System.out.print("[ Μπλμ]");}  
	void reactToEarthQuake() { System.out.print("[~~~~~]");};  // σε περίπτωση σεισμού "κυματίζει"
	Fish() {
		name = "σαργός";
	}
}


class JungleDemo {
	
	public static void main(String[] aaa) {
		System.out.println("-JUNGLE DEMO v0.1");
		/*
		Animal a1 = new Animal();
		a1.saySomething();
		a1.reactToEarthQuake();  // tipota
		
		Dog d1 = new Dog();
		d1.reactToEarthQuake(); // -> γαβ γαβ
		
		Cat  c1  = new Cat();  // η cat δημιούργησε ένα αντικείμενο
		c1.saySomething();
		System.out.println();
		c1.reactToEarthQuake();
		
		System.out.println();
		a1 = c1;            // η μτβλ a1 τύπου Animal δείχνει ένα αντκμνο που δη/σε η Cat
		System.out.println(a1.name); // αφού ενα αντικμνο τπ γατας έχει 2 ονόματα
		                              // (το κληρονομημένο και το δικό της)
									  // επειδή ο τύπος της μτβλ που δείχνει στο αντκμ
		                              // είναι animal, ΘΑ διαβάσω το πεδίο name της animal
		System.out.println(c1.name); // αφού ενα αντικμνο τπ γατας έχει 2 ονόματα
							        // (το κληρονομημένο και το δικό της)
									  // επειδή ο τύπος της μτβλ που δείχνει στο αντκμ
							        // είναι  cat, ΘΑ διαβάσω το πεδίο name της cat
		
		System.out.println(((Cat)a1).name); // -> Γάτα
		//System.out.println(((Dog)a1).name); // exception
		
		/*
		System.out.println(a1 instanceof Cat); // true
		System.out.println(a1 instanceof Animal); // true
		System.out.println(a1 instanceof Object); // true
		
		System.exit(1);
		
		Animal a2 = new Animal();
		System.out.println(a2 instanceof Cat);
		
		*/
		
		// my pets
		System.out.println("======================");
		Animal[] myPets =  { new Dog(), 
							 new Cat(), 
							 new Fish(), 
							 new Animal() {
									void saySomething()  { System.out.print("[ ΑΡΙΑΝΟΣ]");} 
								}
							}; 
		for (Animal a: myPets) {
			System.out.print("Τώρα θα μιλήσει η/ο/το " + a.name + ": ");

			a.reactToEarthQuake();
			System.out.println();
		}
		
	
		
		/*
		Animal a1 = new DogEMAK();
		a1.saySomething();
		System.out.println();
		a1.reactToEarthQuake();
		*/
		
		//Animal a1 = new Animal();
			//a1.reactToEarthQuake();
			
		//	Animal c1 = new Cat();  // δημιουργία μιας γάτας, το δείκτη τον κρατά μτβλ τύπου Animal
			//c1.saySomething();
		//	c1.reactToEarthQuake();
			
			
			//Animal d1 = new Dog();  // δημιουργία ενός σκύλου, το δείκτη τον κρατά μτβλ τύπου Animal
			//c1.saySomething();      // Αν δεν υπήρχε overidding τί θα παίρναμε;
			//d1.saySomething();
				
		//makeJungle();
	}
	
	
	static void makeJungle() { 
		System.out.println("S i m u l a t i o n   o f   t h e    U n i v e r s e   v0.1");
		int numOfAnimals = 100; // πλήθος των ζώων που θα δημιουργηθούν
		System.out.println("Number of animals:" + numOfAnimals);
		
		Animal[] amazonios = new Animal[numOfAnimals]; // πίνακας που θα κρατάει αναφορές στα αντικείμενα τύπου ζώο
		
		// CREATION DAY
		for (int i=0; i<numOfAnimals; i++ ){
			//amazonios[i] = (Math.random() > 0.6) ? new Dog() : new Cat() ; // an thelame mono gates kai skylous	
			double tyxaiosArithmos = Math.random(); // από το 0 έως το 1
			Animal neoZwo;
			if (tyxaiosArithmos<0.3)
				neoZwo = new Cat();
			else if (tyxaiosArithmos<0.6)
				neoZwo = new Dog();
			else if (tyxaiosArithmos<0.9)
				neoZwo = new Fish();
			else neoZwo = new DogEMAK();
			amazonios[i] = neoZwo;
		}

		// EXISTENCE CHECK
		System.out.println("\n========= YPARKSIAKOS ELEGXOS =========");
		for (int i=0; i<numOfAnimals; i++ ){
			amazonios[i].saySomething();
		}
		
		// EARTHQUAKE REACTION:  
		System.out.println("\n========= SEISMOS! =========");
		for (int i=0; i<numOfAnimals; i++ ){
			amazonios[i].reactToEarthQuake();
		}
	
		
		// NIKHTHS TOU LOTTO    
		System.out.println("\n=========  APOTELESMATA KLHRWSHS ========= ");
		
		int luckyIndex = (int) Math.round(Math.random()*numOfAnimals);
		System.out.println("O nikiths ths klhrwshs auths ths ebdomadas einai to zwo me arithmo " +
							luckyIndex +
							" το οποίο ανήκει στην κλάση " +
							amazonios[luckyIndex].getClass() ); // reflection
		if (amazonios[luckyIndex] instanceof Dog) 
				System.out.println("Πράγματι είναι σκύλος.");
		
		
		Object o1 = new DogEMAK();
		Dog o2 = ((Dog) o1);
		Animal a3 = o2;
		
		System.out.println("Η ΚΛΑΣΗ ΤΟΥ ΕΙΝΑΙ " + a3.getClass() +
				" " + ((Dog)a3).name);
		
	}
	
}


