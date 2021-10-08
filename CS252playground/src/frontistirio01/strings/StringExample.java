package frontistirio01.strings;


/**
 *
 * @author genitsar
 */
public class StringExample {

    static int countBetween(String str, char ch)
    {
	int begPos = str.indexOf(ch);
    
	if(begPos < 0)    // not there
		return -1;
	int endPos = str.lastIndexOf(ch);
	return (endPos - begPos -1);
    }


    static String stringConcatExample(String str1, String str2, String str3)
    {
        String str = str1+str2;
        str = str.concat(str3);
	return str;
    }

    public static void main(String[] args) 
    {
        String str = "test";
        System.out.println("string: "+str);
        System.out.println("length: "+str.length());
        System.out.println("index of char e: "+str.indexOf('e'));

        for(int i = 0; i < str.length(); i++)
        {
             System.out.println("char at "+i+": "+str.charAt(i));

        }

        System.out.println("count between first and last index of char t: "+countBetween(str,'t'));
        char firstInitial = "Robert".charAt(0);
        System.out.println("first initial char of string Robert: "+firstInitial);

        String word1 = "Java";
        String word2 = new String(word1);
        String word3 = word1;
        
        if(word1 == word2)
            System.out.println("word1 equal word2");
        else
            System.out.println("word1 not equal word2");

        if(word1 == word3)
            System.out.println("word1 equal word3");
        else
            System.out.println("word1 not equal word3");

        System.out.println("substring from char e: "+str.substring (1));
        System.out.println("substring from char t-s: "+str.substring (0,2));

        System.out.println("concat te-s-t:"+stringConcatExample("te","s","t"));

    }
}
