/**
 * 
 */
package sist.puzzle;

/**
 * @author Administrator
 *
 */
public class Puzzling {

	public static void main(String[] args) {
		MyString s = new MyString("blah");
		System.out.println(s);
	}
}

class MyString {
	java.lang.String s;

	public MyString(java.lang.String s) {
		this.s = s;
	}
	
	public java.lang.String toString() {
		return s;
	}
}
