/**
 * 
 */
package sist.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
public class GroupBoxTest extends JFrame {

	GroupBoxTest() {
		setLocation(200, 200);
 		setSize(new Dimension(500, 500)); 
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		
 		JPanel box = new JPanel();
 		box.setLayout(new GridLayout(3,3));
		box.add(new JLabel("ABCDEF"));
		box.setBorder(BorderFactory.createTitledBorder("Font"));
	
	    add(box, BorderLayout.PAGE_START);
	}
	
	public static void main(String[] args) {
		 
			
		new GroupBoxTest().setVisible(true);	 

	}
}
