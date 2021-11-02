package week5.JVisBrowser;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


interface LoLoLo {}
interface Lalala extends LoLoLo {} 

class A {}
class B extends A implements Lalala {}
class C extends B {}

public class ReflectiveClassInfo extends C {
	
    // We expect class names as command line arguments
    public static void main(String[] argsTMP) {
    	ReflectiveClassInfo info = new ReflectiveClassInfo();
    
    	/*
    	  String argsw[] = {"java.lang.Object", 
    	 
    			"java.util.Vector", "java.io.Serializable", 
    			"java.lang.Cloneable","java.lang.reflect.Array",
    			"javax.swing.JOptionPane"
                 };
    	*/
    	
    	String args[]  = {"week5.JVisBrowser.ReflectiveClassInfo"};

    	
    	//String args[]  = {"javax.swing.JOptionPane"};
    				//	,  "lectures.Week5.JVisBrowser.ReflectiveClassInfo"};
    
        for(int i = 0; i < args.length; i++) {
            try {
            	System.out.println("===============================");
            	info.printInfo(Class.forName(args[i]), 0);
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
   
   public void printInfo(Object o) {
	   System.out.println(">>>>>>>>>About the Class of this object:");
	   printInfo(o.getClass(), 0);
	   
	   
	   System.out.println(">>>>>>>>>About the instance variables of this object:");
	   printInfoAttributes(o);
	   
	   
   }
   
   public void printInfoAttributes(Object o) {
	   System.out.println(" TO BE DONE");
	   try {
		   logProperties(o);
		   
	   } catch (Exception e){
		   System.out.println(e);
	   }
   }
   
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
   
   public void logProperties(Object o) throws IllegalArgumentException, IllegalAccessException {
	   //Class<?> aClass = this.getClass();
	   Class<?> aClass = o.getClass();
	   Field[] declaredFields = aClass.getDeclaredFields();
	   Map<String, String> logEntries = new HashMap<>();

	   for (Field field : declaredFields) {
	     field.setAccessible(true);

	     Object[] arguments = new Object[]{
	       field.getName(),
	       field.getType().getSimpleName(),
	       String.valueOf(field.get(this))
	     };

	     String template = "- Property: {0} (Type: {1}, Value: {2})";
	     String logMessage = System.getProperty("line.separator")
	             + MessageFormat.format(template, arguments);

	     logEntries.put(field.getName(), logMessage);
	   }

	   SortedSet<String> sortedLog = new TreeSet<>(logEntries.keySet());

	   StringBuilder sb = new StringBuilder("Class properties:");

	   Iterator<String> it = sortedLog.iterator();
	   while (it.hasNext()) {
	     String key = it.next();
	     sb.append(logEntries.get(key));
	   }

	   System.out.println(sb.toString());
	 }
   
	}

