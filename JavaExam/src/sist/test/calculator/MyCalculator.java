/*
 * Created on Mar 26, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

/**
 * @author Yunchur Lee
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package sist.test.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

public class MyCalculator extends JApplet implements ActionListener {
	
	private JPanel numpadPanel,northPanel1,northPanel2;
	//each number button on the calculator 
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,
					bAdd,bDiv,bSub,bMul,clear,bPow,bRoot,bEmpty,bAns,bDot;
	private JLabel title;
	private JTextField numField;
	private Stack numStack, calStack;
	private boolean newCal = false;
	
	private String input="";
	
	public void init(){
		//initialize stack
		numStack = new Stack();
		calStack = new Stack();
		// north of the calculator
		title = new JLabel("Calculator");
		numField = new JTextField("0",10);
		numField.setHorizontalAlignment(JTextField.RIGHT);
		northPanel1 = new JPanel();
		northPanel1.add(title);
		northPanel2 = new JPanel();
		northPanel2.setForeground(Color.BLUE);
		northPanel2.add(numField);
		//number button
		numpadPanel = new JPanel();
		numpadPanel.setBackground(Color.ORANGE);
		numpadPanel.setLayout(new GridLayout(4,5));
		bEmpty = new JButton("E");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton ("9");
		bAdd = new JButton("+");
		//The first row 
		numpadPanel.add(bEmpty);
		numpadPanel.add(b7);
		numpadPanel.add(b8);
		numpadPanel.add(b9);
		numpadPanel.add(bAdd);
		
		//the second row
		bPow = new JButton("^");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		bSub = new JButton("-");
		numpadPanel.add(bPow);
		numpadPanel.add(b4);
		numpadPanel.add(b5);
		numpadPanel.add(b6);
		numpadPanel.add(bSub);
		//The Third row of num pad
		bRoot = new JButton("Rt");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		bMul = new JButton("*");
		numpadPanel.add(bRoot);
		numpadPanel.add(b1);
		numpadPanel.add(b2);
		numpadPanel.add(b3);
		numpadPanel.add(bMul);
		
		
		//The Fourth Row of numpad
		clear = new JButton("C");
		b0 = new JButton ("0");
		bDot = new JButton(".");
		bAns = new JButton("=");
		bDiv = new JButton("/");
		numpadPanel.add(clear);
		numpadPanel.add(b0);
		numpadPanel.add(bDot);
		numpadPanel.add(bAns);
		numpadPanel.add(bDiv);


		//Put into the window
		//Dimension d = new Dimension(200,300);
		Container c = this.getContentPane();
		c.setSize(300,130);
		c.setLayout(new BorderLayout());
		c.setBackground(Color.ORANGE);
		//c.add(northPanel1,"North");
		c.add(northPanel2,BorderLayout.NORTH);
		c.add(numpadPanel,BorderLayout.SOUTH);
		setSize(320,150);
		registrationEvent();
		
	}
	private void registrationEvent(){
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);		
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bAdd.addActionListener(this);
		bMul.addActionListener(this);
		bDiv.addActionListener(this);
		bSub.addActionListener(this);
		bDot.addActionListener(this);
		bAns.addActionListener(this);
		clear.addActionListener(this);
		bPow.addActionListener(this);
		bRoot.addActionListener(this);
		bEmpty.addActionListener(this);
		return;	
}
	

	
	
	public void actionPerformed(ActionEvent e){
	  input = e.getActionCommand();
	  Object obj = e.getSource();
	  //String prePreNum = null;
	  String preNum = null;
	  
	//C
	  if(obj == b1||obj ==b2||obj == b3 || obj ==b4 || obj==b5 ||
		obj == b6||obj == b7 || obj == b8 || obj == b9 || obj ==b0 ||obj==bDot)
		{
	  	//if it is zero value then replace with new clcik 
	  	//else add to the previous number
	  		
	  		preNum =  numField.getText();
			String nextNum = nextNumber(input,preNum);
			numField.setText(nextNum);
			newCal = false;
	  	
			//numStack.push(nextNum);
	  }	 
	  else if(obj == bAdd || obj == bDiv || obj == bSub || obj == bMul ||
	  		  obj == bPow || obj == bAns){
	  	  //To calculate binary aritihmatic operation, I need two values
	  	  if(numStack.isEmpty()){ preNum = numField.getText();
	  	  						  numStack.push(preNum);
	  	  						  if(!input.equals("="))
	  	  						  			calStack.push(input);
	  	  						  newCal = true;
	  	  						  }
	  	  // num stack is not empty calStack is not empty
	  	  // need calculate two number in stack with calculation with calStack
	  	  else if (newCal){// there is new digit were entered
	  	  	if( !calStack.isEmpty()){
	  	  	calStack.pop();
	  	  	calStack.push(input);
	  	  	}else { calStack.push(input);}
	  	  		  	
	  	  	
	  	  }
	  	  else{
	  	  	if(!calStack.isEmpty()){
	  	  		String cal = (String)calStack.pop();
	  	  		String num1 = (String)numStack.pop();
	  	  		String num2 = numField.getText();
	  	  		String ans = binaryCalculate(num1,num2,cal);
	  	  		numField.setText(ans);
	  	  		numStack.push(ans);
	  	  	}else {
	  	  	    calStack.push(input);
	  	  	 }
	  	  	if(!input.equals("=")) {
	  	  		calStack.push(input);
	  	  		newCal = true;
	  	  	
	  	  	}else {
	  	  		numStack.clear();
	  	  		calStack.clear();
	  	  		newCal = true;
	  	  	}
		  }
	  }
	  	
	  else if(obj == clear){
	  		numStack.clear();
	  		calStack.clear();
	  		newCal = false;
	  		numField.setText("0"); 
	  	}
	}
	private String binaryCalculate(String num1,String num2,String cal){
		double n1,n2,ans=0;
		char calChar;
		String answer;
		n1 = Double.parseDouble(num1);
		n2 = Double.parseDouble(num2);
		calChar = cal.charAt(0);
		switch (calChar)
			{
				case '+' : ans = n1 + n2;
						   break;
				case '-' : ans = n1 - n2;
							break;
				case '*' : ans = n1* n2 ; break;
				case '/' : if(n2 == 0) numField.setText("Cannot Devided by zero");
						   else ans = n1/n2;break;
				case '^' : ans = Math.pow(n1,n2);break;
				
				default  : break;
			}
		answer = Double.toString(ans);
		return answer;
	}
	private String nextNumber(String currNum, String prevNum){
		double prevValue = Double.parseDouble(prevNum);
		if(prevValue == 0) return currNum;
		else if(!newCal) return prevNum.concat(currNum);
		else {newCal = false;return currNum;}

	}
		
}
	//inner class for button event handling
	//private class ButtonHandler implements ActionListener

	


