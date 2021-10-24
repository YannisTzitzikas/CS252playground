package csd.uoc.gr.Shape;

public class Square extends Rectangle{
	int width;
	
	public Square(String n) {
		super(n, 1, 1);
	}
	
	public Square(String n, int w) {
		super(n, w, w);
	}
	
	public Square(int w) {
		super(w, w);
	}

}
