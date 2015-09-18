// MMEventTest.java
// 마우스 모션 이벤트 예제
// 클릭 상태의 마우스가 움직이는 좌표를 출력하는 프로그램
// p.487
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

public class MMEventTest extends MouseMotionAdapter
{
	Frame f = new Frame(" 마우스 모션 이벤트 예제");
	Canvas c;
	TextArea ta;

	public static void main(String args[])
	{
		new MMEventTest().action();
	}
	void action()
	{
		c = new Canvas();
		ta = new TextArea(10,40);

		f.add(ta,"South");
		f.add(c);
		f.setSize(300,300);
		f.setVisible(true);

		c.addMouseMotionListener(this);
	}
	public void mouseDragged(MouseEvent me)
	{
		String s="mouse dragged : x=" + me.getX() + ", y=" + me.getY() + "\n";
		ta.append(s);
	}
	public void mouseMoved(MouseEvent me)
	{
		String s="mouse moved \n";
		ta.append(s);
	}
}