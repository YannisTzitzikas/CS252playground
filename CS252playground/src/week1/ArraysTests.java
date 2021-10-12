package week1;

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
		
		System.out.println(students);
		System.out.println(students[0]);  // arxikopoihsh timwn se 0
		System.out.println(students[9]);  // out of bounds
		//System.out.println(students[-1]);
		
		// Week days shortcuts
		String[] days = new String[7];
		days[0] = "Mon";
		days[1] = "Tue";
		days[2] = "Wed";
		days[3] = "Thu";
		days[4] = "Fri";
		days[5] = "Sat";
		days[6] = "Sun";
		for (String d: days) {
			System.out.print(d + " ");
		}
		for (int i=0; i<days.length; i++) {
			System.out.print(days[i] + "_");
		}
		
		// Declaration and initialization (automatic size calculation)
		System.out.println();
		String[] months = { "Jan", "Feb", "Aug1", "Aug2"  };
		for (String m: months) {
			System.out.println("Month:"+ m);
			for (String d: days)
				System.out.print(d + " ");
			System.out.println();
				
		}
		
		// 2D, 3D, XD arrays
		int[][] sodoku = new int[9][9];
		//String[][] sodoku = new String[9][9];
		//Foo[][] sodoku = new Foo[9][9];
		
		int[] oneSolution = {9,8,7,1,2,3,5,4,6,44444444};
		int[] tooSmall = {1000};
		
		sodoku[6] = oneSolution;
		sodoku[8] = tooSmall;
		sodoku[8] = oneSolution;
		sodoku[8][sodoku[8].length-1]=77;
				
		for (int i=0; i<sodoku.length; i++) {
			for (int j=0; j < sodoku[i].length; j++) {
			//for (int j=0; j < 9; j++) {	
				System.out.print(sodoku[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		System.out.println("\nBye bye Arrays");
		
		
		
		
		
		
		
		
		System.exit(0);
		
		
		// Αρχικοποίηση με τη δήλωση
		int[] p = {22,0,0};
		//int[] p;		p = new int[3];		p[0]=22;
		
		
		// Τρίλιζα
		
		//int[][] triliza = new int[3][3];
		
		int[][] triliza = {  
							{0,1,0},
							{1,0,0,7,8,9},
							{2,0,1},
						  };
		
		
		//int[] tmp  = {0,1,0};
		//triliza[1] = tmp;
		//triliza[1] = new int[1];
		
		for (int i=0; i<triliza.length; i++) {
			for (int j=0; j<triliza[i].length; j++) 
				System.out.print(triliza[i][j]+ " ");
			System.out.println();
		}
		//System.out.print(triliza[0][4]);
		
		//main(null);
		
		/*
		
		// ΔΗΛΩΣΕΙΣ
		int[] p1 = {2,1,4,5,6};
		
		int[][] p2 =  {    
				        {2,1,7},
				        {4,5}
				      } ;
		
		int[][] p3 = new int[2][3];
		
		
		int[][] p4 = new int[2][];
		
		p4[0] = new int[30];
		
		
		System.out.println(p2[0].length);
		System.out.println(p2[1].length);
		
		
		System.out.println(p3[0].length);
		System.out.println(p3[1].length);
		
		System.out.println("Ola kala!");
		*/
	}
	
}
