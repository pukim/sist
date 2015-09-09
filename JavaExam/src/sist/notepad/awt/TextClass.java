/**
 * 
 */
package sist.notepad.awt;

import java.awt.TextArea;

/**
 * @author Administrator
 *
 */
public class TextClass extends TextArea{
	private TextClass ta; 
	
	TextClass(int x, int y, int h, int w) {
		
		ta.setSize(w, h);
	}
	
	public TextClass getInstance() {
		return ta;
	}
}
