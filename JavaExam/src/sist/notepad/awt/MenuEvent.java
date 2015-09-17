/**
 * http://blog.daum.net/_blog/BlogTypeView.do?blogid=0NM01&articleno=55
 */
package sist.notepad.awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author owner
 *
 */
public class MenuEvent implements ActionListener {
	private Frame      pf;
	private FileDialog fd;
	private TextClass  textArea = TextClass.getInstance();
	
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
		
		if("새로 만들기(N)	Ctrl+N".equals(e.getActionCommand())) {
			ChooseMsgBox cmb  = new ChooseMsgBox(pf, "메모장");
			cmb.setVisible(true);
			/*
			if(emptyCheck()) {
				newFile();
			} else {
				
			}
			*/
		}
		
		if("열기(O)...Ctrl+O".equals(e.getActionCommand())) {
			fileOpen();
		}
		
	}
	
	public boolean emptyCheck() {
		boolean rtnVal = true;
		
		if(textArea.getText().length() > 0) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	public void newFile() {
		
	}
	
	public void fileOpen() {
		fd = new FileDialog(pf, "파일열기", FileDialog.LOAD);
		
		fd.setVisible(true);
		
		String selDir  = fd.getDirectory();
		String selFile = fd.getFile();
		
		
		if(!"".equals(selDir+selFile)) {
           try {
        	   
               BufferedReader inputStream = new BufferedReader(new FileReader(selDir+selFile));
               String inData;
               
               pf.setTitle(selFile);
               textArea.setText("");
               
               while((inData = inputStream.readLine()) != null) {
                    textArea.append(inData+"\n");
               }
           }
           catch(FileNotFoundException fnf) {
                JOptionPane.showMessageDialog(null, "Sorry,File Not Found", "", JOptionPane.WARNING_MESSAGE );
           }
           catch(IOException ioe) {
               ioe.printStackTrace();
          }
        }
	}
}
