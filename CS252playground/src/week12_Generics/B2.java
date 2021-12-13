package week12_Generics;

/**
 * Restrictions of the type parameter 
 * 
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 */
interface PlugAndPlay {
	void play();
}

class Person {
	int  getAT() { return 0;}
}

class Student extends Person implements PlugAndPlay {
	public void play() {;} 
}

 class NaturalNumber<T extends Person & PlugAndPlay> {
    private T n;
    public NaturalNumber()  {  }
    public NaturalNumber(T n)  { this.n = n; }
    public boolean isEven() {
    	n.play();
        return n.getAT()% 2 == 0;
    }
}
 
class TESTER {
	public static void main(String[] lala) {
		NaturalNumber<Student> nn = new NaturalNumber<Student>();
		
	}
}

