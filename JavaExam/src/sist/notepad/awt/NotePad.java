/**
 * 
 */
package sist.notepad.awt;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Administrator
 *
 */
public class NotePad  {
	Frame f             = new Frame("제목없음-메모장");
	//static TextArea ta  = new TextArea();
	static TextClass ta = TextClass.getInstance();
			
	NotePad() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		f.setLocation(screenSize.width/2-150, (int)(screenSize.height/2)-100);
		f.setSize(screenSize.width/2, screenSize.height/2);
	}
	
	public void setMenuBar(MenuClass menu) {
		System.out.println(menu);
		
		menu.addActionListener(new MenuEvent(f));
		f.setMenuBar(menu);
		
	}
	
	public void drawTextArea() {
		Toolkit ftk     = f.getToolkit();
		Dimension fSize = ftk.getScreenSize();
		
		ta.setSize(fSize);
		
		f.add(ta);
	}
	
	public void DrawFrame() {
		//f.setLayout(new FlowLayout());
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
	}
	
	public void changeFont(Font font) {
		ta.setFont(font);
	}
	
	public static void main(String[] args) {
		
		NotePad    note = new NotePad();
		MenuClass  menu = new MenuClass();
		
		note.setMenuBar(menu);
		note.drawTextArea();
		note.DrawFrame();
	}
}
