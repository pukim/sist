/**
 * 
 */
package sist.notepad.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
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
	    
		setSize(500, 500);
		
		Point p = f.getLocation();
		
		p.x = p.x + 100;
		p.y = p.y + 100;		
		 
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
		Panel vewPan     = new Panel();
		Label titleLabel = new Label("보기");
		
		//titleLabel.setAlignment(Label.CENTER);
		//titleLabel.setLocation(500, 400);
		
		//label.setBounds(500, 500, 400, 400);
		//label.setLocation(600, 10);
		label.setAlignment(Label.CENTER);
		
		
        vewPan.setLayout(new BorderLayout());
		//vewPan.setLayout(null);
		vewPan.add(titleLabel, "North"); 
		vewPan.add(label     , "Center");
		
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
