/**
 * 
 */
package sist.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
public class GroupBox3 {
	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		
		JPanel box = new JPanel();
		box.setLocation(100, 100);
		box.setSize(250, 80);
 		//box.setLayout(new GridLayout(3,3));
		box.add(new JLabel("ABCDEF"));
		box.setBorder(BorderFactory.createTitledBorder("Font"));
		
		f.setSize(300, 400);
	//	f.setLayout(null);
		p.setLayout(new BorderLayout());
		p.setSize(150, 150);
		p.setLocation(50,  50);
			
		p.add(box);
		
		f.add(p);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
