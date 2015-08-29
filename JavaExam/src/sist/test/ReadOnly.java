/**
 * 
 */
package sist.test;

import java.util.Calendar;

/**
 * @author Administrator
 *
 */
class Variable
{
    public final int length;

    public Variable(int len)
    {
    	length = len;
    }
}

public class ReadOnly {
	public static void main(String[] args) {
		
		Variable v = new Variable(7);

		System.out.println(v.length);
		//v.length = 8;
	}
}
