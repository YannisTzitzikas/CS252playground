package week12_Generics;

import java.util.ArrayList;
import java.util.List;

class Fruit { }
class Apple extends Fruit {}

class JustTesting {
	
	 // Passing an object as parameter
	 void echoV1(Object param ){
		 System.out.println(param);
	 }
	 
	 <T> void echoV2(T param) {
		System.out.println(param);
	 }
	
	 <T extends Fruit> void echoV3(T param) {
			System.out.println(param);
	 }
	 
	 //  Passing a list  as parameter
	 
	 void echoListV1(List<Object> lista) {    
			System.out.println(lista);
	 }
	 
	 <T> void echoListV2(List<T> lista) {
		    
			System.out.println(lista);
	 }
	 
	 
	 // TODO (7/12/2017): extends => SUPER
	 // super me ? oxi me T dioti den tha htna safes
	 // to type-erasure ti typo na evaze (praktika object)
	 // see http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeParameters.html#FAQ107
	 <T extends Fruit> void echoListV3(List<T> lista) {
			System.out.println(lista); 
			//lista.add(new Fruit()); // apagoreuetai
			//lista.add(new Apple()); // apogoreuetai
			lista.add(null); // epitrepetai
	 }
	 
	 void echoListV4(List<?> lista) {
			System.out.println(lista);  // I don't need to use the type in the body
	 }
	 
	 void echoListV5(List<? super Fruit> lista) {
			System.out.println(lista);  // I don't need to use the type in the body
			lista.add(new Fruit());
			lista.add(new Apple());
			//lista.add(new Object());
			
	 }
	 
	 /*
	 // TMP (7/12/2017):  see below comment
	 <T super Fruit > void echoListV3(Object lala) {
			//System.out.println(lista); 
			//lista.add(new Fruit());
			//lista.add(new Apple());
	 }
	 */
	 
}

public class D_WildCards {
	public static void main(String[] args){
	   JustTesting a1 = new JustTesting();	
	   
	   //---V1
	   a1.echoV1(7);
	   a1.echoV1("epta");
	   //---V2
	   a1.echoV2(7);
	   a1.echoV2("epta");
	   a1.<String>echoV2("aaa");
	   //---V3
	   //a1.echoV3(7);
	   //a1.echoV3("epta");
	   a1.echoV3(new Fruit());
	   a1.echoV3(new Apple());
	   
	  
	   
	   // Wild Cards
	   
	   List<Fruit> frlist = new ArrayList<Fruit>();
	   List<Apple> aplist = new ArrayList<Apple>();
	  
	   //frlist = aplist; // not OK since the type params are different
	   
	   
	   // Wild Cards
	   //a1.echoListV1(frlist); // not OK
	   //a1.echoListV1( new ArrayList<Object>()); // ok
	   
	   
	   a1.echoListV2(frlist);
	   a1.echoListV3(frlist);
	   a1.echoListV4(frlist);
	   a1.echoListV5(frlist);
	   //a1.echoListV5(aplist); // not OK
	}
}
