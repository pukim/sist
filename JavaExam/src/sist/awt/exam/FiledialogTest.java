/**
 * 
 */
package sist.awt.exam;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner
 *
 */
public class FiledialogTest {
	public static void main(String[] args) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		FileDialog fileOpen = new FileDialog(f, "파일열기", FileDialog.LOAD);
		
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) { 
    			System.exit(0);
    		}
		});
		
		fileOpen.setDirectory("c:\\jdk1.5");
		fileOpen.setVisible(true);
		
		System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
	}
}
