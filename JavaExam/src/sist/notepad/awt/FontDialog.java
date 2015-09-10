/**
 * 
 */
package sist.notepad.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
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
    private Frame f;	
	private Label label   = new Label("AaBbYyZz");
	
	private ListPanel pFont  = new ListPanel(this, "글꼴");
	private ListPanel pStyle = new ListPanel(this, "스타일", Constants.sStyle);
	private ListPanel pSize  = new ListPanel(this, "크기");

	FontDialog(Frame f) {
		super(f, "폰트", true);	 
		
		this.f = f;
	    
		setSize(500, 600);
		
		Point p = f.getLocation();
		
		if(p.x > 100) p.x = p.x - 100;
		if(p.y > 100) p.y = p.y - 100;
		
		setLayout(new BorderLayout());
		setLocation(p.x, p.y);
		setResizable(false);
		
		makeList();
		makeButton();
		drawView();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				dispose();
			}
		});
	}
	
	public void makeList() {
		Panel selPan = new Panel();
		
		selPan.setLayout(new BorderLayout());
		
		selPan.add(pFont , "West");
		selPan.add(pStyle, "Center");
		selPan.add(pSize , "East");
		
		
		//setLayout(new GridLayout(3, 3));
		add(selPan, "North");
		//add(selPan);
	}
	
	public void drawView() {
		Panel vewPan = new Panel();
		
		label.setSize(200, 400);
		vewPan.add(label);
		add(vewPan, "Center");
	}
	
	public void makeButton() {
		
		Panel btnPan = new Panel();
		
		Button okBtn   = new Button("확인");
		Button canBtn  = new Button("취소");
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("clicked ok!!");
				TextClass.changeFont(new Font(pFont.getValue(), pStyle.getIndex(), Integer.valueOf(pSize.getValue()))); 
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
		//add(btnPan);
	}
	
	public void fontPreView() {
		label.setFont(new Font(pFont.getValue(), pStyle.getIndex(), Integer.valueOf(pSize.getValue()))); //((Integer)pSize.getValue()).intValue()));
	}
}
