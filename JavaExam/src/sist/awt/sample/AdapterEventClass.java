// AdapterEventClass.java
// 인터페이스(interface) 클래스를 이용한 이벤트 처리 예제
// WindowListener 클래스를 상속하여 별도의 이벤트 핸들러를 정의한 프로그램
// WinAdapterClass.java 와 함께 사용
// p.469
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

public class AdapterEventClass extends Frame implements ActionListener
{
	//멤버 변수 선언
	Button but1, but2;
	TextArea txtA;
	//윈도우 Adapter 객체 레퍼런스 변수 선언
	WinAdapterClass WAC;
	
	//생성자
	public AdapterEventClass()
	{
		//Layout manager설정
		setLayout(new BorderLayout());

		//객체 인스턴스
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

		//윈도우 Adapter 객체 인스턴스
		WAC = new WinAdapterClass();

		//Frame객체에 감지 기능 추가
		addWindowListener(WAC);
	}
	
	public static void main(String args[])
	{
		AdapterEventClass AEC = new AdapterEventClass();
		AEC.setSize(350,350);
		AEC.show();
	}

	//버튼 이벤트 발생시 동작되는 메소드 구현
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