/**
 * 
 */
package sist.test;

/**
 * @author owner
 *
 */
public class StringBuffer {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
	
		
		for(long l=0; l<100000000; l++) {
			//String s = "test" + l;
			
			StringBuilder sb = new StringBuilder();
			sb.append("test").append(l);
		}
		long endTime = System.nanoTime();
		System.out.println("run time : " + ((endTime - startTime)/1000000.0));
	}
}
