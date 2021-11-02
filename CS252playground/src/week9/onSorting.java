package week9;
import java.util.*;


class Student7 implements Comparable {
	int AM;

	@Override
	public int compareTo(Object o) {
		Student7 s2= (Student7) o;
		return this.AM - s2.AM;
	}
	public String toString() { return " " + AM; }
	Student7(int am) {AM=am;}
}
class GradStudent extends Student7 { 
	
	@Override
	public int compareTo(Object o) {
		GradStudent s2= (GradStudent) o;
		return this.AM - s2.AM;
	}
	
	GradStudent(int am){super(am);}
}

class katataswTaPanta implements Comparator {
	public int compare(Object a, Object b) {
        //return 0;
		
		if ((a instanceof Student7) && (b instanceof Student7)) {
			Student7 sa= (Student7) a;
	        Student7 sb= (Student7) b;
	        
	        return sa.AM - sb.AM;
		}
		
		return -1;
	}
}

class SortExamples {
 
 public static void mySort(List list, Comparator c){
	 Object a[] = list.toArray();
	 Arrays.sort(a, c);
	 	 
	 ListIterator i = list.listIterator();
	 //System.out.println(i.hasNext()); // tmp
	 
	 for (int j=0;j<a.length; j++) {
		   i.next();
		   //System.out.println(i.next()); // wrong
		   i.set(a[j]);
	}
	 
	 
  }
}

class myComp implements Comparator {
	public int compare(Object a, Object b) {
		int i1 = ((Integer)a).intValue();
        int i2 = ((Integer)b).intValue();

        return Math.abs(i1) - Math.abs(i2);
	}
}

class SortExamplesTester {
	public static void main(String[] a){
		
		
		List list = new LinkedList();
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(-2);
		list.add(-1);
		list.add(-3);
		list.add(0);
		
		System.out.println(list);
		
		
		// Sorting using the utility function
		Collections.sort(list);
		System.out.println("Using the sort:\n" + list);
		
		
		Collections.sort(list, new myComp());
		System.out.println("Using the sort and my comparator:\n" + list);
		
		
			
		// Sorting using a custom method 
		SortExamples.mySort(list, new myComp());
		System.out.println("Using my method and my custom comparator:\n" + list);
		
		Student7 s1 = new Student7(4000);
		GradStudent s2 = new GradStudent(5000);
		GradStudent s3 = new GradStudent(6000);
		
		Collection bag = new HashSet();
		bag.add(s3);
		bag.add(s2);
		bag.add(s1);
		bag.add(7);
		
		
		//bag.add(4.1);
		//bag.add(4.2F);
		
		//bag.add(10);
		//bag.add(10);
		
		//bag.add("Yannis");
		//bag.add("Ioannis");
		System.out.println(bag);
		
		//Collection ss = new TreeSet(bag);
		Collection ss = new TreeSet(new katataswTaPanta());
		ss.addAll(bag);
		
		System.out.println(ss);
		
		
	}
}