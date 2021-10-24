package csd.uoc.gr.Shape;

public class Circle extends Shape {
	int radius;
	private static double pi = 3.14;

	public Circle(String n) {
		this.setName(n);
		this.radius = 1;
	}
	
	public Circle(String n, int r) {
		this.setName(n);
		this.radius = r;
	}
	
	public Circle(int r) {
		this.setName("Unnamed Circle");
		this.radius = r;
	}
	
	@Override
	double getSurfaceArea() {
		return pi * radius * radius;
	}

	@Override
	protected Object clone() {
		return(new Circle(radius));
	}

	@Override
	public String toString() {
		return "Circle with name " + this.getName() + " and radius: " + this.radius;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Circle))
			return false;
		Circle c = (Circle)o;
		if (this.radius != c.radius)
			return false;
		return true; 
	}

}
