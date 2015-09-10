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
	
	private boolean isButton=false; //�۲�Ȯ�ι�ư����
	
	private String name = "����"; //�⺻�۲�
	private int style = 0; 
	private int size = 12;  //�⺻ ��Ʈ ������
	
	private JTextArea txtArea = null; 
	
	private JFrame frame;
	private JPanel fontPanel1, fontPanel2;    
	private JButton fontOk, fontCancel;  
	private Choice Combo1, Combo2, Combo3;  
	private String[] fontList={"����", "�ü�", "�߰��"};       
	private String[] fontStyleList={"����", "�����", "����"};                                   
	private String[] fontSizeList={"8", "9", "10", "11", "12", "13", "14", "15", 
							"16", "17", "18", "19" ,"20", "30", "40", "60", "72"};  
	
	private JMenuItem fontMessage;
	private JTextField txtFont, txtFontStyle, txtFontSize; 
	

	public void init(){
		
	//	frame = new JFrame("�۲�");
		
		fontPanel1 = new JPanel();
		fontPanel2 = new JPanel();
		
		txtFont=new JTextField(10);    //�۲�
		txtFontStyle=new JTextField(8);//�۲ý�Ÿ��
		txtFontSize=new JTextField(5); //ũ��
		fontOk=new JButton("Ȯ��"); //Ȯ�ι��v
		fontCancel=new JButton("���"); //��ҹ�ư
		
		fontMessage = new JMenuItem("�۲�");
		
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
		
		fontPanel1.setLayout(new GridLayout(3,3)); //GridLayout ����
		fontPanel1.add(new Label("�۲� "));
		fontPanel1.add(new Label("��Ÿ�� "));
	    fontPanel1.add(new Label("ũ��"));
		fontPanel1.add(txtFont);
		fontPanel1.add(txtFontStyle);
		fontPanel1.add(txtFontSize);
		fontPanel1.add(Combo1);
		fontPanel1.add(Combo2);
		fontPanel1.add(Combo3);
		
		//panel2�� Ȯ�����
		fontPanel2.setLayout(new GridLayout(3,1)); //GridLayout ����
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
		
		 if(e.getSource().equals(Combo1)){      //�۲� ��Ʈ Choice ����
		       name=Combo1.getSelectedItem();   //�۲� ����
		       txtFont.setText(name);           //�۲� ����
		 }
		 
		 if(e.getSource().equals(Combo2)){ //�۲� ��Ÿ�� Choice ����
		      
	    	  String style1=Combo2.getSelectedItem();
		      if(style1=="����"){
		        style=0;
		      }else if(style1=="�����"){
		        style=Font.ITALIC;
		      }else if(style1=="����"){
		        style=Font.BOLD;// ��Ÿ�� ����
		      }
		      txtFontStyle.setText(style1);        //�۲� ��Ÿ�� ����
		 }

		 //if(!Combo3.getSelectedItem().equals("���������")){  //�۲� ũ�� Choice ����
		 if(e.getSource().equals(Combo3)){
		       size=Integer.parseInt(Combo3.getSelectedItem());//�۲� ������ ����  
		       txtFontSize.setText(Combo3.getSelectedItem());      //�۲� ������ ����
		 }
		 
		 if(isButton){
		      txtArea.setFont(new Font(name, style, size)); //txtArea�� ��Ʈ ���� ����
		 }
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(fontMessage)){   //�۲� ���
		      setVisible(true);
		 }
		      if(e.getSource().equals(fontOk)){  //Ȯ�ι�ư 
		       isButton=true;
		       setVisible(false);
		       txtArea.setFont(new Font(name, style, size));//����ü, ��Ÿ��, size ����
		      }else if(e.getSource().equals(fontCancel)){  //��ҹ�ư
		       isButton=false;
		       setVisible(false);
		      }

		 }

	public memoFont(sbMemojang jang) {
		// TODO Auto-generated constructor stub
		this.setTitle("�۲�");
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

