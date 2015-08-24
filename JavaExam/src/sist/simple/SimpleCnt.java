package sist.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 *	자신의 PORT를 열고 입력된 IP(서버)로 
 *	찾아가는 일 
 * @author owner
 */
public class SimpleCnt {
	public SimpleCnt(){
		// 접속 시도
		try {
	String ip=JOptionPane.showInputDialog
				("접속할 IP입력(130~161)");
	//2.소켓 생성 : IP에 컴퓨터의 PORT로 
			Socket client=
				new Socket("211.63.89."+ip, 3000);
	System.out.println("서버에 연결 되었습니다.");
	//7. 서버에서 보내오는 데이터를 읽기위한
	// 스트림 연결
	DataInputStream dis=new DataInputStream(
			client.getInputStream());
	//8. 메세지 읽기
	JOptionPane.showMessageDialog(null,
			dis.readUTF());
		
	//9 .서버로 데이터를 보낼 스트림얻기
		 String msg=JOptionPane
		.showInputDialog("서버로 보낼 메세지");
		 
 DataOutputStream dos=
		 new DataOutputStream(
				 client.getOutputStream());
 	//10. 데이터를 스트림 쓰기
 		dos.writeUTF( msg );
 		//charset이 encoding된다.
 		//11. 목적지(소켓)로 분출
 		dos.flush();
 		
 		for(int i=0; i<10000; i++)
 			
 		//12. 스트림 끊기
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
