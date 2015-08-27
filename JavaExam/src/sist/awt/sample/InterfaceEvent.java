// InterfaceEvent.java
// 인터페이스(interface) 클래스를 이용한 이벤트 처리 예제
// WindowListener인터페이스를 다른 인터페이스와 함께 구현하여 이벤트 핸들러를 정의한 프로그램

// p.466
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

public class InterfaceEvent extends Frame implements ActionListener, WindowListener
{
	//멤버 변수 선언
	Button but1, but2;
	TextArea txtA;
	
	//생성자
	public InterfaceEvent()
	{
		//Layout manager설정
		setLayout(new BorderLayout());
		
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

		//Frame 객체에 감지 기능 추가
		addWindowListener(this);
	}
	
	public static void main(String args[])
	{
		InterfaceEvent IE = new InterfaceEvent();
		IE.setSize(350,350);
		IE.show();
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

	//Frame 이벤트 발생시 동작되는 메소드 구현
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	public void windowOpened(WindowEvent we){
	}
    public void windowClosed(WindowEvent we){
	}
    public void windowActivated(WindowEvent we){
	}
	public void windowDeactivated(WindowEvent we){
	}
    public void windowIconified(WindowEvent we){
	}
    public void windowDeiconified(WindowEvent we){
	}
}