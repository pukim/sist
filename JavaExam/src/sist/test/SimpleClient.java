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
import java.net.Socket;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SimpleClient extends Frame implements ActionListener {
	private Button connectServer;
	private TextArea talkDisplay;
	private TextField tfTalk, tfNick, tfIp;
	// ��������� ����
	private Socket client;
	// ��ȭ�� �о���� ��Ʈ��
	private DataInputStream dis;
	// ��ȭ�� ���� ��Ʈ��
	private DataOutputStream dos;

	public SimpleClient() {
		super(":::::::::::::::::::::::::::ä��Ŭ���̾�Ʈ:::::::::::::::::::::::::::");
		connectServer = new Button("����");
		talkDisplay = new TextArea();
		talkDisplay.setEditable(false);
		talkDisplay.setBackground(Color.WHITE);
		tfTalk = new TextField();
		tfNick = new TextField(10);
		tfIp = new TextField("211.63.89.", 10);

		Panel southPanel = new Panel();
		southPanel.add(new Label("����IP", Label.CENTER));
		southPanel.add(tfIp);
		southPanel.add(new Label("��ȭ��", Label.CENTER));
		southPanel.add(tfNick);
		southPanel.add(connectServer);
		add("North", southPanel);
		add("Center", talkDisplay);
		add("South", tfTalk);

		tfTalk.addActionListener(this);
		connectServer.addActionListener(this);

		setBounds(100, 100, 450, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				try {
					if (dos != null) {
						dos.close();
					} // end if
					if (dis != null) {
						dis.close();
					} // end if
					if (client != null) {
						client.close();
					} // end if
				} catch (IOException ie) {
					ie.printStackTrace();
				} // end catch
			}// widowClosed
		});
	}// SimpleServer

	private void connectToServer(String ip) throws IOException {
		if (client == null) {
			// �Էµ� ip�� ������ ����õ�
			// ���� 3 way hand shaking
			client = new Socket(ip, 60000);
			// ��Ʈ���� ����
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			talkDisplay.setText("������ ���� �Ǿ����ϴ�.");
			// �������� �������� �޼�����
			// �д� ���� �ϴ� method ȣ��
			readMsg();
		} else {
			JOptionPane.showMessageDialog(this, "������ ���� ���Դϴ�.");
		} // end else
	}// connectToServer

	private void readMsg() throws IOException {
		while (true) {
			talkDisplay.append(dis.readUTF() + "\n");
		} // end while
	}// readMsg

	private void sendMsg(String msg) throws IOException {
		dos.writeUTF( msg );
		dos.flush();
	}// sendMsg

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == connectServer) {
			try {
				String ip=tfIp.getText().trim();
				connectToServer( ip );
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, 
			"��ȭ��밡 ������ ���� �Ͽ����ϴ�.");
			} // end catch
		} // end if

		if (ae.getSource() == tfTalk) {
			try {
				sendMsg("[" + tfNick.getText() + "] " + tfTalk.getText());
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} // end if

	}// actionPerformed

	public static void main(String[] args) {
		new SimpleClient();
	}// main
}// class
