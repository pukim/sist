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
		Menu mFile = new Menu("����(F)");
		Menu mEdit = new Menu("����(E)");
		Menu mForm = new Menu("����(O)");
		Menu mView = new Menu("����(V)");
		Menu mHelp = new Menu("����(H)");
		
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
		String[] sFile = { "���� �����(N)\tCtrl+N", "����(O)...Ctrl+O", "����(S)", 
				           "�ٸ� �̸����� ����(A)...", "-", "������ ����(U)...","�μ�(P)", "-", "������"};
		
		String[] sForm = {"�ڵ� �� �ٲ�(W)", "�۲�(F)"};
		String[] sParam= {};
		
		if("����(F)".equals(s)) {
		   sParam = sFile;	
		} else if("����(O)".equals(s)){
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
