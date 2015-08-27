// AdjustEventTest.java
// Adjustment event 처리 예제 
// 스크롤바 컴포넌트를 만들고 이것의 위치를 출력하는 프로그램
// p.477
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

public class AdjustEventTest extends Frame implements AdjustmentListener
{
	Panel p;
	TextField tf;
	Scrollbar sb;

	public static void main(String args[])
	{
		new AdjustEventTest().action();
	}
	void action()
	{
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		p = new Panel();
		tf = new TextField();
		//스크롤바 속성 -> 방향, 스크롤바위치, 크기, 최소, 최대
		sb = new Scrollbar(Scrollbar.HORIZONTAL, 10, 2, 0, 102); 
		sb.addAdjustmentListener(this);

		p.setLayout(new GridLayout(2, 1));
		p.add(sb);
		p.add(tf);
		add(p, "Center");
		setSize(400, 100);
		setVisible(true);
	}
	//이벤트 발생시 동작되는 메소드
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		tf.setText("Position : " + sb.getValue());
	}
}