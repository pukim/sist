package sist.obj.generic;

import java.util.ArrayList;
import java.util.List;

public class WildcardList {
	public static void main(String[] args) {
		List<String> slist = new ArrayList<String>();
		
		slist.add("hello");
		slist.add("world");
		
		List<Integer> ilist = new ArrayList<Integer>();
		
		ilist.add(1);
		ilist.add(2);
		
		List<?> wclist = slist;
		for(Object o : wclist) {
			System.out.println("value = " + o);
		}
		wclist = ilist;
		for(Object o : wclist) {
			System.out.println("value = " + o);
		}
	}
}
