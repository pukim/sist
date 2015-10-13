/**
 * 
 */
package sist.puzzle;

import java.util.HashSet;
import java.util.Set;

public class Name {
	private String first, last;
	public Name(String first, String last) {
		this.first = first;
		this.last  = last;
		
	//	toString();
	}
	
	
	public boolean equals(Object o) {
		
		if (!(o instanceof Name)) return false;
		Name n = (Name)o;
		
		return n.first.equals(first) && n.last.equals(last);
	}
	
	/**
	 * Override hashCode when overriding equals
     * Obey general contracts when overriding
     * 
	public int hashCode() {
		return 31 * first.hashCode() + last.hashCode();
	}
	**/
	
	public String toString() {
		return String.valueOf(System.identityHashCode(this));
	}
	
	public static void main(String[] args) {
		Set s = new HashSet();
		s.add(new Name("Donald", "Duck"));
		System.out.println(
				s.contains(new Name("Donald", "Duck")));
		
		System.out.println(s.size() + ", " + s);
	}
}