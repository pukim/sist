package sist.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 *	PORT�� ���� �����ڰ� �����ϱ⸦ ��ٷȴٰ�
 * ������ ������ ������ �޾��ִ�  
 * 	ServerSocket�� ���(TCP/IP)
 * @author owner
 */
public class SimpleSvr {
	public SimpleSvr(){
		try {
			//1. �������ϻ��� (PORT)
			ServerSocket server=
					new ServerSocket( 60000 );
			System.out.println("�������� ����");
			String msg="�� ������ �������� ���� ���� �Ǿ���.....";
		//	Socket someClient=null;
//�����ڿ��� ������ �����͸� ������ ���� ��Ʈ��
			//DataOutputStream dos=null; 
//�������� �����͸� �������� �б� ���� ��Ʈ��
			//DataInputStream dis=null;
			
			while( true ){
				//3. ������ ���� �ޱ� 
				Socket someClient=server.accept();
			System.out.println("������ ����"+
					someClient );
			//4. �����ڿ��� �޼����� ������ ����
			//��Ʈ�� ���
			DataOutputStream dos=new DataOutputStream(
					someClient.getOutputStream());
			//5. �޼����� ��Ʈ���� ���
			dos.writeUTF(msg);
			//6. ��Ʈ���� �޼����� �������� ����
			dos.flush();
			
			//13.Ŭ���̾�Ʈ�� �������� �����͸�
			//�б����ؼ� ��Ʈ�� ����
			DataInputStream dis=new DataInputStream(
					someClient.getInputStream());
			
			//System.out.println("rcv :" + dis.readUTF());
			
			//14. ������ �������� �޼��� �б�
			JOptionPane.showMessageDialog(null,
				someClient.getInetAddress()
				+"�� ������ �޼��� \n["+
						dis.readUTF()+"]");
			
			}//end while
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();//end catch
		}
		
	}//SimpleServer

	public static void main(String[] args) {
		new SimpleSvr();
	}//main

}//class
