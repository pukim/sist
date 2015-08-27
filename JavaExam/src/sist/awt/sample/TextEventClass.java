// TextEventClass.java
// �ؽ�Ʈ �̺�Ʈ ����
// TextField�� Key�� ġ�� TextArea�� �޽��� ������ ��
// p.489
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

public class TextEventClass extends Frame implements TextListener, KeyListener
{
	//��� ���� ����
	TextArea txtA;
	TextField txtF;
	
	//������
	public TextEventClass()
	{
		super("�ؽ�Ʈ ��ȭ �̺�Ʈ");

		WinAdapterClass WAC;
		WAC = new WinAdapterClass();

		setLayout(new BorderLayout());

		//��ü �ν��Ͻ�
		txtF = new TextField();
		txtA = new TextArea();

		//�ؽ�Ʈ �ʵ忡 ������� �߰�
		txtF.addTextListener(this);
		txtF.addKeyListener(this);
		addWindowListener(WAC);
		add(txtF, BorderLayout.NORTH);
		add(txtA, BorderLayout.CENTER);
	}

	//TextListener �������̽� �߻� �޼ҵ� ����
	public void textValueChanged(TextEvent te)
	{
		txtA.setText(txtA.getText() + "���� �ٲ�ϴ�.!" + "\n");
	}

	//KeyListener �������̽� �߻� �޼ҵ� ����
	public void keyTyped(KeyEvent ke)
	{
		txtA.setText(txtA.getText() + ke.getKeyChar() + "�� ġ�̱���!" + "\n");
	}
	public void keyPressed(KeyEvent ke){
	}
	public void keyReleased(KeyEvent ke){
	}

    // main()
	public static void main(String args[])
	{
		TextEventClass TEC = new TextEventClass();
		TEC.setSize(350,350);
		TEC.show();
	}

	//inner Ŭ����
	class WinAdapterClass extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}
}