// 프린트자료 버튼 이벤트 예제 프로그램
/*
아답터 클래스를 사용하면 인터페이스에 대한 모든 메소드를 오버라이딩하여 구현하지
않아도 됨. 아답터 클래스 사용 안하면 모든 메소드를 오버라이딩해야 함
*/
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

class ActionEventTest3 extends Frame
{
	Button b1, b2, b3;
	public ActionEventTest3(){
		setLayout(new FlowLayout());

		// 아답터 클래스 사용하는 부분, 자기 자신의 객체에 붙여버림
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		ActionListener wa = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == b1){
					b1.setEnabled(false);
					b2.setEnabled(true);
					b3.setForeground(Color.blue);
				}
				else if(e.getActionCommand().equals("Disable")){
					b1.setEnabled(true);
					b2.setEnabled(false);
					b3.setForeground(Color.black);
				}
			}
		};

		b1 = new Button("Enable");
		b2 = new Button("Disable");
		b2.setEnabled(false);
		b3 = new Button("Tester");

		b1.addActionListener(wa);
		b2.addActionListener(wa);
		add(b1);
		add(b2);
		add(b3);
	}
	public static void main(String args[]){
		ActionEventTest3 f = new ActionEventTest3();
		f.pack(); //setSize(200, 60);
		f.setVisible(true);
	}
}