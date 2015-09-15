/**
 * 
 */
package sist.class4.dtmanager.screen;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner
 *
 */
public class ButtonArea extends Panel {
	Button btnInput  = new Button("�Է�");
	Button btnUpdate = new Button("����");
	Button btnDelete = new Button("����");
	Label  msgBox    = new Label("�޽��� ���� ");
	
	public ButtonArea() {
		
		
		Point pnt = getLocation();
		
		System.out.println("btn area : " + pnt.x + ", " + pnt.y );
		
		msgBox.setLocation(pnt.x+5, pnt.y+5);
		
		msgBox.setBackground(Color.WHITE);
		add(msgBox);
		
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		
		add(btnInput);
		add(btnUpdate);
		add(btnDelete);
		
		addButtonEvent();
	}
	
	public void addButtonEvent() {
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked btnInput!!");
				
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked btnUpdate!!");
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked btnDelete!!");
				
			}
		});
	}
}
