package frontistirio04.Shape;

public class ShapeDemoClient {
	public static void main(String argv[ ]) {
		 Circle c1 = new Circle("Circle C1");
		 Circle c2 = new Circle("Circle C2", 3);
		 
		 Square s1 = new Square("Square S1");
		 Square s2 = new Square("Square S2", 3);
		 
		 Shape shapeArray[ ] = {c1, s1, c2, s2};
		 
		 for (int i = 0; i < shapeArray.length; i++) {
			 System.out.println("The area of " + shapeArray[i].getName( ) + " is " + shapeArray[i].getSurfaceArea() + " sq. cm."); }
		 }
}
