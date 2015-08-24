package sist.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SimpleServer extends Frame implements ActionListener {
	private Button openServer;
	private TextArea talkDisplay;
	private TextField tfTalk, tfNick;

	// 포트를 열고 접속자 소켓을 받는 일
	private ServerSocket server;
	// 접속자소켓이 저장되어 스트림을 얻는일
	private Socket client;
	// 접속자가 전송하는 데이터를 받는 스트림
	private DataInputStream dis;
	// 접속자에게 데이터를 전송하는 스트림
	private DataOutputStream dos;

	public SimpleServer() {
		super(":::::::::::::::::::::::::::채팅서버:::::::::::::::::::::::::::");
		openServer = new Button("서버가동");
		talkDisplay = new TextArea();
		talkDisplay.setEditable(false);
		talkDisplay.setBackground(Color.WHITE);
		tfTalk = new TextField();
		tfNick = new TextField(10);

		Panel southPanel = new Panel();
		southPanel.add(new Label("대화명", Label.CENTER));
		southPanel.add(tfNick);
		southPanel.add(openServer);
		add("North", southPanel);
		add("Center", talkDisplay);
		add("South", tfTalk);

		tfTalk.addActionListener(this);
		openServer.addActionListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// 종료될 때 호출되는 method
				try {
					if (dis != null) {
						dis.close();
					} // end if
					if (dos != null) {
						dos.close();
					} // end if
					if (client != null) {
						client.close();
					} // end if
					if (server != null) {
						server.close();
					} // end if
				} catch (IOException ie) {
					ie.printStackTrace();
				} // end catch
			}// windowClosed
		});
	}// SimpleServer

	private void openServer() throws IOException {
		if (server == null) {
			// 포트를 열고
			server = new ServerSocket(60000);
			// 접속자가 들어오기를 대기
			talkDisplay.setText("서버가동 성공...\n접속자를 기다립니다.");
			client = server.accept();
			// 메세지를 보내고 받기 위해서
			// 스트림 연결
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			talkDisplay
			.append("대화상대가 접속 하였습니다. 즐거운 채팅되세요");
			
			//메세지 읽기
			readMsg();
			
		} else {
			JOptionPane.showMessageDialog(this, "서버가 이미 가동중 입니다.");
		} // end else
	}// openServer

	/**
	 * 대화상대가 메세지를 보낼 때마다 계속
	 * 읽어 들어야 한다.(무한 loop) 
	 * @throws IOException
	 */
	private void readMsg() throws IOException {
		while(true){
			//대화를 읽어들여 textarea에 출력한다.
	talkDisplay.append( dis.readUTF()+"\n");
		}//end while
	}// readMsg

	private void sendMsg(String msg) throws IOException {
		dos.writeUTF(msg);
		dos.flush();
	}// sendMsg

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == openServer) {
			try {
				openServer();
			} catch (IOException e) {
				e.printStackTrace();
		JOptionPane.showMessageDialog(this, 
				"대화상대가 채팅을 종료했습니다.");
			} // end catch
		} // end if

		if (ae.getSource() == tfTalk) {
			try {
				sendMsg("[" + tfNick.getText() + "] " + tfTalk.getText());
				//대화내용 입력창을 초기화
				tfTalk.setText("");
				//다음 대화입력을 편하게 하기 
				//위해서 커서를 이동
				tfTalk.requestFocus();
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} // end if

	}// actionPerformed

	public static void main(String[] args) {
		new SimpleServer();
	}// main
}// class
