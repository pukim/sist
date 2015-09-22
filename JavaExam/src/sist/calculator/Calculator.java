/**
 * 
 */
package sist.calculator;

import java.awt.Frame;

/**
 * @author Administrator
 *
 */



public class Calculator {
	/**
	 * 
	 */
	Frame f;
	
	static   int x = 150, y = 200;
	static   int h = 40,  w = 50;
	private DisplayArea  da = DisplayArea.getInstance();
	
	public Calculator() {
		
	}
	
	public Calculator(String s) {
		f = new Frame(s);
		
		f.setSize(350, 450);
		f.setLayout(null);
		f.addWindowListener(new EventHandler());
	}
	
	public void drawFrame() {
		f.setVisible(true);
	}
	
	
	public void drawDisplayArea() {
		f.add(da.dsp);
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
			
			f.add(b.drawButton(da));
		}
	}
	
	public void dotAndOperatorPad() {
		String[] op = { ".", "+", "-", "*", "/", "C", "BS", "=" };
		int oprCnt = op.length;
		
		for(int i=0; i<oprCnt; i++) {
			Buttons b = new Buttons(op[i]); 
		 
			switch(i) {
				case 0 : x = 150; y = 380;     break;
				case 1 : x += w + 10;          break;
				case 2 :
				case 3 : 
				case 4 : y -= h +  5;          break;
				case 5 : x += w + 10;          break;
				case 6 : y += h +  5;          break;
				case 7 : y += h +  5; h += 45; break; 
			}
			
			b.setHeight(h);
			b.setWidth(w);
		
			b.setPositionX(x);
			b.setPositionY(y);
			
			f.add(b.drawButton(da));
		}
	}
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator("Calculator"); 
		
		cal.drawNumberPad();
		cal.dotAndOperatorPad();
		
        cal.drawDisplayArea();
		cal.drawFrame();
	}
}
