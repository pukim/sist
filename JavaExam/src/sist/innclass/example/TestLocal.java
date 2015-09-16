/**
 * 
 */
package sist.innclass.example;

/**
 * @author owner
 *
 */
public class TestLocal {
	int out_i;
	
	public TestLocal() {
		System.out.println("creator of Outer class");
	}
	
	public void method(int param_i, final int param_j) {
		int local_i = 0;
		final int local_j=0;
		
		class Local {
			int i;
			
			public Local() {
				System.out.println("creator of local class");
			}
			
			public void localMethod() {
				System.out.println("instance variable at local class :" + out_i);
				System.out.println("local parameter normal:" + param_i);
				System.out.println("local parameter final:"  + param_j);
				System.out.println("method of local class");
			}
		} // class
		Local local = new Local();
		local.i = 10;
		local.localMethod();
	} // method
	
	public static void main(String[] args) {
		TestLocal tl = new TestLocal();
		tl.method(100,  200);
	}
}
