package week1;

// Oct 12, 2021

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
		
		// 2D initialization
		
		String[][] triliza = {  
				{"X","O","O"},
				{"O","X","O","1","2","3"},
				{"X","O","O"},
	    };
		
		String[][] spy;
		spy = triliza;
		spy[0][0]="Bammm";
		
		for (String[] tr: triliza ) {
			System.out.println("This line has size " +  tr.length);
		}
		
		
		for (String[] tr: triliza) {
			for (String tcell: tr) {
				System.out.print(tcell);
			}
			System.out.print("\n");
		}

		
		for (int i=0; i<triliza.length; i++) {
			for (int j=0; j< triliza[i].length; j++) {
				System.out.print(triliza[i][j]);
			}
			System.out.print("\n");
		}
			
		
		for (int curVal :  new int[]  {4,3,2,1} ) {
			System.out.println(curVal);
		}

		Object tapantaola;
		tapantaola = triliza;
		tapantaola = "lala";
		
			
		System.out.println("\nBye bye Arrays");
		//	System.exit(0);
			
	
	} // main
	
}
