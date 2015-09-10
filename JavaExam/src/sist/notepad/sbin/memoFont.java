package sist.notepad.sbin;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class memoFont extends JFrame implements ActionListener,ItemListener{
	
	private sbMemojang jang;
	
	private boolean isButton=false; //글꼴확인버튼여부
	
	private String name = "굴림"; //기본글꼴
	private int style = 0; 
	private int size = 12;  //기본 폰트 사이즈
	
	private JTextArea txtArea = null; 
	
	private JFrame frame;
	private JPanel fontPanel1, fontPanel2;    
	private JButton fontOk, fontCancel;  
	private Choice Combo1, Combo2, Combo3;  
	private String[] fontList={"굴림", "궁서", "견고딕"};       
	private String[] fontStyleList={"보통", "기울임", "굵게"};                                   
	private String[] fontSizeList={"8", "9", "10", "11", "12", "13", "14", "15", 
							"16", "17", "18", "19" ,"20", "30", "40", "60", "72"};  
	
	private JMenuItem fontMessage;
	private JTextField txtFont, txtFontStyle, txtFontSize; 
	

	public void init(){
		
	//	frame = new JFrame("글꼴");
		
		fontPanel1 = new JPanel();
		fontPanel2 = new JPanel();
		
		txtFont=new JTextField(10);    //글꼴
		txtFontStyle=new JTextField(8);//글꼴스타일
		txtFontSize=new JTextField(5); //크기
		fontOk=new JButton("확인"); //확인버틍
		fontCancel=new JButton("취소"); //취소버튼
		
		fontMessage = new JMenuItem("글꼴");
		
		Combo1 = new Choice();
		Combo2 = new Choice();
		Combo3 = new Choice();
		
		
		for (int i = 0; i < fontList.length; i++) {
			Combo1.add(fontList[i]);
		}
		for (int i = 0; i < fontStyleList.length; i++) {
			Combo2.add(fontStyleList[i]);
		}
		for (int i = 0; i < fontSizeList.length; i++) {
			Combo3.add(fontSizeList[i]);
		}
		
		Combo1.select(0);
		Combo2.select(0);
		Combo3.select(4);
		
		fontPanel1.setLayout(new GridLayout(3,3)); //GridLayout 설정
		fontPanel1.add(new Label("글꼴 "));
		fontPanel1.add(new Label("스타일 "));
	    fontPanel1.add(new Label("크기"));
		fontPanel1.add(txtFont);
		fontPanel1.add(txtFontStyle);
		fontPanel1.add(txtFontSize);
		fontPanel1.add(Combo1);
		fontPanel1.add(Combo2);
		fontPanel1.add(Combo3);
		
		//panel2에 확인취소
		fontPanel2.setLayout(new GridLayout(3,1)); //GridLayout 설정
		fontPanel2.add(fontOk);
		fontPanel2.add(fontCancel);
		
		//setLayout(new BorderLayout());
		add(fontPanel2, BorderLayout.SOUTH);
		add(fontPanel1, BorderLayout.CENTER);
		  
		//fontPanel1.add(fontOk);
		fontOk.addActionListener(this);
		//fontPanel1.add(fontCancel);
		fontCancel.addActionListener(this);
		
		 Combo1.addItemListener(this);   
		 Combo2.addItemListener(this);  
		 Combo3.addItemListener(this); 
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		 if(e.getSource().equals(Combo1)){      //글꼴 폰트 Choice 선택
		       name=Combo1.getSelectedItem();   //글꼴 적용
		       txtFont.setText(name);           //글꼴 적용
		 }
		 
		 if(e.getSource().equals(Combo2)){ //글꼴 스타일 Choice 선택
		      
	    	  String style1=Combo2.getSelectedItem();
		      if(style1=="보통"){
		        style=0;
		      }else if(style1=="기울임"){
		        style=Font.ITALIC;
		      }else if(style1=="굵게"){
		        style=Font.BOLD;// 스타일 적용
		      }
		      txtFontStyle.setText(style1);        //글꼴 스타일 적용
		 }

		 //if(!Combo3.getSelectedItem().equals("사용자정의")){  //글꼴 크기 Choice 선택
		 if(e.getSource().equals(Combo3)){
		       size=Integer.parseInt(Combo3.getSelectedItem());//글꼴 사이즈 적용  
		       txtFontSize.setText(Combo3.getSelectedItem());      //글꼴 사이즈 적용
		 }
		 
		 if(isButton){
		      txtArea.setFont(new Font(name, style, size)); //txtArea에 폰트 설정 적용
		 }
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(fontMessage)){   //글꼴 기능
		      setVisible(true);
		 }
		      if(e.getSource().equals(fontOk)){  //확인버튼 
		       isButton=true;
		       setVisible(false);
		       txtArea.setFont(new Font(name, style, size));//글자체, 스타일, size 적용
		      }else if(e.getSource().equals(fontCancel)){  //취소버튼
		       isButton=false;
		       setVisible(false);
		      }

		 }

	public memoFont(sbMemojang jang) {
		// TODO Auto-generated constructor stub
		this.setTitle("글꼴");
		//this.frame = jang;
		this.txtArea = jang.getJta();
		
		init();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
			
		});
		
		this.setBounds(300,300,300,200); 
		this.setVisible(true);
		
		}
		
	}

