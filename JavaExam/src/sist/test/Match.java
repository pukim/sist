/**
 * 
 */
package sist.test;

import java.util.regex.Pattern;




public class Match {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("(aa|aab?)+");

		int count = 0;

		for(String s = ""; s.length() < 200 ; s+="a")

			if (p.matcher(s).matches()) 
				count++;

		System.out.println(count);

	}

}