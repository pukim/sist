/**
 * 
 */
package sist.puzzle;

class Base {
	public String name = "Base";
	public String getName() { return "Base"; }
}

class Derived extends Base {
	private String name = "Derived";
	public String getName() { return "Derived"; }
}

public class PrivateMatter {
	public static void main(String[] args) {
		//Private method can’t override public,
		//but private field can hide public
		
		//System.out.println(new Derived().name);
		System.out.println(new Derived().getName());
	}
}