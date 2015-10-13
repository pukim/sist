/**
 * 
 */
package sist.puzzle;

import java.util.Arrays;
import java.util.Comparator;

public class SordidSort {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {
		System.out.print("Max Integer : " + Integer.MAX_VALUE);
		System.out.println(", Min Integer : " + Integer.MIN_VALUE);
		Integer big   = new Integer( 2000000000);
		Integer small = new Integer(-2000000000);
		Integer zero  = new Integer(0);
		
		Integer[] arr = new Integer[] {big, small, zero};
		
		Arrays.sort(arr, new Comparator() {
			/*
			public int compare(Object o1, Object o2) {
				return ((Integer)o2).intValue() -
			            	((Integer)o1).intValue();
			}
			*/
			public int compare(Object o1, Object o2) {
				int i1 = ((Integer)o1).intValue();
				int i2 = ((Integer)o2).intValue();
				return (i2 < i1 ? -1 : (i2 == i1 ? 0 : 1));
				}
		});
		System.out.println(Arrays.asList(arr));
	}
}