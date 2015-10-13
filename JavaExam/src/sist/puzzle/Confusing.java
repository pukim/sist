/**
 * 
 */
package sist.puzzle;

/**
 * @author Administrator
 *
 */
public class Confusing {
	public Confusing(Object o) {
		System.out.println("Object");
	}
	
	public Confusing(double[] dArray) {
		System.out.println("double array");
	}
	
	public static void main(String args[]) {
		new Confusing(null);
		new Confusing((Object)null);
	}
}
