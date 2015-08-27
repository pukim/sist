// ActionEventTest.java
// Action event ó�� ����
// ��ư�� ActionEvent�� �����Ͽ� �̺�Ʈ �߻��� actionPerformed()
// �޼ҵ带 ȣ���� �� �ؽ�Ʈ �ʵ忡 �޽����� ����ϴ� ���α׷�
// p.471
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

public class ActionEventTest extends Frame implements ActionListener
{
	//��� ���� ����
	Button but1, but2;
	TextField tf;
	
	//������
	public ActionEventTest()
	{
		super("Action Event");
	}
	public static void main(String args[])
	{
		new ActionEventTest().action();
	}
	void action()
	{
		Panel p = new Panel();

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		but1 = new Button("��ư-1");
		but2 = new Button("��ư-2");
		
		//��ư�� ���� ��� �߰�
		but1.addActionListener(this);
		but2.addActionListener(this);

		p.add(but1);
		p.add(but2);

		add(p,"North");

		tf = new TextField();
		add(tf,"South");
		setSize(150,100);
		setVisible(true);
	}
	
    //�̺�Ʈ �߻��� ���۵Ǵ� �޼ҵ�
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == but1)
		{
			tf.setText(" ��ư-1�� ���Ⱦ��");
		}
		else if(ae.getSource() == but2)
		{
		    tf.setText(" ��ư-2�� ���Ⱦ��");
		}
	}
}