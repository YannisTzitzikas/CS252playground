package csd.uoc.gr.Shape;

public class Sphere extends Shape3D {
	private int radius;
	private static double pi = 3.14;
	
	public Sphere(String n) {
		this.setName(n);
		this.radius = 1;
	}
	
	public Sphere(String n, int r) {
		this.setName(n);
		this.radius = r;
	}
	
	public Sphere(int r) {
		this.setName("Unnamed Sphere");
		this.radius = r;
	}
	
	@Override
	double getSurfaceArea() {
		return 4*pi*radius*radius;
	}

	@Override
	protected Object clone() {
		return(new Sphere(this.radius));
	}

	@Override
	public String toString() {
		return "Sphere with name " + this.getName() + " and radius: " + this.radius;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Sphere))
			return false;
		Sphere s = (Sphere)o;
		if (this.radius != s.radius)
			return false;
		else
			 return true;
	}

	@Override
	double getVolume() {
		return (4*pi*radius*radius*radius)/3;
	}

}
