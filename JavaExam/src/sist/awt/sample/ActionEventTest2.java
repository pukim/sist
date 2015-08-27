// ActionEventTest2.java
// Action event ó�� ����
// �ؽ�Ʈ �ʵ忡 ���ڿ� �Է� �� ���� Ű ġ�� �ؽ�Ʈ ������ ���
// p.473
/*
�̺�Ʈ �ҽ� - ������Ʈ
�̺�Ʈ Ŭ���� - �̺�Ʈ ��ü
�̺�Ʈ �ڵ鷯 - �̺�Ʈ �ڵ鷯 ��ü
�ƴ���(Adapter) Ŭ������ �̿����� �ʰ� �̺�Ʈ ó���ϸ�, �������̽��� ���� ��� �޼ҵ带
�������̵��Ͽ� �����ؿ��Ѵ�. ex) WindowListener�� 7���� �޼ҵ尡 �����Ƿ�, ��� ������.
*/
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

public class ActionEventTest2 implements ActionListener
{
	Frame f = new Frame("Action Event");
	Button button;
	TextField tf;
	TextArea ta;	

	public static void main(String args[])
	{
		new ActionEventTest2().action();
	}
	void action()
	{
		button = new Button("�����");
		tf = new TextField();
		ta = new TextArea(10, 30);
		
		tf.addActionListener(this);
		button.addActionListener(this);

		f.add("North", tf);
		f.add("Center", ta);
		f.add("South", button);
		f.setSize(200, 200);
		f.setVisible(true);
	}
	//�̺�Ʈ �߻��� ���۵Ǵ� �޼ҵ�
	public void actionPerformed(ActionEvent ae)
	{
		//�̺�Ʈ �ҽ� Ȯ��
		if(ae.getSource() == button)
		{
			tf.setText("");
			ta.setText("");
		}
		ta.append(tf.getText() + "\n");
	}	
}