package csd.uoc.gr.Shape;

public class Rectangle extends Shape {
	int width, length;
	
	public Rectangle(String n) {
		this.setName(n);
		this.width = 1;
		this.length = 1;
	}
	
	public Rectangle(String n, int w, int l) {
		this.setName(n);
		this.width = w;
		this.length = l;
	}
	
	public Rectangle(int w, int l) {
		this.setName("Unnamed Rectangle");
		this.width = w;
		this.length = l;
	}
	
	@Override
	double getSurfaceArea() {
		return width*length;
	}

	@Override
	protected Object clone() {
		return(new Rectangle(width, length));
	}

	@Override
	public String toString() {
		return "Rectangle with name " + this.getName() + " width: " + this.width + " and length: " + this.length;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Rectangle))
			return false;
		Rectangle r = (Rectangle)o;
		if (this.width != r.width)
			return false;
		if (this.length!=r.length)
			return false;
		return true; 
	}

}
