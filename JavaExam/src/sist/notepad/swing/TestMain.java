/**
 * 
 */
package sist.notepad.swing;

import java.awt.Dialog;
import java.awt.Font;

import javax.swing.JFrame;

/**
 * @author Administrator
 *
 */
public class TestMain {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Dialog d = new Dialog(f);
		Font   ft = new Font("±¼¸²", Font.PLAIN, 8);
		
		FontChooserDialog fcd = new FontChooserDialog(d, "sample", true, ft);
		
		fcd.setVisible(true);
		//f.add(fcd);
		f.setVisible(true);
		
	}
}
