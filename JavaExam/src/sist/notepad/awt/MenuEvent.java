/**
 * http://blog.daum.net/_blog/BlogTypeView.do?blogid=0NM01&articleno=55
 */
package sist.notepad.awt;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner
 *
 */
public class MenuEvent implements ActionListener {
	private Frame pf;
	
	MenuEvent(Frame pf) {
		this.pf = pf;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + "," + e.getSource());
		
		if("±Û²Ã(F)".equals(e.getActionCommand())) {
			FontDialog fd = new FontDialog(pf);
			fd.setVisible(true);
		}
	}
}
