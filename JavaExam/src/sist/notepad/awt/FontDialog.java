/**
 * 
 */
package sist.notepad.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class FontDialog extends Dialog {
	
	FontDialog(Frame f) {
	    super(f, "폰트", true);	 
		setSize(300, 300);
		
		Point p = f.getLocation();
		setLocation(p.x+50, p.y+50);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				dispose();
			}
		});
		
		makeList();
		makeButton();
	}
	
	public void makeList() {
		Panel selPan = new Panel();
		
		selPan.add(new ListPanel("글꼴", Constants.sFonts));
		
		add(selPan, "North");
		//add(selPan);
	}
	
	public void makeButton() {
		
		Panel btnPan = new Panel();
		
		Button okBtn   = new Button("학인");
		Button canBtn  = new Button("취소");
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked ok!!");
				dispose(); // remove from memory
			}
		});
		
		canBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose(); // remove from memory
			}
		});
		
		btnPan.add(okBtn);
		btnPan.add(canBtn);
		
		add(btnPan, "South");
	}
}
