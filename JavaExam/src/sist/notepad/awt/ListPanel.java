/**
 * 
 */
package sist.notepad.awt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author owner
 *
 */
public class ListPanel extends Panel implements ItemListener {
	private TextField tf = new TextField();
	private int idx;
	
	List lt = new List(8);
	Label l;
	Panel p;
	FontDialog fd;
	
	ListPanel(FontDialog fd, String title) {
	    this.fd = fd;	
		l  = new Label(title);
		p  = new Panel();
		String[] items = {};
		int flag = 0;
		
		if("±Û²Ã".equals(title)) {
			items = getFontNames();
			flag = 1;
			
			p.setSize(80, 100);
		} else {
			int l=7;
			flag = 3;
			//Set<String> set = new TreeSet<String>();
			Set<Integer> set = new TreeSet<Integer>();
            while(l < 72) {
            	if(l < 12) {
            		l++;
            	} else if(l >= 12 && l < 28) {
            		l += 2;
            	} else if(l >= 28 && l < 36) {
            		l = 36;
            	} else if(l >= 36 && l < 48) {
            		l = 48;
            	} else {
            		l = 72;
            	} 
            	System.out.println("size :" + l);
            	//set.add(String.valueOf(l));
            	set.add(l);
            }
            
            Integer[] temp = set.toArray(new Integer[set.size()]);
            items = new String[set.size()];
            items = Arrays.toString(temp).split("[\\[\\]]")[1].split(", "); 

            p.setSize(60, 100);
            //items = set.toArray(new String[set.size()]);
		}
		drawList(items, flag);
	}
	
	ListPanel(FontDialog fd, String title, String[] items) {
		l  = new Label(title);
		p  = new Panel();
		
		this.fd = fd;
		
		p.setSize(40, 100);
		drawList(items, 2);
	}
	
	public void drawList(String[] items, int flag) {
		if(items.length > 0) {
			//lt = new List(items.length);
				
			drawParentPanel();
			makeListItems(items);
			setPanel(flag);
			
		} else {
			System.out.println("list item error");
		}
	}
	
	public void setPanel(int flag) {
		//p.setLayout(new GridLayout(3, 1));
		
		/*
		Toolkit   ftk = l.getToolkit();
		Point     pnt = l.getLocationOnScreen();
		pnt.x = 10; pnt.y = 10;
		l.setLocation(pnt);
		*/
		/*
		int x = 10;
		int y = 10;
	 
		if(flag == 1) {
			
		} else if(flag == 2) {
			x += 50;
		} else {
			x += 50;
		}
		
		p.setSize(35, 85);
		
		l.setLocation(x, 10);
		l.setSize(30, 10);
		p.add(l);
		
		tf.setLocation(x, 25);
		tf.setSize(30, 10);
		p.add(tf);
		
		lt.setLocation(x, 40);
		lt.setSize(30, 60);
		p.add(lt);
		*/
		tf.setText(lt.getItem(0));
		p.setLayout(new BorderLayout());
		p.add(l, "North"); 
		p.add(tf, "Center"); 
		p.add(lt, "South");
		
		add(p);
	}
	
	public void makeListItems(String[] items) {
		/*
		for(Font f : getFonts()) {
			lt.add(f.getName());
		}
		
		for(String s : getFontNames()) {
			System.out.println(s);
		}
		*/
		for(String s : items) {
			System.out.println(s);
			lt.add(s);
		}
		
		lt.addItemListener(this);
	}
	
	public String[] getFonts() {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fonts          = e.getAllFonts(); 
	    String[] fontNames    = new String[fonts.length];
	    int fontCnt = 0;
	    
	    for(Font f : fonts) {
	    	fontNames[fontCnt++] = f.getName();
	    }
	    
	    return fontNames;
	}
	
	public String[] getFontNames() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Locale l = new Locale("ko_KR", "KOR");
	    
	    return ge.getAvailableFontFamilyNames(l);
	}
	
	public void drawParentPanel() {
		setSize(80, 80);
		setLocation(10, 10);
	}
	
	public void itemStateChanged(ItemEvent e) {
	    System.out.println(e.getItem() + ", " + 
	                  lt.getSelectedIndex() + ", " + lt.getSelectedItem());
	    
	    idx = lt.getSelectedIndex();
	    tf.setText( lt.getSelectedItem());
	    fd.fontPreView();
	}
	
	public String getValue() {
		return tf.getText();
	}
	
	public int getIndex() {
		return idx;
	}
	
	public String toString() {
		return lt.getItemCount() + " - " + tf.getText();
	}
}
