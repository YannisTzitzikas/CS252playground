package week3_4;

// super class
class AA {
	AA() { System.out.println("an instance of A is created");}
	AA(int a) { System.out.println(a);}
	AA(Boolean b) { 
		if (b==true) {
			System.out.println("TRUE");
		}
	}
}
// subclass
class BP extends AA {
	void AA() { }
	BP() { super(true); System.out.println("MPAM"); }
	BP(int a) { }
}

class Tester {
	public static void main(String[] args){
		BP b1 = new BP(7);
	}
}

/*
class Asim {
	int a =0;
	
	Asim() {
		System.out.print(a + " -> ");
		a=1;
		System.out.println(a + " inst. of ASim  created");
	}
	
	Asim(int a){
		System.out.println(" Bam");
	}
}



class Csim extends Asim {
	//Csim() {	}
	Csim(int c) {
		System.out.println("inst. of CSim  created");
	}
}


class Tester {
	public static void main(String[] args){
		
		Asim a = new Asim();
		Bsim b = new Bsim();
		
		//Csim c1 = new Csim();
		Csim c2 = new Csim(3);
	}
}
*/