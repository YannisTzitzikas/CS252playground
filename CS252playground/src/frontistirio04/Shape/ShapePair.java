package csd.uoc.gr.Shape;

public class ShapePair extends Shape {
	private Shape shape1,shape2;
	
	public ShapePair(Shape s1,Shape s2){
		shape1 = s1;
		shape2 = s2;
	}
	
	public double getSurfaceArea(){
		return(shape1.getSurfaceArea()+shape2.getSurfaceArea());
	}

	@Override
	protected Object clone() {
		Shape s1 = (Shape)shape1.clone();
		Shape s2 = (Shape)shape2.clone();
		return(new ShapePair(s1,s2));
	}

	@Override
	public String toString() {
		return "A shape pair consisting of the following shapes:\n1. " + shape1.toString() + "\n" + shape2.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof ShapePair))
			return false;
		ShapePair sp = (ShapePair)o;
		if(!this.shape1.equals(sp.shape1))
			return false;
		if(!this.shape2.equals(sp.shape2))
			return false;
		return true;
	}
}
