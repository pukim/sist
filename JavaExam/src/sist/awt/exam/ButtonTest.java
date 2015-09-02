/**
 * 
 */
package sist.awt.exam;

import java.awt.Button;
import java.awt.Frame;

/**
 * @author owner
 *
 */
public class ButtonTest {
	public static void main(String[] args) {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		f.setLayout(null);   // layout manager off
		
		Button b = new Button("confirm");
		b.setSize(100, 50);
		b.setLocation(100,  75);
		
		f.add(b);
		f.setVisible(true);
	}
}
