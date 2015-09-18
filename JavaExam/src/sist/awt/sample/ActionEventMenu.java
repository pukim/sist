// ActionEventMenu.java
// 메뉴에 Action 이벤트 적용 예제 
// 메뉴를 선택하면 해당 메뉴의 메시지를 출력하는 프로그램
// p.474
/*
이벤트 소스 - 컴포넌트
이벤트 클래스 - 이벤트 객체
이벤트 핸들러 - 이벤트 핸들러 객체
아답터(Adapter) 클래스를 이용하지 않고 이벤트 처리하면, 인터페이스에 대한 모든 메소드를
오버라이딩하여 구현해여한다. ex) WindowListener는 7개의 메소드가 있으므로, 모두 구현함.
*/
package sist.awt.sample;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ActionEventMenu extends Applet implements ActionListener
{
	private TextField msgTxt = new TextField("메뉴선택하세요", 30);

	public void init(){
		Frame f = new Frame("메뉴 이벤트 프로그램");
		f.setSize(this.getSize().width, this.getSize().height);
		f.add("Center", msgTxt);

		MenuBar mb = new MenuBar();

		//파일 메뉴 만들기
		Menu fileMenu = new Menu("파일");
		itemAdd("새 파일", fileMenu);
		itemAdd("열기", fileMenu);
		fileMenu.addSeparator();
		itemAdd("닫기", fileMenu);
		itemAdd("저장", fileMenu);
		itemAdd("새 이름으로", fileMenu);
		fileMenu.addSeparator();
		itemAdd("출력", fileMenu);
		fileMenu.addSeparator();
		itemAdd("끝", fileMenu);

		//편집 메뉴 만들기
		Menu editMenu = new Menu("편집");
		itemAdd("취소", editMenu);
		editMenu.addSeparator();
		itemAdd("잘라내기", editMenu);
		itemAdd("복사하기", editMenu);
		itemAdd("붙이기", editMenu);

		//메뉴를 메뉴바에 추가
		mb.add(fileMenu);
		mb.add(editMenu);

		//메뉴바를 Frame에 추가
        f.setMenuBar(mb);
		f.setVisible(true);
	}
	private void itemAdd(String title, Menu m)
	{
		MenuItem mi = new MenuItem(title);
		mi.addActionListener(this);
		m.add(mi);
	}
	public void actionPerformed(ActionEvent e)
	{
		msgTxt.setText(e.getActionCommand() + " 을 선택하셨군요~! ");
	}
}