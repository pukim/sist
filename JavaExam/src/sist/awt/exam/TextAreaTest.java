/**
 * 
 */
package sist.awt.exam;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

/**
 * @author owner
 *
 */
public class TextAreaTest {
	public static void main(String[] args) {
		Frame f = new Frame("Comments");
		f.setSize(400, 220);
		f.setLayout(new FlowLayout());
		
		TextArea comments = new TextArea("�ϰ� ���� ���� ��������.");
		f.add(comments);
		comments.selectAll();
		f.setVisible(true);
	}
}
