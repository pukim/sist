/**
 * 
 */
package sist.awt.exam;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class TextFieldTest {
	public static void main(String[] args) {
		Frame f = new Frame("Login");
		f.setSize(400, 65);
		f.setLayout(new FlowLayout());
		
		Label lid  = new Label("ID :", Label.RIGHT);
		Label lpwd = new Label("Password :", Label.RIGHT);
		
		TextField id  = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');
		
		f.add(lid);  f.add(id); f.add(lpwd); f.add(pwd);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
