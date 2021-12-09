package week11_InnerClasses;

public class B_LinkedStack {
			private StackNode tos = null; // pointing to the top of the stack

  		  //private static class StackNode {
		  public static class StackNode {  // public an thelame  na einai kai externally usable
		    private Object data; 
		    private StackNode next;
		
		    public StackNode( Object o ) { this( o, null ); }
		    public StackNode( Object o, StackNode n ) {
		      data = o; next = n;
		    }
		    public StackNode getNext() { return next; }
		    public Object getData() { return data; }
		    public String toString() {
		    	return "(NodeWithData:" + data + ")";
		    }
		  }
  public boolean isEmpty() { return tos == null; }
  public boolean isFull() { return false; }
  public void push( Object o ) { tos = new StackNode( o, tos ); }
  public void pop() { tos = tos.getNext(); }
  public Object top() { return tos.getData(); }
  public String toString() {
	  int size=0;
	  String retString = "";
	  StackNode  curNode = tos;
	  while (curNode !=null) {
		  size++;
		  retString = retString + curNode + ",";
		  curNode = curNode.getNext();
	  }
	  return "Size="+ size+ " " + "<Stack: "+ retString + ">";
  }
}

class testLS {
	public static void main (String a[]){
		B_LinkedStack ls = new B_LinkedStack();
		System.out.println(ls.toString());
		ls.push("object1");
		ls.push("object2");
		ls.push("object3");
		ls.push("object4");

		ls.pop();
		//ls.pop();
		//ls.pop();
		
		System.out.println(ls.toString());
		//System.out.println(ls.top());
		
		//B_LinkedStack.StackNode sn = new B_LinkedStack.StackNode("obj 3"); // ERROR private inner class
		//System.out.println(sn);
	}
}
