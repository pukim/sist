package sist.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 *	�ڽ��� PORT�� ���� �Էµ� IP(����)�� 
 *	ã�ư��� �� 
 * @author owner
 */
public class SimpleCnt {
	public SimpleCnt(){
		// ���� �õ�
		try {
	String ip=JOptionPane.showInputDialog
				("������ IP�Է�(130~161)");
	//2.���� ���� : IP�� ��ǻ���� PORT�� 
			Socket client=
				new Socket("211.63.89."+ip, 3000);
	System.out.println("������ ���� �Ǿ����ϴ�.");
	//7. �������� �������� �����͸� �б�����
	// ��Ʈ�� ����
	DataInputStream dis=new DataInputStream(
			client.getInputStream());
	//8. �޼��� �б�
	JOptionPane.showMessageDialog(null,
			dis.readUTF());
		
	//9 .������ �����͸� ���� ��Ʈ�����
		 String msg=JOptionPane
		.showInputDialog("������ ���� �޼���");
		 
 DataOutputStream dos=
		 new DataOutputStream(
				 client.getOutputStream());
 	//10. �����͸� ��Ʈ�� ����
 		dos.writeUTF( msg );
 		//charset�� encoding�ȴ�.
 		//11. ������(����)�� ����
 		dos.flush();
 		
 		for(int i=0; i<10000; i++)
 			
 		//12. ��Ʈ�� ����
 		 dis.close();
 		 dos.close();
		 client.close();
		 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//SimpleClient

	public static void main(String[] args) {
		new SimpleCnt();
	}//main

}//class
