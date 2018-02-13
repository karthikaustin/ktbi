package testCases;

import java.util.ArrayList;
import java.util.List;

public class Test12 {

	public static void main(String args[])
	{
		List<String> al = new ArrayList<String>();
		ArrayList<String> al1 = new ArrayList<String>();
		al.add("1");
		al.add("33");
		al.add("11");
		for(int i=0;i<al.size();i++)
		{
			String it =al.get(i);
			al1.add(it);
		}
			System.out.println(al1);
	}
	
}
