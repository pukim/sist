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
		System.out.println(e.getActionCommand() + ", " + e.getID() + ", " + e.getSource());
	   
		if("글꼴(F)".equals(e.getActionCommand())) {
			FontDialog fd = new FontDialog(pf);
			fd.setVisible(true);
		}
		
		if("인쇄(P)".equals(e.getActionCommand())) {
			PrintDialog pd = new PrintDialog();
		}
		
		if("페이지 설정(U)...".equals(e.getActionCommand())) {
			PageSetupDialog psd = new PageSetupDialog();
		}
		
		if("끝내기".equals(e.getActionCommand())) {
			System.exit(0);
		}
		
	}
}
