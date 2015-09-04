/**
 * 
 */
package sist.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * @author owner
 *
 */
class ButtonEventHandler implements ActionListener {
	//String clickedButton;
	static DisplayArea da;
	Stack st = new Stack();
	
	ButtonEventHandler(DisplayArea da) {
		this.da = da;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.out.println("button click :" + e.getActionCommand());

		clickedButton(e.getActionCommand());
	}
	
	public double computeVal(double v1, double v2, String op) {
		double result=0;
		
		if("+".equals(op)) {
			result = v1 + v2;
		} else if("-".equals(op)) {
			result = v1 - v2;
		} else if("*".equals(op)) {
			result = v1 * v2;
		} else if("/".equals(op)) {
			result = v1 / v2;
		}
		
		return result;
	}
	public void clickedButton(String s) {
		
		if(isNumeric(s)) {
			da.setLabelValueAdd(s);
		} else if("C".equals(s)){
			da.setLabelValue("0");
		} else if("BS".equals(s)) {
			String temp = da.getLabelValue();
			
			if(temp.length() > 1) {
				da.setLabelValue(temp.substring(0, temp.length()-1));
			} else {
				da.setLabelValue("0");
			}
		} else if("=".equals(s)) {
			double v1=0;
		    double v2=0;
            int    cnt = 0;
            
            String op="";
            
            while(!st.empty()) {
            	Object o = st.pop();
            	System.out.println("Stack " + o);
            	
            	if(o instanceof Double) {
            		if(cnt == 0) {
            			v1 = (double)o;
            			cnt++;
            		} else {
            			v2 = (double)0;
            		}
            	} 
            	
            	if(o instanceof String) {
            		op = (String)o;
            	}
            }
			da.setLabelValue(String.valueOf(computeVal(v1, v2, op)));
	    } else {
	    	st.push(da.getLabelValue());
			st.push(s);
			da.setLabelValueAdd(s);
		}
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