package week1;


public class ArraysTests {

	public static void main(String[] args ) {
		
		
		int[] p = {22,0,0};
		
		//int[] p;		p = new int[3];		p[0]=22;
		
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
