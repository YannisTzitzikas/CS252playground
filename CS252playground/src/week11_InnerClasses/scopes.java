package week11_InnerClasses;

class EXTERNAL {
	private int extI ;
	void  extMethod(){
		System.out.println(pedio.intI);
	}
	INTERNAL pedio;
	class INTERNAL {
		private int intI;
		void  intMethod(){
			System.out.println(extI);
		}
	}
	
}

