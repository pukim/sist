/**
 * 
 */
package sist.thinking;

import java.util.Random;

/**
 * @author owner
 *
 */
public class ArrSize {
	
	ArrSize() {}
	
	public void setArray(int[] param) {
		Random rn = new Random();
		
		for(int i=0; i<param.length; i++) {
			param[i] = rn.nextInt(25);
		}
	}
	
	public void printArray(int[] param) {
		for(int i : param) {
			System.out.println("[" + i + "]");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		int[]    a  = new int[5];
		int[][] aa  = new int[3][4];
		
		ArrSize as = new ArrSize();
		
		as.setArray(a);
		as.printArray(a);
		
		System.out.println("a :" + a.length + ", " + aa.length + ", " + aa[0].length);
	}
}
