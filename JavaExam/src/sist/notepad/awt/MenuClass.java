/**
 * 
 */
package sist.notepad.awt;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;

/**
 * @author Administrator
 *
 */
public class MenuClass extends MenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4441648497846520242L;


	//static MenuBar mb = new MenuBar();
	
	MenuClass() {
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
		for(String s : Constants.menus) {
			Menu m = new Menu(s);
			setSubMenu(m, s);
			add(m);
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
		
		String[] sParam= {};
		
		if("����(F)".equals(s)) {
		   sParam = Constants.sFile;	
		} else if("����(O)".equals(s)){
		   sParam = Constants.sForm;
		}
		makeSubMenu(m, sParam);
	}
	
	
	public void addActionListener(ActionListener alr){

	    for(int i=0;i<getMenuCount();i++) { 
	      for(int j=0;j< getMenu(i).getItemCount();j++) {
	         getMenu(i).getItem(j).addActionListener(alr);
	      }
	    }
    }

	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("menu size = " + getMenuCount());
		return sb.toString();
	}
}
