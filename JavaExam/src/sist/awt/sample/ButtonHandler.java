// ButtonHandler.java
// ��ư �ڵ鷯 ����
// p.460
package sist.awt.sample;
import java.awt.event.*;

public class ButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		System.out.println(cmd + "���� �ϼ̽��ϴ�.!");
	}
}