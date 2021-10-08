import java.util.StringTokenizer;


public class StringToken {
	
	public static void main(String[] args)
	{
		System.out.println(function("Simera kanoume Java \n sto amfA"));
	}
	
	
	
	public static String function(String my_string)
	{
			int index, num_tokens;
			boolean first_flag = true;
			StringBuffer buf;
			StringTokenizer tokens = new StringTokenizer(my_string);
			buf = new StringBuffer(50);
			num_tokens =  tokens.countTokens();
	      
			for (index = 0; index < num_tokens; index++)
			{
				if (first_flag) first_flag = false;
	            	else buf.append(" | ");
	        
				buf.append(tokens.nextToken());
			}
	      
			return buf.toString();
	   } 
}
