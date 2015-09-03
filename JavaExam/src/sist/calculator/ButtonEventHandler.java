/**
 * 
 */
package sist.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner
 *
 */
class ButtonEventHandler implements ActionListener {
	//String clickedButton;
	static DisplayArea da;
	
	ButtonEventHandler(DisplayArea da) {
		this.da = da;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.out.println("button click :" + e.getActionCommand());

		clickedButton(e.getActionCommand());
	}
	
	public void clickedButton(String s) {
		if(isNumeric(s)) {
			da.setLabelValueAdd(s);
		} else {
			computeValue(s);
		}
	}
	
	public double computeValue(String s) {
		return 0.0;
	}
	
	public static boolean isNumeric(String str)	{
	   boolean rtnBln = false;
	   
	   try {
		   if(".".equals(str)) {
			   if(da.getLabelValue().contains(".")) {
				   rtnBln = false;
			   } else {
			   //str.matches("(\\.\\)?");
				   rtnBln = true;
			   }
		   } else {
			   double d = Double.parseDouble(str);
			   rtnBln = true;
		   }
	      
	   } catch(NumberFormatException nfe) {  
	      rtnBln = false;  
	   }
	   return rtnBln;
	}
	
	/*
	public static boolean isNumeric(String str)	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //- ∞ËªÍ¿∫???
	}
	*/
}