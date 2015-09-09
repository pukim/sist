/**
 * 
 */
package sist.notepad.awt;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author owner
 *
 */
public class ListPanel extends Panel implements ItemListener {
	TextField tf = new TextField();
	List lt;
	
	ListPanel(String title, String[] items) {
		lt       = new List(items.length);
		Label l  = new Label(title);
		Panel p  = new Panel();
		
		drawParentPanel();
		
		for(String s : items) {
			lt.add(s);
		}
		
		lt.addItemListener(this);
		
		//p.setLayout(new GridLayout(3, 1));
		
		/*
		Toolkit   ftk = l.getToolkit();
		Point     pnt = l.getLocationOnScreen();
		pnt.x = 10; pnt.y = 10;
		l.setLocation(pnt);
		*/
		p.setSize(35, 85);
		
		l.setLocation(10, 10);
		l.setSize(30, 10);
		p.add(l);
		
		tf.setLocation(10, 25);
		tf.setSize(30, 10);
		p.add(tf);
		
		lt.setLocation(10, 40);
		lt.setSize(30, 60);
		p.add(lt);
		
		add(p);
	}
	
	public void drawParentPanel() {
		setSize(80, 80);
		setLocation(10, 10);
	}
	
	public void itemStateChanged(ItemEvent e) {

	    System.out.println(e.getItem() + ", " + 
	                  lt.getSelectedIndex() + ", " + lt.getSelectedItem());

	}
}
