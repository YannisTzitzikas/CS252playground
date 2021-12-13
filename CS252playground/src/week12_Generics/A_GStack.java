package week12_Generics;
import java.util.Vector;

/*
 * Generified Stack Implementation
 * 
 * Two uses of it: one for Strings and one for GameCards
 */

class MyStack<A> {
  private Vector<A> v = new Vector<A>();
  
  void push(A a) { v.add(a);}
  A  pop() { return v.lastElement();}
};

class GameCard {
	public  String toString() {return "Game Card";}	
}

class testGStack{
	public static void main(String arg[]) {
		String s = "Hello";
		MyStack<String> st = new  MyStack<String>();
		st.push(s);
		System.out.println(st.pop());

		MyStack<GameCard> st2 = new  MyStack<GameCard>();
		GameCard cp = new GameCard();
		st2.push(cp);
		System.out.println(st2.pop());

		MyStack<Object> st3 = new  MyStack<Object>();
		st3.push(new testGStack());
		System.out.println(st3.pop());

		
	}
}
