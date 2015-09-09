/**
 * 
 */
package sist.notepad.awt;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Administrator
 *
 */
public class NotePad {
	Frame f      = new Frame("제목없음-메모장");
	TextArea ta  = new TextArea();
			
	NotePad() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		f.setLocation(screenSize.width/2-150, (int)(screenSize.height/2)-100);
		f.setSize(screenSize.width/2, screenSize.height/2);
	}
	
	public void setMenuBar(MenuClass menu) {
		System.out.println(menu);
		f.setMenuBar(menu.mb);
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
	
	
	public static void main(String[] args) {
		String[] menus = {"파일(F)", "편집(E)", "서식(O)", "보기(V)", "도움말(H)"};
		
		NotePad    note = new NotePad();
		MenuClass  menu = new MenuClass(menus);
		
		note.setMenuBar(menu);
		note.drawTextArea();
		note.DrawFrame();
	}
}
