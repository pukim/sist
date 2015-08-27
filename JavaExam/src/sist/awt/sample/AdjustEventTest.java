// AdjustEventTest.java
// Adjustment event ó�� ���� 
// ��ũ�ѹ� ������Ʈ�� ����� �̰��� ��ġ�� ����ϴ� ���α׷�
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
		//��ũ�ѹ� �Ӽ� -> ����, ��ũ�ѹ���ġ, ũ��, �ּ�, �ִ�
		sb = new Scrollbar(Scrollbar.HORIZONTAL, 10, 2, 0, 102); 
		sb.addAdjustmentListener(this);

		p.setLayout(new GridLayout(2, 1));
		p.add(sb);
		p.add(tf);
		add(p, "Center");
		setSize(400, 100);
		setVisible(true);
	}
	//�̺�Ʈ �߻��� ���۵Ǵ� �޼ҵ�
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		tf.setText("Position : " + sb.getValue());
	}
}