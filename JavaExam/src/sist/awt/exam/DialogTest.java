/**
 * 
 */
package sist.awt.exam;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class DialogTest {
	public static void main(String[] args) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		Dialog info = new Dialog(f, "Information", true);
		info.setSize(140, 90);
		info.setLocation(50, 50);
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog", Label.CENTER);
		Button ok = new Button("OK");
		
		info.add(msg);
		info.add(ok);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(false);
				info.dispose(); // remove from memory
			}
		});
		
		f.setVisible(true);
		info.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
	}
}
