package week13_Reflection;

class A {};
class B extends A {};
class C extends B implements Cloneable {};

public class ClassInfo {
	
    // We expect class names as command line arguments
    public static void main(String[] argsTMP) {
   
    	ClassInfo info = new ClassInfo();
    
    	String argsw[] = {"javax.swing.JOptionPane" };
		
    	String argswExtra[] = {"java.lang.Object",  
    			"java.util.Vector", "java.io.Serializable", 
    			"java.lang.Cloneable","java.lang.reflect.Array",
    			"javax.swing.JOptionPane",
    			};
    	
    
    	String[] classesToAnalyze = argsw;
    	
        for(int i = 0; i < classesToAnalyze.length; i++) {
            try {
            	System.out.println("===============================");
            	info.printInfo(Class.forName(classesToAnalyze[i]), 0);
            } catch(ClassNotFoundException e) {
                System.err.println(e); // report the error
            }
        }
   }
   // by default print on standard output
   private java.io.PrintStream out = System.out;
   // used in printInfo() for labeling type names
   private static String[] 
           basic    = {"class",   "interface"},
           extended = {"extends", "implements"};
   
   public void printInfo(Class type, int depth) {
	    // Object�s supertype is null
	    if(type == null)
	       return;
	    // print out this type
	    for(int i=0; i < depth; i++)
	      out.print("\t");
	    String[] labels = (depth == 0 ? basic : extended);
	    out.print(labels[type.isInterface() ? 1 : 0] + " ");
	    out.println(type.getName());
	    // print out all interface this class implements
	    Class[] interfaces = type.getInterfaces();
	    for(int i = 0; i < interfaces.length ; i++)
	        printInfo(interfaces[i], depth + 1);
	    // recurse on the superclass
	    printInfo(type.getSuperclass(), depth + 1);
	  }
	}

