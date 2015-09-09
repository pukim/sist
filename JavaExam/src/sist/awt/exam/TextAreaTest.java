/**
 * 
 */
package sist.awt.exam;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class TextAreaTest {
	public static void main(String[] args) {
		Frame f = new Frame("Comments");
		f.setSize(400, 220);
		f.setLayout(new FlowLayout());
		
		TextArea comments = new TextArea("하고 싶은 말을 적으세요.");
		f.add(comments);
		comments.selectAll();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
