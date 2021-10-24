package csd.uoc.gr.Shape;

public abstract class Shape implements Cloneable {
	private String ShapeName;
	abstract double getSurfaceArea();
	protected abstract Object clone();
	public abstract String toString();
	public abstract boolean equals(Object o);
	
	public String getName() {
		return this.ShapeName;
	}
	
	public void setName(String n) {
		this.ShapeName = n;
	}
}
