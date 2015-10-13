/**
 * 
 */
package sist.puzzle;

/**
 * @author Administrator
 *
 */
public class Indecision {
	public static void main(String[] args) {
		System.out.println(waffle());
	}
	
	static boolean waffle() {
		try {
			return true;
		} finally {
			return false;
		}
	}
}
