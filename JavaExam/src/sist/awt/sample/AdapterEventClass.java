// AdapterEventClass.java
// �������̽�(interface) Ŭ������ �̿��� �̺�Ʈ ó�� ����
// WindowListener Ŭ������ ����Ͽ� ������ �̺�Ʈ �ڵ鷯�� ������ ���α׷�
// WinAdapterClass.java �� �Բ� ���
// p.469
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

public class AdapterEventClass extends Frame implements ActionListener
{
	//��� ���� ����
	Button but1, but2;
	TextArea txtA;
	//������ Adapter ��ü ���۷��� ���� ����
	WinAdapterClass WAC;
	
	//������
	public AdapterEventClass()
	{
		//Layout manager����
		setLayout(new BorderLayout());

		//��ü �ν��Ͻ�
		but1 = new Button("���� ��ư");
		but2 = new Button("�Ʒ��� ��ư");
		txtA = new TextArea();
		
		//��ư�� ���� ��� �߰�
		but1.addActionListener(this);
		but2.addActionListener(this);

		//�����ӿ� ��ư �߰�
		add("North", but1);
		add("South", but2);
		add("Center", txtA);

		//������ Adapter ��ü �ν��Ͻ�
		WAC = new WinAdapterClass();

		//Frame��ü�� ���� ��� �߰�
		addWindowListener(WAC);
	}
	
	public static void main(String args[])
	{
		AdapterEventClass AEC = new AdapterEventClass();
		AEC.setSize(350,350);
		AEC.show();
	}

	//��ư �̺�Ʈ �߻��� ���۵Ǵ� �޼ҵ� ����
	public void actionPerformed(ActionEvent e)
	{
	    //��ü�� �ҽ��� ���� ��ư ��üȭ ��Ŵ
		Button but = (Button)e.getSource();
		String lab = but.getLabel();

		if(lab.equals("���� ��ư"))
		    txtA.setText(txtA.getText() + " ���� ��ư�� ���Ⱦ��" +"\n");
		else
		    txtA.setText(txtA.getText() + " �Ʒ��� ��ư�� ���Ⱦ��" +"\n");
	}
}