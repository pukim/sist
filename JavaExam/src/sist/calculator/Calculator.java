/**
 * 
 */
package sist.calculator;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

/**
 * @author Administrator
 *
 */



public class Calculator {
	/**
	 * 
	 */
	Frame f;
	Label dsp;
	
	static       int x = 150, y = 200;
	final static int h = 40,  w = 50;
	
	public Calculator() {
		
	}
	
	public Calculator(String s) {
		f = new Frame(s);
		
		f.setSize(400, 450);
		f.setLayout(null);
		f.addWindowListener(new EventHandler());
	}
	
	public void drawFrame() {
		f.setVisible(true);
	}
	
	public void drawDisplayArea() {
		//Label dsp = new Label("0");
		dsp = new Label("0");
		Font  fnt = new Font("Serif", Font.PLAIN, 20);
		
		dsp.setFont(fnt);
		dsp.setBounds(30, 50, 330, 150);
		dsp.setBackground(Color.GRAY);
		dsp.setAlignment(dsp.RIGHT);
		
		f.add(dsp);
	}
	
	public void drawNumberPad() {
		
		//int i = 9;
		
		for(int i=9; i>=0; i--) {
			Buttons b = new Buttons(String.valueOf(i));
			
			b.setHeight(h);
			b.setWidth(w);
		
			if((i%3) == 0) {
			    x  = 150;
			    y += h + 5; 
			} else {
				x -= w + 10;
			}
			
			if(i == 0) {
				b.setPositionX(30); // 150 - ((50*2)+(10*2))
				b.setWidth(110);    // 200 - ((40*2)+(5*2))
				//b.setPositionX(90);
			} else {
				b.setPositionX(x);
			}

			b.setPositionY(y);
			
			System.out.println("[" + i +"], " + b);
			
			f.add(b.drawButton());
		}
	}
	
	public void dotPad() {
		String[] op = { ".", "=", "+", "-", "*", "/", "Del" };
		Buttons b = new Buttons(".");

		x = 150;
		y = 380;
		
		b.setHeight(h);
		b.setWidth(w);
		
		b.setPositionX(x);
		b.setPositionY(y);
		
		f.add(b.drawButton());
	}
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator("Calculator"); 
		
		cal.drawNumberPad();
		cal.dotPad();
        cal.drawDisplayArea();
        
		cal.drawFrame();
		
		
	}
}
