package sist.obj.generic;

import java.util.*;

public class UseCollection {
	public static void main(String[] args) {
		List<String> slist = new ArrayList<String>();
		
		slist.add("hello");
		slist.add("generics");
		
		for(Object o : slist) {
			System.out.println("string value = " + o);
		}
		
		List<Integer>ilist = new ArrayList<Integer>();
		ilist.add(1);
		ilist.add(2);
		
		for(Object o : ilist) {
			System.out.println("integer value = " + o);
		}
	}
}
