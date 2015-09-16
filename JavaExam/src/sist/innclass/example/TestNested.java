/**
 * 
 */
package sist.innclass.example;

/**
 * @author owner
 *
 */
public class TestNested {
	int i;
	static int j;
	
	public TestNested() {
		System.out.println("creator of Outer class");
	}
	
	public void outMethod() {
		System.out.println("instance method of Outer class");
	}
	
	public static void outStaticMethod() {
		System.out.println("static method of Outer class");
	}
	
	static class Nested {
		static int k;
		
		public Nested() {
			System.out.println("creator of inner class : " + k);
		}
		
		public static void inMethod() {
			System.out.println("static method of inner class : " + k);
			TestNested.j = 10;
			//outMethod();
			TestNested.outStaticMethod();
		}
	} // Nested class
	
	public static void main(String[] args) {
		Nested.k = 10;
		Nested.inMethod();
	}
}
