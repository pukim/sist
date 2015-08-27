// ����Ʈ�ڷ� ��ư �̺�Ʈ ���� ���α׷�
/*
�ƴ��� Ŭ������ ����ϸ� �������̽��� ���� ��� �޼ҵ带 �������̵��Ͽ� ��������
�ʾƵ� ��. �ƴ��� Ŭ���� ��� ���ϸ� ��� �޼ҵ带 �������̵��ؾ� ��
*/
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

class ActionEventTest3 extends Frame
{
	Button b1, b2, b3;
	public ActionEventTest3(){
		setLayout(new FlowLayout());

		// �ƴ��� Ŭ���� ����ϴ� �κ�, �ڱ� �ڽ��� ��ü�� �ٿ�����
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		ActionListener wa = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == b1){
					b1.setEnabled(false);
					b2.setEnabled(true);
					b3.setForeground(Color.blue);
				}
				else if(e.getActionCommand().equals("Disable")){
					b1.setEnabled(true);
					b2.setEnabled(false);
					b3.setForeground(Color.black);
				}
			}
		};

		b1 = new Button("Enable");
		b2 = new Button("Disable");
		b2.setEnabled(false);
		b3 = new Button("Tester");

		b1.addActionListener(wa);
		b2.addActionListener(wa);
		add(b1);
		add(b2);
		add(b3);
	}
	public static void main(String args[]){
		ActionEventTest3 f = new ActionEventTest3();
		f.pack(); //setSize(200, 60);
		f.setVisible(true);
	}
}