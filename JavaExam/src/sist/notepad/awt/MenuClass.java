/**
 * 
 */
package sist.notepad.awt;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

/**
 * @author Administrator
 *
 */
public class MenuClass {
	static MenuBar mb = new MenuBar();
	
	MenuClass(String[] menus) {
		/*
		Menu mFile = new Menu("파일(F)");
		Menu mEdit = new Menu("편집(E)");
		Menu mForm = new Menu("서식(O)");
		Menu mView = new Menu("보기(V)");
		Menu mHelp = new Menu("도움말(H)");
		
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mForm);
		mb.add(mView);
		mb.add(mHelp);
		*/
		for(String s : menus) {
			Menu m = new Menu(s);
			setSubMenu(m, s);
			mb.add(m);
		}
	}
	
	public void makeSubMenu(Menu m, String[] sa) {
		for(String ms : sa) {
			
			if("-".equals(ms)) {
				m.addSeparator();
			} else {
				MenuItem mi = new MenuItem(ms);
				m.add(mi);
			}
		}
	}
	
	public void setSubMenu(Menu m, String s) {
		String[] sFile = { "새로 만들기(N)\tCtrl+N", "열기(O)...Ctrl+O", "저장(S)", 
				           "다른 이름으로 저장(A)...", "-", "페이지 설정(U)...","인쇄(P)", "-", "끝내기"};
		
		String[] sForm = {"자동 줄 바꿈(W)", "글꼴(F)"};
		String[] sParam= {};
		
		if("파일(F)".equals(s)) {
		   sParam = sFile;	
		} else if("서식(O)".equals(s)){
		   sParam = sForm;
		}
		makeSubMenu(m, sParam);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("menu size = " + mb.getMenuCount() + ", " + mb.toString());
		return sb.toString();
	}
}
