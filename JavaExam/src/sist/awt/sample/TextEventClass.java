// TextEventClass.java
// 텍스트 이벤트 예제
// TextField에 Key를 치면 TextArea에 메시지 나오게 함
// p.489
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

public class TextEventClass extends Frame implements TextListener, KeyListener
{
	//멤버 변수 선언
	TextArea txtA;
	TextField txtF;
	
	//생성자
	public TextEventClass()
	{
		super("텍스트 변화 이벤트");

		WinAdapterClass WAC;
		WAC = new WinAdapterClass();

		setLayout(new BorderLayout());

		//객체 인스턴스
		txtF = new TextField();
		txtA = new TextArea();

		//텍스트 필드에 감지기능 추가
		txtF.addTextListener(this);
		txtF.addKeyListener(this);
		addWindowListener(WAC);
		add(txtF, BorderLayout.NORTH);
		add(txtA, BorderLayout.CENTER);
	}

	//TextListener 인터페이스 추상 메소드 구현
	public void textValueChanged(TextEvent te)
	{
		txtA.setText(txtA.getText() + "글자 바뀝니다.!" + "\n");
	}

	//KeyListener 인터페이스 추상 메소드 구현
	public void keyTyped(KeyEvent ke)
	{
		txtA.setText(txtA.getText() + ke.getKeyChar() + "를 치셨군요!" + "\n");
	}
	public void keyPressed(KeyEvent ke){
	}
	public void keyReleased(KeyEvent ke){
	}

    // main()
	public static void main(String args[])
	{
		TextEventClass TEC = new TextEventClass();
		TEC.setSize(350,350);
		TEC.show();
	}

	//inner 클래스
	class WinAdapterClass extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}
}