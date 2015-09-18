/**
 * 
 */
package sist.test;

import org.ari.archi.utils.ElapsedTime;

/**
 * @author owner
 *
 */
public class StringBuffer {
	public static void main(String[] args) {
		ElapsedTime et = ElapsedTime.getInstance();
		long startTime = System.nanoTime();
		
		et.start();
		
		for(long l=0; l<100000000; l++) {
			//String s = "test" + l;
			StringBuilder sb = new StringBuilder();
			sb.append("test").append(l);
		}
		
		et.stop();
		
		long endTime = System.nanoTime(); 
		System.out.println("run time : " + ((endTime - startTime)/1000000.0)); 
		System.out.println("run time : " + et);
		
		et.unit = "S";
		System.out.println("run time : " + et);
	}
}
