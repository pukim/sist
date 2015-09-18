// MyAction.java
// Action event 처리 예제
// 버튼에 ActionEvent를 적용하여 이벤트 발생시 actionPerformed()
// 메소드를 호출한 후 텍스트 필드에 메시지를 출력하는 프로그램
// p.471
/*
이벤트 소스 - 컴포넌트
이벤트 클래스 - 이벤트 객체
이벤트 핸들러 - 이벤트 핸들러 객체
아답터(Adapter) 클래스를 이용하지 않고 이벤트 처리하면, 인터페이스에 대한 모든 메소드를
오버라이딩하여 구현해여한다. ex) WindowListener는 7개의 메소드가 있으므로, 모두 구현함.
*/
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

public class MyAction extends Frame implements ActionListener
{
	//멤버 변수 선언
	Button but1, but2;
	TextField tf;
	
	//생성자
	public MyAction()
	{
		super("MyAction");
	}
	public static void main(String args[])
	{
		new MyAction().action();
	}
	void action()
	{
		Panel p = new Panel();

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		but1 = new Button("버튼-1: 눌러봐요~");
		but2 = new Button("버튼-2: 눌러봐요~");
		
		//버튼에 감지 기능 추가
		but1.addActionListener(this);
		but2.addActionListener(this);

		p.add(but1);
		p.add(but2);

		add(p,"North");

		tf = new TextField();
		add(tf,"South");
		setSize(300,300);
		setVisible(true);
	}
	
    //이벤트 발생시 동작되는 메소드
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == but1)
		{
			tf.setText(tf.getText() + " 버튼-1 ★");
		}
		else if(ae.getSource() == but2)
		{
		    tf.setText(tf.getText() + " 버튼-2 ■");
		}
	}
}