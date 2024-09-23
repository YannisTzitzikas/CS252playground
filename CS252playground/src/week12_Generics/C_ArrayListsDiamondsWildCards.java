package week12_Generics;
import java.util.*;


class Frouto {}
class Portokali extends Frouto  {} 
class BigOrange extends Portokali {} 


class TestGenerics{
	
	void testSimpleTypes() {
		Collection<String> col = new ArrayList<String>();
		col.add("Yannis");
		System.out.println(col);
		List <String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		//l1 = l2;
		//l2 = l1;
		System.out.println(l1.getClass().equals(l2.getClass()));
		
		TestGenerics tmp = new TestGenerics();
		System.out.println(tmp.getClass());
		
		System.out.println(l1.getClass()); 
		System.out.println(l2.getClass());
		
		System.exit(1);
		
		
		
		//l2 = l1; // not compatible 
		//System.out.println(l1.getClass() ==  l2.getClass()); // why we get true? Due to type erasure both have the type ArrayList<Object>
		
		List<? extends Object> l4;
		//l1 = (List<String>) l4;
		
	}
	
	void testAssignments() {
		System.out.println("Test Assignments");
		Set<Portokali>  p1 = new HashSet<Portokali>();
		Set<Portokali>  p2 = new HashSet<>();
		Set<Frouto>     f1 = new HashSet<Frouto>();
		 
		//Set<Portokali>  p3 = new HashSet<Frouto>(); // NOT COMPATIBLE TYPES
		//Set<Frouto>     p30 = new HashSet<Portokali>();
		
	    //p1.add("Yannis"); // invalid. The compiler understands this problem.
		p1.add(new Portokali());
		p1.add(new BigOrange());
		//HashSet<Portokali> hp = new HashSet<BigOrange>();
	}
	
	void testAssignments_bounds() {
		 //Set<X extends Frouto>  t1 = new HashSet<>(); // syntaktika den exei nohma
		
	}
	void testAssignments_wildcards() {
		
		// normal case
		Set<Frouto>   t2tmp = new HashSet<>();
		t2tmp.add(new Frouto());  
		t2tmp.add(new Portokali());  
		
		
		// "Read Only"
		Set<? extends Frouto>   t2 = new HashSet<>();
		//t2.add(new Frouto()); // o agnwstos typos ? tha mporouse na einai mia ypoklash tou Froutou, ara den mporw na valw apla ena fruit
		//t2.add(new Portokali()); // gia ton idio logo den douleuei
		//t2.add(new BigOrange()); // gia ton idio logo den douleuei
				
		t2 = t2tmp;
		System.out.println(t2);
		t2.add(null);
		System.out.println(t2);
		t2.clear();
		System.out.println(t2);
		
		t2.add(null);
		
		
		///*
		Set<BigOrange> bos = new TreeSet<>();
		//bos.add(new BigOrange());
		t2 = bos;
		
		
				
		Set<BigOrange> bo = new HashSet<BigOrange>();
		t2 = bo;
		
		//t2.add(new Frouto());
		//t2.add(new Portokali());
		
				
		Set<Portokali> portoklaia = new HashSet<Portokali>();
		portoklaia.add(new BigOrange());
		
		t2 = portoklaia;
		
		
		
		
		//t2.add(new Frouto()); // den mporw na valw tipota sto t2, mono null. 
		//t2.add(new Portokali());
		//t2.add(new Object());
		t2.add(null);  // this is the only thing that we can add
		
		
		
		Set<? extends Frouto>   t2b ;
		t2b = new HashSet<Portokali>(); // Edw fainetai oti mporei h syllogh na eixe portokalia
		//t2b.add(new Frouto()); // opote orthws den mporw na valw tipota sto t2b, mono null
		//t2b.add(new Portokali());
		t2b.add(null);
		
		
		
		Set<? extends Frouto>   t3 = new HashSet<Frouto>();
		//t3.add(new Frouto()); // again we cannot add anything (apart from null) 
		
		Set<Frouto> t4 = 	(HashSet<Frouto>) t3; // type casting (correct one)
		t4.add(new Frouto()); // now we can add fruits
		
		
		// OUT PARAMETERS:  CAN WRITE
		Set<? super Frouto>   t5 = new HashSet<Frouto>(); //=> EGGYHSH o agnwstos typos sigoura den einai ypoklash tou Fruto
		t5.add(new Frouto()); 
		t5.add(new Portokali());
		t5.add(new BigOrange());
		//t5.add(new Object());
		
		
		//t5.add("ananas");
		Set<? super Object> t6 = new HashSet<Object>();
		t6.add(new Object());
		t6.add("yannis");
		t6.add(new BigOrange());
		t6.add(11);
		
		
		ArrayList< ? extends Object> v = new ArrayList<Portokali>();
		ArrayList< ? extends Portokali> vi = new ArrayList<Portokali>();
		//ArrayList< ? extends Portokali> vii= new ArrayList<Frouto>();
		//v.add("Ciao"); //invalid
		//v.add(new Portokali()); // invalid
		v.add(null); // valid
		v.add(null); // valid
		System.out.println(v.get(1));
		v.clear(); // valid;
		
		//*/
		System.out.println("-method end-");
	}
	
	public static void main(String arg[]) {
		TestGenerics o = new TestGenerics();
		//o.testSimpleTypes();
		//o.testAssignments();
		//o.testAssignments_bounds();
		o.testAssignments_wildcards();
		
		/*
		List<Portokali> lala0 = new ArrayList();
		lala0.add(new BigOrange());
		
		List<Map<String,Set<ArrayList<Fruit>>>> lala;
		lala = new LinkedList((Collection) new TreeMap());
		//lala.get(0).put("a",(new HashSet()).add(new ArrayList<Fruit>()));
		*/
	}
}
