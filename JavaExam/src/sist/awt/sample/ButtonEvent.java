// ButtonEvent.java
// 버튼 이벤트 예제
// p.459
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

public class ButtonEvent extends Frame
{
	Button b1, b2, b3;
	
	public ButtonEvent()
	{
		setLayout(new FlowLayout());

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		ButtonHandler BH = new ButtonHandler();

		b1 = new Button("버튼-1");
		b1.addActionListener(BH);
		b2 = new Button("버튼-2");
		b2.addActionListener(BH);
		b3= new Button("버튼-3");
		b3.addActionListener(BH);

		add(b1);
		add(b2);
		add(b3);
	}	
	public static void main(String args[])
	{
		ButtonEvent be = new ButtonEvent();
		be.setSize(200,100);
		be.show();
	}
}