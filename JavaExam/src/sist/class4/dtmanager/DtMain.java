/**
 * 
 */
package sist.class4.dtmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import sist.class4.dtmanager.screen.*;

/**
 * @author Administrator
 *
 */
public class DtMain extends Frame {
	public static DtMain mainFrame;
	
	DtMain() {
		// location 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		setLocation((int)(screenSize.width/5), (int)(screenSize.height/5));
		
		setTitle( "DtManager" );
		setSize( 700, 500 );
		setBackground( Color.gray );
		
		mainFrame = this;
		
		// close
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		DtMain mainFrame = new DtMain();
		MenuPanel menus  = new MenuPanel();
		
		menus.addActionListener(new MenuEvent());
		mainFrame.setMenuBar(menus);
		mainFrame.setVisible(true);
	}
}
