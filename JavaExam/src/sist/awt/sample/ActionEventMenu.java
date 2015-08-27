// ActionEventMenu.java
// �޴��� Action �̺�Ʈ ���� ���� 
// �޴��� �����ϸ� �ش� �޴��� �޽����� ����ϴ� ���α׷�
// p.474
/*
�̺�Ʈ �ҽ� - ������Ʈ
�̺�Ʈ Ŭ���� - �̺�Ʈ ��ü
�̺�Ʈ �ڵ鷯 - �̺�Ʈ �ڵ鷯 ��ü
�ƴ���(Adapter) Ŭ������ �̿����� �ʰ� �̺�Ʈ ó���ϸ�, �������̽��� ���� ��� �޼ҵ带
�������̵��Ͽ� �����ؿ��Ѵ�. ex) WindowListener�� 7���� �޼ҵ尡 �����Ƿ�, ��� ������.
*/
package sist.awt.sample;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventMenu extends Applet implements ActionListener
{
	private TextField msgTxt = new TextField("�޴������ϼ���", 30);

	public void init(){
		Frame f = new Frame("�޴� �̺�Ʈ ���α׷�");
		f.setSize(this.getSize().width, this.getSize().height);
		f.add("Center", msgTxt);

		MenuBar mb = new MenuBar();

		//���� �޴� �����
		Menu fileMenu = new Menu("����");
		itemAdd("�� ����", fileMenu);
		itemAdd("����", fileMenu);
		fileMenu.addSeparator();
		itemAdd("�ݱ�", fileMenu);
		itemAdd("����", fileMenu);
		itemAdd("�� �̸�����", fileMenu);
		fileMenu.addSeparator();
		itemAdd("���", fileMenu);
		fileMenu.addSeparator();
		itemAdd("��", fileMenu);

		//���� �޴� �����
		Menu editMenu = new Menu("����");
		itemAdd("���", editMenu);
		editMenu.addSeparator();
		itemAdd("�߶󳻱�", editMenu);
		itemAdd("�����ϱ�", editMenu);
		itemAdd("���̱�", editMenu);

		//�޴��� �޴��ٿ� �߰�
		mb.add(fileMenu);
		mb.add(editMenu);

		//�޴��ٸ� Frame�� �߰�
        f.setMenuBar(mb);
		f.setVisible(true);
	}
	private void itemAdd(String title, Menu m)
	{
		MenuItem mi = new MenuItem(title);
		mi.addActionListener(this);
		m.add(mi);
	}
	public void actionPerformed(ActionEvent e)
	{
		msgTxt.setText(e.getActionCommand() + " �� �����ϼ̱���~! ");
	}
}