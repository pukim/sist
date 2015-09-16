/**
 * 
 */
package sist.innclass.example.anonymous;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class TestFrame extends Frame {
	public TestFrame() {
		super("Anonymous class");
		Button b = new Button("Click");
		
		add(b);
		setSize(300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new TestFrame();
	}
}
