// MouseEventTest.java
// ���콺 �̺�Ʈ ����
// ���콺�� ������ ��ġ�� Ŭ�� ���θ� �ؽ�Ʈ���¿� �޽����� ��Ÿ���� ���콺 �̺�Ʈ ���α׷�
// p.485
package sist.awt.sample;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest extends MouseAdapter
{
	Frame f = new Frame(" ���콺 �̺�Ʈ ����");
	Canvas c;
	TextArea ta;

	public static void main(String args[])
	{
		new MouseEventTest().action();
	}
	void action()
	{
		c = new Canvas();
		ta = new TextArea(10, 40);

		f.add(ta, "South");
		f.add(c);
		f.setSize(300,300);
		f.setVisible(true);

		c.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent me)
	{
		String s = "mouse clicked :" + me.getX() + "," + me.getY() + "\n";
		ta.append(s);
	}
	public void mousePressed(MouseEvent me)
	{
		String s = "mouse pressed \n";
		ta.append(s);
	}
	public void mouseReleased(MouseEvent me)
	{
		String s = "mouse released \n";
		ta.append(s);
	}
	public void mouseEntered(MouseEvent me)
	{
		String s = "mouse entered \n";
		ta.append(s);
	}
	public void mouseExited(MouseEvent me)
	{
		String s = "mouse exited \n";
		ta.append(s);
	}
}
