// EventClass.java
// 이벤트 발생과 이벤트 처리 프로그램 예제
// 한 클래스로 이벤트 소스와 이벤트 핸들러 구현
// p.461
/*
이벤트 소스 - 컴포넌트
이벤트 클래스 - 이벤트 객체
이벤트 핸들러 - 이벤트 핸들러 객체
*/
package sist.awt.sample;

import java.awt.*;
import java.awt.event.*;

public class EventClass extends Frame implements ActionListener
{
	//멤버 변수 선언
	Button but1, but2;
	TextArea txtA;
	
	//생성자
	public EventClass()
	{
		//Layout manager설정
		setLayout(new BorderLayout());
		//윈도우 창 닫기 이벤트를 자기자신의 객체에 붙여버림
        addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});

		but1 = new Button("왼쪽 버튼");
		but2 = new Button("아래쪽 버튼");
		txtA = new TextArea();

		//버튼에 감지 기능 추가
		but1.addActionListener(this);
		but2.addActionListener(this);

		//프레임에 버튼 추가
		add("North", but1);
		add("South", but2);
		add("Center", txtA);
	}

	public static void main(String args[])
	{
		EventClass EC = new EventClass();
		EC.setSize(350,350);
		EC.show();
	}

	//이벤트 발생시 동작되는 메소드
	public void actionPerformed(ActionEvent e)
	{
		//객체의 소스를 얻어와 버튼 객체화 시킴
		Button but = (Button)e.getSource();
		String lab = but.getLabel();

		if(lab.equals("왼쪽 버튼"))
			txtA.setText(txtA.getText() + " 왼쪽 버튼이 눌렸어요" +"\n");
		else
			txtA.setText(txtA.getText() + " 아래쪽 버튼이 눌렸어요" +"\n");
	}
}