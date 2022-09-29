/**
 * 
 */
package week1;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 * Code just for showcasing:
 * a/ polymorhism
 * b/ stack/heap space problems
 * c/ calls to mains
 */

interface Component {
	abstract void show();
	abstract void sayHello();
}

interface LALA {
	
}


class Video implements Component, LALA {
	public void show() { System.out.println("...video..."); }
	public void sayHello() { System.out.println("...hi from video...");}
	public static void main(String[] lala) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}

class Img implements Component {
	public void show() { System.out.println("...img..."); }
	public void sayHello() { System.out.println("...hi from img...");}
}
class Student implements Component {
	public void show() { System.out.println("...my am is csd888..."); }
	public void sayHello() { System.out.println("...hi there...");}
}

class APP {

	//static void main(int k) { System.out.println("o,ti na nai");}
	
	public static void main(String[] lala) {
		Video v1 = new Video();
		Img   i1 = new Img();
		Student stud1 = new Student();
		Component[] items = {v1,i1,stud1};
		for (Component i: items) {
			i.show();
			i.sayHello();
		}
		
		
		/*
		int k = 1000*1000*1000*1000;
		System.out.println(k);
		*/
		
		/*
		try {
			int[]  bigTable = new int[1000*1000*1000*1000];
			int i = 5/0;
		} catch (Throwable e) {
			
			//System.out.println("Έχω πρόβλημα: " + e);
		}
			
		*/
			
		//main(null); // recursive call: will lead to stack overflow
		//Video.main(null); // calling the main of another class
		//main(4); // calling a main having a different signature
		
	}

}
