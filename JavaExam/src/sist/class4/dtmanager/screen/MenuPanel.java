/**
 * 
 */
package sist.class4.dtmanager.screen;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;

import sist.class4.dtmanager.env.Constants;

/**
 * @author Administrator
 *
 */
public class MenuPanel extends MenuBar {
	
	public MenuPanel() {
		Menu mFile  = new Menu("file");
		Menu mData  = new Menu("data");

		makeSubMenu(mFile, Constants.fMenus);
		makeSubMenu(mData, Constants.dMenus);
		
		add(mFile);
		add(mData);
	}
	
	public void makeSubMenu(Menu m, String[] s) {
		for(String menuName : s) {
			MenuItem mi = new MenuItem(menuName);
			m.add(mi);
		}
	}
	
	
	public void addActionListener(ActionListener alr){

	    for(int i=0; i < getMenuCount(); i++) { 
	      for(int j=0; j < getMenu(i).getItemCount(); j++) {
	         getMenu(i).getItem(j).addActionListener(alr);
	      }
	    }
    }
}
