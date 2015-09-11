/**
 * http://blog.daum.net/_blog/BlogTypeView.do?blogid=0NM01&articleno=55
 */
package sist.class4.dtmanager.screen;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner
 *
 */
public class MenuEvent implements ActionListener {
	 
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + "," + e.getSource());
		
		if("exit".equals(e.getActionCommand())) {
			System.exit(0);
		}
	}
}
