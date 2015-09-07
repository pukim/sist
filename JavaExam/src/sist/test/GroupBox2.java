/**
 * 
 */
package sist.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Administrator
 *
 */
public class GroupBox2 {
	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Label l = new Label("Font");
		TextArea t = new TextArea();
		Rectangle r = new Rectangle();
		
		f.setSize(300, 400);
		f.setLayout(null);
		
		
		//l.setBounds(10, 10, 80, 80);
		//l.setBounds(r);
		
		t.setEditable(false);
		t.setText("ABCDEF");
	
		
		
		p.setLayout(new BorderLayout());
		p.setBackground(Color.gray);
		p.setSize(150, 150);
		p.setLocation(50,  50);
		
		p.add(l);
		p.add(t);
		
		f.add(p);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
