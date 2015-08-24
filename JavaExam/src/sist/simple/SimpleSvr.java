package sist.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 *	PORT를 열고 접속자가 접속하기를 기다렸다가
 * 접속자 소켓이 들어오면 받아주는  
 * 	ServerSocket의 사용(TCP/IP)
 * @author owner
 */
public class SimpleSvr {
	public SimpleSvr(){
		try {
			//1. 서버소켓생성 (PORT)
			ServerSocket server=
					new ServerSocket( 60000 );
			System.out.println("서버가동 성공");
			String msg="이 편지는 영국에서 부터 시작 되었습.....";
		//	Socket someClient=null;
//접속자에게 서버의 데이터를 보내기 위한 스트림
			//DataOutputStream dos=null; 
//접속자의 데이터를 서버에서 읽기 위한 스트림
			//DataInputStream dis=null;
			
			while( true ){
				//3. 접속자 소켓 받기 
				Socket someClient=server.accept();
			System.out.println("접속자 있음"+
					someClient );
			//4. 접속자에게 메세지를 보내기 위한
			//스트림 얻기
			DataOutputStream dos=new DataOutputStream(
					someClient.getOutputStream());
			//5. 메세지를 스트림에 기록
			dos.writeUTF(msg);
			//6. 스트림에 메세지를 소켓으로 분출
			dos.flush();
			
			//13.클라이언트가 보내오는 데이터를
			//읽기위해서 스트림 연결
			DataInputStream dis=new DataInputStream(
					someClient.getInputStream());
			
			//System.out.println("rcv :" + dis.readUTF());
			
			//14. 접속자 보내오는 메세지 읽기
			JOptionPane.showMessageDialog(null,
				someClient.getInetAddress()
				+"가 보내온 메세지 \n["+
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
