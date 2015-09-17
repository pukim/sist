/**
 * 
 */
package sist.notepad.awt;

import java.awt.Font;
import java.awt.TextArea;

/**
 * @author Administrator
 *
 */
public class TextClass extends TextArea{
	private final static TextClass ta = new TextClass(); 

	private TextClass() {
		
	}
	
	public static TextClass getInstance() {
		return ta;
	}
	
	public static void changeFont(Font f) {
		ta.setFont(f);	
	}
	
	
}
