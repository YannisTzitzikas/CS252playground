package week15_Java8;
interface Taxer {
	double getTaxOf(double value) ;
	//String getName(String s);
}


class Tameio {
	static double getTax(double price, Taxer txr) {
		return price - txr.getTaxOf(price);
	}
}
class Testing {
	public static void main(String[] args){	
		// With anonymous class (no lambas)
		System.out.println(Tameio.getTax(100.0, new Taxer() {
			public double getTaxOf(double value) {
				return value*.20;
			}
		}));
		// With lambas (3 examples)
		System.out.println(Tameio.getTax(100.0, (x) -> 1.0));  // 1 Euro tax
		System.out.println(Tameio.getTax(100.0, (x) -> x*.10));  // 10% tax
		System.out.println(Tameio.getTax(100.0, (x) -> x*.23));  // 23% tax
		
		//System.out.println(Tameio.getTax(100.0, (x) -> { return null;}));  // 23% tax
		
		Taxer crazyTaxer  = (lol) -> lol*0.001 ; 
		Taxer madTaxer    = (mad) -> -mad*1.50 ;
		System.out.println(Tameio.getTax(100.0, crazyTaxer));
		System.out.println(Tameio.getTax(100.0, madTaxer));
		
		
	}
}
class Product { private int price =0; void setPrice(int x) {price=x;} int getPrice() {return price;}}
interface TaxerTestReadOnly {
	double getTaxOf(Product value) ;
}
class Tameio2 {
	static double getTax(Product product, TaxerTestReadOnly txr) {
		return product.getPrice() - txr.getTaxOf(product);
	}
}
class Testing2 {
	public static void main(String[] args){	
		
		TaxerTestReadOnly crazyTaxer  = (p) ->  2; 
		//Taxer madTaxer    = (mad) -> -mad*1.50 ;
		Product p = new Product(); p.setPrice(10);
		System.out.println(Tameio2.getTax(p, crazyTaxer));
		
		int EconomicSituation=200;
		//for (int EconomicSituation=1; EconomicSituation<2; EconomicSituation++)
			System.out.println(Tameio2.getTax(p, (x) -> { x.setPrice(100); return EconomicSituation*x.getPrice();}) );
		//assert p.getPrice()==10;
	}
}
	


