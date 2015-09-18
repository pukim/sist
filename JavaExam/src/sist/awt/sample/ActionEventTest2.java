// ActionEventTest2.java
// Action event 처리 예제
// 텍스트 필드에 문자열 입력 후 엔터 키 치고 텍스트 영역에 출력
// p.473
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

public class ActionEventTest2 implements ActionListener
{
	Frame f = new Frame("Action Event");
	Button button;
	TextField tf;
	TextArea ta;	

	public static void main(String args[])
	{
		new ActionEventTest2().action();
	}
	void action()
	{
		button = new Button("지우기");
		tf = new TextField();
		ta = new TextArea(10, 30);
		
		tf.addActionListener(this);
		button.addActionListener(this);

		f.add("North", tf);
		f.add("Center", ta);
		f.add("South", button);
		f.setSize(200, 200);
		f.setVisible(true);
	}
	//이벤트 발생시 동작되는 메소드
	public void actionPerformed(ActionEvent ae)
	{
		//이벤트 소스 확인
		if(ae.getSource() == button)
		{
			tf.setText("");
			ta.setText("");
		}
		ta.append(tf.getText() + "\n");
	}	
}