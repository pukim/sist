/**
 * 
 */
package sist.notepad.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
 * @author Administrator
 *
 */
public class ChooseMsgBox extends Dialog {
	
	private Button saveBtn;
	private Button noSveBtn;
	private Button canclBtn;
	
	ChooseMsgBox(Frame f, String title) {
		super(f, title, true);
		
		init(f);
		drawPanel(f);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				dispose();
			}
		});
	}

	public void init(Frame f) {
		
        Point p = f.getLocation();
		
		p.x = p.x + 100;
		p.y = p.y + 100;		
		
		this.setSize(500, 100);
		this.setLayout(new BorderLayout());
		this.setLocation(p.x, p.y);
		this.setResizable(false);
	}
	
	public void drawPanel(Frame f) {
		Panel msgPan = new Panel();
		Panel btnPan = new Panel();
		
		Label l = new Label("변경 내용을 " + f.getTitle() + "에 저장 하시겠습니까?");
		
		//Button saveBtn  = new Button("저장");
		//Button noSveBtn = new Button("저장 안 함");
		//Button canclBtn = new Button("취소");
		l.setBackground(Color.WHITE);
		 
		saveBtn  = new Button("저장");
		noSveBtn = new Button("저장 안 함");
		canclBtn = new Button("취소");
		
		msgPan.add(l);
		btnPan.add(saveBtn);
		btnPan.add(noSveBtn);
		btnPan.add(canclBtn);
		
		this.setLayout(new BorderLayout());
		this.add(msgPan, "North");
		this.add(btnPan, "South");
		
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked SAVE!!");
				setVisible(false);
				dispose(); // remove from memory
			}
		});
		
		noSveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose(); // remove from memory
			}
		});
		
		canclBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose(); // remove from memory
			}
		});
		
	}
}
