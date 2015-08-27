// EventClass.java
// �̺�Ʈ �߻��� �̺�Ʈ ó�� ���α׷� ����
// �� Ŭ������ �̺�Ʈ �ҽ��� �̺�Ʈ �ڵ鷯 ����
// p.461
/*
�̺�Ʈ �ҽ� - ������Ʈ
�̺�Ʈ Ŭ���� - �̺�Ʈ ��ü
�̺�Ʈ �ڵ鷯 - �̺�Ʈ �ڵ鷯 ��ü
*/
package sist.awt.sample;
import java.awt.*;
import java.awt.event.*;

public class EventClass extends Frame implements ActionListener
{
	//��� ���� ����
	Button but1, but2;
	TextArea txtA;
	
	//������
	public EventClass()
	{
		//Layout manager����
		setLayout(new BorderLayout());
		//������ â �ݱ� �̺�Ʈ�� �ڱ��ڽ��� ��ü�� �ٿ�����
        addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

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
	}

	public static void main(String args[])
	{
		EventClass EC = new EventClass();
		EC.setSize(350,350);
		EC.show();
	}

	//�̺�Ʈ �߻��� ���۵Ǵ� �޼ҵ�
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