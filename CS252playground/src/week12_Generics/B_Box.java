package week12_Generics;
 
class Box<T> {
    private T t;          
    public void set(T t) {  this.t = t; }
    public T get() {  return t;  }
    public <U extends Number> void inspect(U u){
       System.out.println("T: " + t.getClass().getName());
       System.out.println("U: " + u.getClass().getName());
       System.out.println();
    }
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        //integerBox.inspect("some text"); //compile error! here
        integerBox.inspect(18); 
        
       // System.exit(1);
        
        Box<String> stringBox = new Box<String>();
        stringBox.set("Yannis");
       //stringBox.set(22); // compile error
        
        stringBox.inspect(11);
        stringBox.<Integer>inspect(11);
        
        System.exit(1);
        //stringBox.<Float>inspect(11);
        stringBox.<Float>inspect(11.4f);
        stringBox.inspect(11.4f);
        stringBox.inspect("some text"); // Compile Error too. 
       
        }
}

