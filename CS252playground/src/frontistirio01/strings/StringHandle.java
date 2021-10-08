import java.lang.*;

class Indexofstr{

	String full_str= new String();
        String sub_str= new String();
	char temp,temp1;
	int i;
	
	// Constructor

	public Indexofstr(String str,char c,char a,String str1){
		full_str=str;
		temp=c;
		temp1=a;
		sub_str=str1;
	}

	String neoString(){                     // indexOf(char) + substring(int)
		i= full_str.indexOf(temp);
		return full_str.substring(i);
	}

        String neoString1(){                    // lastIndexOf(char) + substring(int)
                i= full_str.lastIndexOf(temp1);
                return full_str.substring(i);
        }


        String neoString2(){                    // indexOf(String) + substring(int begin,int end)
                i= full_str.indexOf(sub_str);
                return full_str.substring(i,i+4);
        }

}

public class StringHandle{
	
	public static void main(String[] args){
		Indexofstr tmp= new Indexofstr("JavaProgram",'a','m',"og");
		String str= new String();	
		String[] table= new String[5];
		int[] int_table;
		int[][] dokimi= new int[4][];
		int[][] dok;
		int i;

		dok= new int[3][];
		for (i=0; i<dok.length; i++){
			dok[i]= new int[2];
		} 
		str=tmp.neoString();
		
		System.out.println("The First String is : " +  str);
		str=tmp.neoString1();
                System.out.println("The Second String is : " +  str);
                str=tmp.neoString2();
                System.out.println("The Third String is : " +  str);
		System.out.println();

		StringBuffer k= new StringBuffer("Hello World");
		k.insert(6,"JAVA ");                       
		System.out.println(k.toString());

                                        //  insert(int , String)  gia StringBuffer

                k.insert(6,1000);
		System.out.println(k.toString());

					//  toString()   gia metatropi apo StringBuffer se String

		System.out.println();
		k.replace(0,5,"Java ");
					//  replace( int start, int end, String) gia StringBuffer

		System.out.println(k.toString());
		System.out.println();

					//  Xrhsh PINAKWN
		
		
		int_table= new int[10];
		for (i=0; i<int_table.length; i++){
			int_table[i]=i;
		}

		for (i=0; i<table.length; i++){
			if ((i!=0)&&((5%i)!=0)){
				table[i]="JAVA";
			}
			else{
				table[i]="C++";
			}
		}

		for (i=0; i<table.length; i++){
			System.out.println(table[i]);
		}
			
		System.out.println();
	
		char[] copyfrom={'a','b','c','d','e','f','g','h','i','j','k'};
		char[] copyto= new char[8];

		System.arraycopy(copyfrom,5,copyto,2,5);
                System.out.println(copyto);
		System.out.println();

	}
}
		

