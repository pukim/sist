/**
 *  http://jsnote.tistory.com/21
 */
package sist.innclass.example;

/**
 * @author owner
 *
 */
public class TestInner {
	int i;
	
	public TestInner() {
		System.out.println("Outer Class Creator");
	}
	
	public void outMethod() {
		System.out.println("Outer class method");
	}
	
	public class Inner {
		int j;
		
		public Inner() {
			System.out.println("Inner Class Creator");
		}
		
		public void inMethod() {
			System.out.println("Inner Class method");
			System.out.println("outer variable(i) at inner class " + i);
		}
		
		public int getVar() {
			return j;
		}
	}
	
	public static void main(String[] args) {
		TestInner ti = new TestInner();
		ti.i = 10;
		
		TestInner.Inner in = ti.new Inner();
		
		in.j = 100;
		in.inMethod();
		
		
	}
}
