/**
 * 
 */
package sist.puzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class RandomSet {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
	
		for (int i = 0; i < 100; i++)
			s.add(randomInteger());
		System.out.println(s.size());
		
		for(Integer in : s) 
			System.out.println(in);
	}
	
	/*
	private static Integer randomInteger() {
		return new Integer(new Random().nextInt());
	}
	*/
	
	private static Random rnd = new Random();
	
	private static Integer randomInteger() {
		return new Integer(rnd.nextInt());
	}
}
