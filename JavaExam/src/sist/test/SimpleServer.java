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

	// ��Ʈ�� ���� ������ ������ �޴� ��
	private ServerSocket server;
	// �����ڼ����� ����Ǿ� ��Ʈ���� �����
	private Socket client;
	// �����ڰ� �����ϴ� �����͸� �޴� ��Ʈ��
	private DataInputStream dis;
	// �����ڿ��� �����͸� �����ϴ� ��Ʈ��
	private DataOutputStream dos;

	public SimpleServer() {
		super(":::::::::::::::::::::::::::ä�ü���:::::::::::::::::::::::::::");
		openServer = new Button("��������");
		talkDisplay = new TextArea();
		talkDisplay.setEditable(false);
		talkDisplay.setBackground(Color.WHITE);
		tfTalk = new TextField();
		tfNick = new TextField(10);

		Panel southPanel = new Panel();
		southPanel.add(new Label("��ȭ��", Label.CENTER));
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
				// ����� �� ȣ��Ǵ� method
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
			// ��Ʈ�� ����
			server = new ServerSocket(60000);
			// �����ڰ� �����⸦ ���
			talkDisplay.setText("�������� ����...\n�����ڸ� ��ٸ��ϴ�.");
			client = server.accept();
			// �޼����� ������ �ޱ� ���ؼ�
			// ��Ʈ�� ����
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			talkDisplay
			.append("��ȭ��밡 ���� �Ͽ����ϴ�. ��ſ� ä�õǼ���");
			
			//�޼��� �б�
			readMsg();
			
		} else {
			JOptionPane.showMessageDialog(this, "������ �̹� ������ �Դϴ�.");
		} // end else
	}// openServer

	/**
	 * ��ȭ��밡 �޼����� ���� ������ ���
	 * �о� ���� �Ѵ�.(���� loop) 
	 * @throws IOException
	 */
	private void readMsg() throws IOException {
		while(true){
			//��ȭ�� �о�鿩 textarea�� ����Ѵ�.
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
				"��ȭ��밡 ä���� �����߽��ϴ�.");
			} // end catch
		} // end if

		if (ae.getSource() == tfTalk) {
			try {
				sendMsg("[" + tfNick.getText() + "] " + tfTalk.getText());
				//��ȭ���� �Է�â�� �ʱ�ȭ
				tfTalk.setText("");
				//���� ��ȭ�Է��� ���ϰ� �ϱ� 
				//���ؼ� Ŀ���� �̵�
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
