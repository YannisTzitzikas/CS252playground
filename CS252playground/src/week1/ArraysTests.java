package week1;

import java.util.ArrayList;
import java.util.List;

// Oct 20022

class Foo {
	
}
public class ArraysTests {

	public static void main(String[] args ) {
		System.out.println("Hello Arrays");
		
		// Pinakas AM foithton
	
		// Dilwsh
		int K=10;
		int[]  students; // students---pointer--> antikeimeno typou pinakas akeraiwn
		students = new int[K]; // δέσμευση χώρου
		
		System.out.println(students[3]);  // arxikopoihsh timwn se 0
		
		
		
		//System.out.println(students[10]);  // out of bounds
		
		
		//System.out.println(students[-1]);
		System.out.println(students); // Default behavior of toString() is to print class name, then @, then unsigned hexadecimal representation of the hash code of the object.
		
		
		
		
		//int[] pa  = new int[3];		pa = students;		System.out.println(pa);
		
		
		// Week days shortcuts
		String[] days = new String[7];
		days[0] = "Mon";
		days[1] = "Tue";
		days[2] = "Wed";
		days[3] = "Thu";
		days[4] = "Fri";
		days[5] = "Sat";
		days[6] = "Sun";
		// String[] days = { "Mon", "Tue"  }; 
		
		
		for (int i=0; i<days.length; i++) {
			System.out.print(days[i] + " ");
		}
		
		//System.exit(1);
		System.out.println();
		for (String d: days) {
			System.out.print(d + " ");
		}
		
		
		//days.length = 78;
		System.out.println();
		
		
		// Declaration and initialization (automatic size calculation)
		System.out.println();
		String[] months = { "Jan", "Feb", "March", "April"  };
		for (String m: months) {
			System.out.println("***Month:"+ m);
			for (String d: days)
				System.out.printf("%5s", d);
			System.out.println();
			for (int i=1; i<=31; i++) {
				System.out.printf("%5d",i);
				//System.out.print(i +" ");
				if (i%7==0) {
					System.out.println();
				}
			}
			System.out.println();
		}
		
		//System.exit(1);
		
		// 2D, 3D, XD arrays
	
		System.out.println("\n sodoku \n");
		int N=9;
		int[][] sodoku = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j < N; j++) {	
				System.out.print(sodoku[i][j] + " ");
			}
			System.out.println();
		}
		
		int[] oneSolution = {9,8,7,1,2,3,5,4,6,44444444,44,-12,18};
		int[] tooSmall = {1000,8000};
		
		sodoku[2] = oneSolution;
		sodoku[3] = tooSmall;
		sodoku[3][0]=-5000;
		sodoku[7] = tooSmall;
		sodoku[8] = tooSmall;
		
		/*
			// for loop with predetermined sizes
		for (int i=0; i<N; i++) {
			for (int j=0; j < N; j++) {	
				System.out.print(sodoku[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		
		// for loop that considers the size of each row
		System.out.println("=======================");
		for (int i=0; i<sodoku.length; i++) {
			for (int j=0; j < sodoku[i].length; j++) {
			//for (int j=0; j < 9; j++) {	
				System.out.print(sodoku[i][j] + " ");
			}
			System.out.println();
		}
		
		/*
		
		System.exit(2);
		sodoku[6] = oneSolution;
		sodoku[8] = tooSmall;
		sodoku[8] = oneSolution;
		//sodoku[8][sodoku[8].length-1]=77;
				
		for (int i=0; i<sodoku.length; i++) {
			for (int j=0; j < sodoku[i].length; j++) {
			//for (int j=0; j < 9; j++) {	
				System.out.print(sodoku[i][j] + " ");
			}
			System.out.println();
		}
		
		*/
		
		// 2D initialization
		System.out.println("\n\n");
		
		String[] omades = { "ΠΑΟ", "ΟΦΗ" };
		
		String[][] triliza = {  
				{"X","O","O"},
				//{"X","O","O"},
				{"O","X","O","1","2","3"},
				{"X","O","O"},
	    };
		
		for (int i=0; i<triliza.length;i++) {
			for (int j=0; j<triliza[i].length; j++) {
				System.out.printf("%5s", triliza[i][j]);
			}
			System.out.println();
		}
		
		
		//int[] pinakas = {4,3,8,1};
		//for (int curVal :  pinakas) {
		for (int curVal: new int[] {4,3}) {
			
			System.out.println(curVal);
		}
		
		
		
		List  lista = new ArrayList() ;
		lista.add("Lala");
		
		
		
		String[][] spy;
		spy = triliza;
		spy[0][0]="Bammm";
		
		for (String[] tr: triliza ) {
			System.out.println("This line has size " +  tr.length);
		}

		
		for (String[] tr: triliza) {
			for (String tcell: tr) {
				System.out.print(tcell + " ");
			}
			System.out.print("\n");
		}

	  //System.exit(1);
		
		for (int i=0; i<triliza.length; i++) {
			for (int j=0; j< triliza[i].length; j++) {
				System.out.print(triliza[i][j]+" ");
			}
			System.out.print("\n");
		}
			
		
		for (int curVal :  new int[]  {4,3,2,1} ) {
			System.out.println(curVal);
		}

		Object tapantaola;
		
		//tapantaola = 2;
		tapantaola = new Integer(2); // Integer is a wrapper class for int
		
		//tapantaola = triliza;
		
		//tapantaola = "lala";
		
		System.out.println("====");
		System.out.println(tapantaola);
		
		
		String[] d = { "Mon", "Tue" };
		Object[][] p = new Object[2][2];
		p[0][0] = 44;
		p[0][1] = "καλημέρα";
		p[1][0] = d;
		p[1][1] = p;
		
		for (int i=0; i<p.length; i++) {
			for (int j=0; j< p[i].length; j++) {
				System.out.print(p[i][j]+" ");
				if (p[i][j] instanceof Integer) {
					System.out.println("INTINT");
				}
				if (p[i][j] instanceof Object[]) {
					System.out.println("OYAOY");
				}
				if (p[i][j] instanceof String[]) {
					System.out.print("Βρήκα String:");
					
					for (int h=0; h<((String[] ) p[i][j]).length; h++) {
						System.out.print("["+((String[] ) p[i][j])[h]+"]");
					}
					
					
					
					System.out.print("\n");
				}
			}
			System.out.print("\n");
		}
		
		
		//
		ArrayList al = new ArrayList();
		
		for (int i=0; i<20; i++) {
			al.add(i);
		}
		System.out.println(al);
		
		
		System.out.println("\nBye bye Arrays");
		//	System.exit(0);
		
	
	} // main
	
}
