package frontistirio01.strings;


// p.56-57 from F02_Strings_Fall18.pdf
public String function(String my_string)
{
	boolean flag = true;
	boolean first_flag = true;

	int index_start = 0;
	int index_end;

	StringBuffer buf = new StringBuffer(50);

	while (flag)
	{
		if (first_flag)
			first_flag = false;
		else
			buf.append(' ');
		
		while(my_string.substring(index_start,index_start + 1).equals(" "))
			index_start++;
		
		index_end = my_string.indexOf(" ", index_start);

		if (index_end == -1)
		{
			buf.append(my_string.substring(index_start));
			flag = false;
		}
		else
		{
			buf.append(my_string.substring(index_start, index_end));
			index_start = index_end + 1;
		}
	}
	return buf.toString();
}
