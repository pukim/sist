// WinAdapterClass.java
// �ƴ���(Adapter) Ŭ������ �̿��� �̺�Ʈ ó�� ����
// WindowListener Ŭ������ ����Ͽ� ������ �̺�Ʈ �ڵ鷯�� ������ ���α׷�
// p.470
/*
�̺�Ʈ �ҽ� - ������Ʈ
�̺�Ʈ Ŭ���� - �̺�Ʈ ��ü
�̺�Ʈ �ڵ鷯 - �̺�Ʈ �ڵ鷯 ��ü
�ƴ���(Adapter) Ŭ������ �̿����� �ʰ� �̺�Ʈ ó���ϸ�, �������̽��� ���� ��� �޼ҵ带
�������̵��Ͽ� �����ؿ��Ѵ�. ex) WindowListener�� 7���� �޼ҵ尡 �����Ƿ�, ��� ������.
*/
package sist.awt.sample;
import java.awt.event.*;

class WinAdapterClass extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}