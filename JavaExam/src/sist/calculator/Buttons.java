/**
 * 
 */
package sist.calculator;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Administrator
 *
 */
class ButtonEventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.out.println("button click :" + e.getActionCommand());
	}
	
}

public class Buttons extends Button {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5440224320438957649L;
	private Button b;
	private int positionX, positionY;
	private int height, width;
	private String label;
	static int counts;
	
	Buttons(String s) {
		b = new Button(s);
		label = s;
	}
	
	public Button drawButton() {
		b.setSize(width, height);
		b.setLocation(positionX, positionY);
		
		b.addActionListener(new ButtonEventHandler());
		return b;
	}
	
	public Button drawButton(int x, int y, int h, int w) {
		
		positionX = x;
		positionY = y;
		height    = h;
		width     = w;
		
		return drawButton();
	}
	
	public void setPositionX(int x) {
		positionX = x;
	}
	
	public void setPositionY(int y) {
		positionY = y;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public Button getInstance() {
		return b;
	}
	
	public String toString() {
		return "[" + positionX + "], [" + positionY + "] => [" + counts + "]";
	}
	
	public String getVal() {
		return label;
	}
}
