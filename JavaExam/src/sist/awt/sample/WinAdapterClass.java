// WinAdapterClass.java
// 아답터(Adapter) 클래스를 이용한 이벤트 처리 예제
// WindowListener 클래스를 상속하여 별도의 이벤트 핸들러를 정의한 프로그램
// p.470
/*
이벤트 소스 - 컴포넌트
이벤트 클래스 - 이벤트 객체
이벤트 핸들러 - 이벤트 핸들러 객체
아답터(Adapter) 클래스를 이용하지 않고 이벤트 처리하면, 인터페이스에 대한 모든 메소드를
오버라이딩하여 구현해여한다. ex) WindowListener는 7개의 메소드가 있으므로, 모두 구현함.
*/
package sist.awt.sample;
import java.awt.event.*;

class WinAdapterClass extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}