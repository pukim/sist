/**
 * 
 */
package sist.calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

/**
 * @author owner
 *
 */
public class DisplayArea {
	private static DisplayArea da = new DisplayArea();
	static Label dsp;
	static int   length;
	
	public DisplayArea() {
		//Label dsp = new Label("0");
		dsp = new Label("0");
		Font  fnt = new Font("Serif", Font.PLAIN, 20);
		
		dsp.setFont(fnt);
		dsp.setBounds(30, 50, 330, 150);
		dsp.setBackground(Color.GRAY);
		dsp.setAlignment(dsp.RIGHT);
	}

	public boolean firstZeroRemove(String s) {
		System.out.println(getLabelValue() + ", " + s);
		if(length == 0) {
			if(".".equals(s)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public String getLabelValue() {
		return dsp.getText();
	}
	
	public void setLabelValue(String s) {
		dsp.setText(s);
		length = getLabelValue().length();
	}
	
	public void setLabelValueAdd(String s) {
		if(firstZeroRemove(s)) {
  		    setLabelValue(dsp.getText()+s);
		} else {
			setLabelValue(s);	
		}
	}

	public String toString() {
		return dsp.getX() + ", " + dsp.getY() + " " + getLabelValue();
	}
	
	public static DisplayArea getInstance() {
		return da;
	}
}
