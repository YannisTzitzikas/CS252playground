/**
 * 
 */
package week5;

abstract class Actor {
	String name = "φυσικό ή νομικό πρόσωπο";
	String afm;
}

class XPerson extends Actor {
	String AMKA;
	XPerson() {
		name = " Μανούσος";
	}
}

class XCompany extends Actor implements Good {
	XCompany() {
		name = " FunIT";
	}
    public String getName() { return name; }
	public double getPrice() {return 0;	}
}

//abstract class Agatho   {
interface Good   {	
	  String getName(); 
	  double getPrice() ; 
}

class XCar implements Good {
	Actor owner;
	String model = "ferrari";
	public String getName() { return model;}
	public double getPrice()  { return -1.0; } 
}

class XHouse implements Good {
	Actor  owner;
	String address = "boutes";
	public String getName() { return address;}
	public double getPrice()  { return -1.0; } 
}

class Contract {
	  Actor seller;
	  Actor  buyer ;
	  Good  agatho;
	 
	  public String toString()  {
		  return  "Συμβόλαιο με: \n"
		  		+ " Πωλητή: " + seller.name + 
				  " Αγοραστή: " + buyer.name + 
				  " Αντικείμενο: "  + agatho.getName() + 
				  " Τιμή " + agatho.getPrice();
	  }
}


public class RealEstateApp {
	public static void main(String[] args) {
		System.out.println("Real Estate app");
		
		
		XCompany google = new XCompany();
		google.name = "Google";
		
		XCompany microsoft = new XCompany();
		microsoft.name = "Microsoft";
		
		XCompany company252 = new XCompany();
		company252.name = "252students";
		
		
	    Contract c1 = new Contract();
	    c1.seller = google;
	    c1.buyer  = microsoft;
	    c1.agatho = company252;
	    
	    XPerson p = new XPerson();
	    c1.agatho = p;
	    
	    System.out.println(c1);
	    
	}

}
