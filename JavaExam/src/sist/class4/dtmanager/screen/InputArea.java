/**
 * 
 */
package sist.class4.dtmanager.screen;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author owner
 *
 */
public class InputArea extends Panel implements ItemListener {
	
	private TextField t  = new TextField();
	private List     lt  = new List(2);
	private Button    b;
	private int     idx;
	private String  itm;
	
	public InputArea(String title, String btnName) {
		
		Panel  p = makeSubPanel(title);
		
		b = new Button(btnName);
		
		//this.setBackground(Color.white);
	 
		this.setLayout(new BorderLayout());
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));
		//l.setSize(80, 20);
		//t.setSize(200, 20);
		
		
		//b.setSize(30, 20);
		
		this.add(p , "West");
		this.add(t , "Center");
		this.add(b , "East");
		
		setButtonEvent();
		
	}
	
	public Panel makeSubPanel(String title) {
		Label     l = new Label(title);
		Panel     p = new Panel();
		
		lt.add("item");
		lt.add("sale_info");
		lt.addItemListener(this);
		
		p.add(l);
		p.add(lt);
		
		return p;
		
	}
	
	public void itemStateChanged(ItemEvent e) {
	    System.out.println(e.getItem() + ", " + 
	                  lt.getSelectedIndex() + ", " + lt.getSelectedItem());
	    
	    idx = lt.getSelectedIndex();
	    itm = lt.getSelectedItem();
	}
	
	public int getSelectedIndex() {
		return idx;
	}
	
	public String getSelectedItem() {
		return itm;
	}
	
	public void setButtonEvent() {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked b!!");
				
			}
		});
	}
	
	public String getValue() {
		return t.getText();
	}
}
