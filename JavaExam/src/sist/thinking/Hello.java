/**
 * 
 */
package sist.thinking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author owner
 *
 */
public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello\n");
		
		for(int i=0; i<5; i++) 
		
			System.out.printf("%d", i);
		
		System.out.println("end\n");
		
		List lt = new ArrayList();
		
		lt.add("B");
		lt.add("D");
		lt.add("Z");
		lt.add("A");
		lt.add("C");
		lt.add("1");
		lt.add("°¡");
		
		System.out.println("Before="+lt);
		Collections.sort(lt);
		System.out.println("after="+lt);
		
		
	}
}
