/**
 * 
 */
package sist.awt.exam;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class ScrollPaneTest {
	public static void main(String[] args) {
		Frame f = new Frame("ScrollPane");
		f.setSize(300, 200);
		
		ScrollPane sp = new ScrollPane();
		Panel       p = new Panel();
		p.setBackground(Color.green);
		p.add(new Button("1st"));
		p.add(new Button("2nd"));
		p.add(new Button("3rd"));
		p.add(new Button("4th"));
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
