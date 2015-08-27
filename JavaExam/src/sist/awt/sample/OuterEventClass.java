// OuterEventClass.java
// inner Ŭ���� ���¸� ���� �̺�Ʈ ó�� ���α׷� ����
// ���� Ŭ������ ����Ͽ� �̺�Ʈ �ڵ鷯 Ŭ���� ����
// p.463
/*
�̺�Ʈ �ҽ� - ������Ʈ
�̺�Ʈ Ŭ���� - �̺�Ʈ ��ü
�̺�Ʈ �ڵ鷯 - �̺�Ʈ �ڵ鷯 ��ü
*/
package sist.awt.sample;
import java.awt.*;
import java.awt.event.*;

public class OuterEventClass extends Frame
{
	//��� ���� ����
	Button but1, but2;
	TextArea txtA;
	
	//������
	public OuterEventClass()
	{
		InnerEventClass IEC;

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

		//inner Ŭ���� �ν��Ͻ�
		IEC = new InnerEventClass();
		
		//��ư�� ���� ��� �߰�
		but1.addActionListener(IEC);
		but2.addActionListener(IEC);

		//�����ӿ� ��ư �߰�
		add("North", but1);
		add("South", but2);
		add("Center", txtA);
	}

    class InnerEventClass implements ActionListener
    {
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

	public static void main(String args[])
	{
		OuterEventClass OEC = new OuterEventClass();
		OEC.setSize(350,350);
		OEC.show();
	}
}
