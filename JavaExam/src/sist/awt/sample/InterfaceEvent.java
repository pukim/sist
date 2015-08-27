// InterfaceEvent.java
// �������̽�(interface) Ŭ������ �̿��� �̺�Ʈ ó�� ����
// WindowListener�������̽��� �ٸ� �������̽��� �Բ� �����Ͽ� �̺�Ʈ �ڵ鷯�� ������ ���α׷�

// p.466
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

public class InterfaceEvent extends Frame implements ActionListener, WindowListener
{
	//��� ���� ����
	Button but1, but2;
	TextArea txtA;
	
	//������
	public InterfaceEvent()
	{
		//Layout manager����
		setLayout(new BorderLayout());
		
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

		//Frame ��ü�� ���� ��� �߰�
		addWindowListener(this);
	}
	
	public static void main(String args[])
	{
		InterfaceEvent IE = new InterfaceEvent();
		IE.setSize(350,350);
		IE.show();
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

	//Frame �̺�Ʈ �߻��� ���۵Ǵ� �޼ҵ� ����
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowOpened(WindowEvent we){
	}
    public void windowClosed(WindowEvent we){
	}
    public void windowActivated(WindowEvent we){
	}
	public void windowDeactivated(WindowEvent we){
	}
    public void windowIconified(WindowEvent we){
	}
    public void windowDeiconified(WindowEvent we){
	}
}