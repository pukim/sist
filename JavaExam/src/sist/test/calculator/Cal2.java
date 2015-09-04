/**
 * 
 */
package sist.test.calculator;

/**
 * @author owner
 *
 */
//Calculator.java

import java.awt.*;
import java.awt.event.*;

public class Cal2 extends Frame implements ActionListener{
	Label dp =new Label("0.");
	boolean newValue =true;
	double v1, v2;
	String op=null;  

	Cal2(String title){
		super(title);
		setLayout(new FlowLayout());
		Panel p=new Panel();
		dp.setAlignment(dp.RIGHT);
		p.setBackground(new Color(250,250,250));
		dp.setBounds(10,10,200,15);
		p.setLayout(null);
		p.setSize(dp.getWidth()+30, 30);
		p.add(dp);
		add(p);
		
		Button bSpace = new Button("Backspace");
		Button CE     = new Button("    CE   ");
		Button C      = new Button("    C    ");
		
		bSpace.addActionListener(this);
		CE.addActionListener(this);
		C.addActionListener(this);
 
		p=new Panel();
		p.add(bSpace); p.add(CE); p.add(C);
		add(p);
		
		String[] str = { "  7  ", "  8  ", "  9  ", "  /  ",
                         "  4  ", "  5  ", "  6  ", "  *  ",
                         "  1  ", "  2  ", "  3  ", "  -  ",
                         "  0  ", " +/- ", "  .  ", "  +  " };
 
		p=new Panel();
		p.setLayout(new GridLayout(4,4));
		
		for(int i=0; i<str.length; i++){
			Button b=new Button(str[i]);
			p.add(b);
			b.addActionListener(this);
		}
		add(p);  
 
		p=new Panel();
		p.setLayout(null);
		Button result=new Button("  =  ");
		result.setSize(40,90); p.setSize(40,90);
		p.add(result); add(p);
		result.addActionListener(this); 
		addWindowListener(new WindowAdapter(){
							public void windowClosing(WindowEvent we){
								System.exit(0);
			}});
	}

	private boolean isNumberic(String val){
		try{
			Double.parseDouble(val);
			return true;
		}catch(NumberFormatException ne){}
		return false;
	}
	
	private double getNum(){
          return Double.parseDouble(dp.getText());
	}
	
	private void setNum(double val){
         dp.setText(String.valueOf(val));
	}
	
	private void setNum(String val){
         dp.setText(val);
	}
	
	private void calculate(){
		if(op==null){
			v1=getNum();
			return;
		}
		
		v2=getNum();
		if(op.equals("+"))
			setNum(v1+v2);
		else if(op.equals("-"))
			setNum(v1-v2);
		else if(op.equals("*"))
			setNum(v1*v2);
		else if(op.equals("/"))
			setNum(v1/v2);
		v1=getNum();  
	}
	
	public void actionPerformed(ActionEvent ae){
		String com = ae.getActionCommand().trim();
		String dis = dp.getText();
		if(isNumberic(com)){
			if(newValue){
				if(com.equals("0") && dis.equals("0."))
					return;
				setNum(com);
				newValue=dis.equals("0");
			}else setNum(dp.getText()+com);
   
		}else if(com.equals(".")){
			if(dis.indexOf(".")<0)
				setNum(dis+com);
			newValue=false; 
 
		}else if(com.equals("+") || com.equals("-") ||
          com.equals("*") || com.equals("/")){
			if(newValue)return;
				newValue=true;
				if(op==null){
					op=com;
					v1=getNum();
				}else{
					calculate();
					op=com;
           }
		}else if(com.equals("+/-")){
			if(dis.equals("0."))return;
			if(dis.startsWith("-"))
				setNum(dis.substring(1));
			else setNum("-"+dis);
		}else if(com.equals("=")){
			calculate();
			op=null;
 
		}else if(com.equals("Backspace")){
			if(dis.equals("0."))return;
				setNum(dis.substring(0,dis.length()-1));
				if(dis.equals("-"))
					setNum("0.");
				else if(dp.getText().length()==0){
					setNum("0.");
					newValue=true;
           }  
		}else if(com.equals("CE")){
			setNum("0.");
			newValue=true;
		}else if(com.equals("C")){
			op=null;
			setNum("0.");
			newValue=true;
		}
	}
	
	public static void main(String[] args) throws Exception{
		Cal2 calc=new Cal2("Calculator");
		calc.setBounds(200, 200, 250, 220);
		calc.setVisible(true);
	}
}




