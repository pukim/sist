package sist.obj.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PolymorphicMethod {
	private static boolean toggle = false;
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		
		Collection<?> col = getOne(list, set);
		System.out.println(col);
		
		Object el = getOneElement(list, set);
		System.out.println(el);
	}
	
	static<T> T getOne(T a, T b) {
		toggle = !toggle;
		return toggle ? a: b;
	}
	
	static<T, U> Object getOneElement(List<T> a, Set<U> b) {
		toggle = !toggle;
		return toggle ? a.get(0) : b.iterator().next();
	}
}
