/**
 * 
 */
package week3_4;

/**
 * @author Yannis Tzitzikas (yannistzitzik@gmail.com)
 *
 *  interfaces for grouping objects of diff classes
 *  (airplane load. Passenger<Person, CrewMember< Person Luggage, Packet)
 */

interface MassObject { int getWeight(); } // has one abstract method, by default Public

class PersonX implements MassObject { public int getWeight() {return 65;}} 
class Passenger extends PersonX {  Luggage[] luggages;}
class CrewMember extends PersonX {}
class Luggage { int getWeight() {return 0;}}
class Packet implements MassObject { public int getWeight() {return 1;}}

class Airplane {
	int maxLoadInKg ;
	MassObject[] epivatesKaiAposkeues;
	public int getLoad() {
		int sumLoad = 0 ;
		for (int i=0; i<epivatesKaiAposkeues.length; i++) {
			MassObject mo = epivatesKaiAposkeues[i];
			if (mo!=null)
				sumLoad+=mo.getWeight();
		}
		return sumLoad;
	}
	Airplane(int maxLoadInKg) {this.maxLoadInKg = maxLoadInKg;}
}


public class interfacesExampleAirplan {

	public static void main(String[] lala) {
        		
		int MaxCapacity = 100;
		int cur=0;
		Airplane a1 = new Airplane(2500);
		a1.epivatesKaiAposkeues = new MassObject[MaxCapacity]; //ok
		a1.epivatesKaiAposkeues[cur++] = new Packet();
		a1.epivatesKaiAposkeues[cur++] = new CrewMember();
		a1.epivatesKaiAposkeues[cur++] = new Packet();
		
		System.out.println("Load of airplane: " + a1.getLoad());	
		
	}

}
