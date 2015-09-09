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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Administrator
 *
 */
public class GroupBoxTest extends JFrame {

	GroupBoxTest() {
		setLocation(200, 200);
 		setSize(new Dimension(500, 500)); 
 		//setResizable(false);
 		
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		
 		JPanel box = new JPanel();
 		JLabel label = new JLabel("ABCDEFG", SwingConstants.CENTER);
 		label.setVerticalAlignment(SwingConstants.CENTER);
 		JList list = new JList();
 		
 	
 		//box.setLayout(new GridLayout(3,5));
		box.add(label);
		box.setBorder(BorderFactory.createTitledBorder("Sample"));
	
	    add(box, BorderLayout.PAGE_START);
	    //setContentPane(box);
	}
	
	public static void main(String[] args) {
		 
			
		new GroupBoxTest().setVisible(true);	 

	}
}
