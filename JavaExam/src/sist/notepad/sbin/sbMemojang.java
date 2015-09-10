package sist.notepad.sbin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


//���� �޸���
public class sbMemojang extends JFrame implements ActionListener{
	
	private static sbMemojang jang;
	//4.�޴��� ����
	private JMenuBar jmb;
	private JMenu file, edit, source, refactor, search; 
	private JMenuItem newItem, openItem, closeItem, //file�ȿ� ���°�
				saveItem, openfileItem, copyItem, cutItem, pasteItem,
				message, fontMessage;   //edit�ȿ� ���°�
	
	//DialogEx
	private JMenuItem dialogItem;
	
	//2.��������.
	private JScrollPane jsp;
	private JTextArea jta;
	private Font font = new Font("����", Font.BOLD, 15);
	//9.������
	private ImageIcon[]icon = new ImageIcon[9]; //ImageIcon(�������̽�)�� Icon�̴�.
	//11.
	private JFileChooser jfc = new JFileChooser();//JFile ������
	
	private static memoFont mf;
	
	
	public JTextArea getJta() {
		return jta;
	}

	public void setJta(JTextArea jta) {
		this.jta = jta;
	}

	//12.
	public void save(){
		//jfc.showSaveDialog(this);
		 if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
			 PrintStream ps = null;
			 
			 try {
				 ps = new PrintStream(jfc.getSelectedFile().toString());
				 ps.print(jta.getText()); //���ٸ� ���.
				 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 }
	 }
	
	//13.
	public void open(){
		 if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
			  System.out.println(jfc.getSelectedFile());
			  BufferedReader br = null;
			  
			  try {
				  br = new BufferedReader(new FileReader(jfc.getSelectedFile())); //char���
				  String temp = "";
				  while((temp = br.readLine())!=null){ //�����о�°� temp�� ��´�. ������ ���� ������ null�� ����.
					  jta.append(temp+ "\n");
				  }
			} catch (Exception e) {
				// TODO: handle exception
			}
		 }
	}
	
	
	//8.������ (implements ActionListener) 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		//////
		
		
		if(e.getSource()==newItem){	//new�Ҷ����� �޸��� ���� ����
			new sbMemojang();
		//}if(e.getActionCommand().equals("Open")){
		}if(e.getActionCommand().equals("Color")){
			//this.setBackground(JColorChooser.showDialog(this, "", Color.red));
			jta.setBackground(JColorChooser.showDialog(this, "", Color.red));
			jta.setText("\0"); //setText�� null(\0)�̵�.
			
		}if(e.getActionCommand().equals("Close")){ //getActionCommand�� String�̴ϱ� switch�� ���൵��.
			this.dispose(); //�ش� �ָ� close�ȴ٤�.
			
		}if(e.getSource().equals("�����ϱ�")){
			save();
			
		}if(e.getSource().equals("�ҷ�����")){
        	open();		
        	
		}if(e.getSource().equals("�����ϱ�")){
			jta.copy();
			
		}if(e.getSource().equals("�����ֱ�")){
			jta.paste();
			
		}if(e.getSource().equals("�߶󳻱�")){
			jta.cut();
		  
		}if(e.getActionCommand().equals("�۲�")){
			   new memoFont(jang);
				  
		}if(e.getActionCommand().equals("��������")){
		    JOptionPane.showMessageDialog(null,"�̰��� ���� �޸����Դϴ�.");
		   
	}
}

	
	//3.�ʱ�ȭ�ɶ� ���⼭ �ʱ�ȭ
	public void initView(){
		
		//10.
		String istr[] = {"save.png", "open.png", "close.png",
				 			"copy.png",  "cut.png",  "edit.png",
				 				"file.png",  "new.png",  "paste.png"};
		for (int i = 0; i < istr.length; i++) {
			icon[i] = new ImageIcon("e:\\" + istr[i]);
		}
		
		//5.file�� ����ֱ�.
		jmb=new JMenuBar();
		
		file=new JMenu("����"); //�޴��� ��
		
		file.add(newItem=new JMenuItem("���θ����",icon[7]));
		newItem.addActionListener(this); //8. ������
		file.addSeparator();
		
		file.add(openItem=new JMenuItem("����",icon[1]));
		openItem.addActionListener(this); //8. ������
		file.addSeparator();
		
		file.add(closeItem=new JMenuItem("����",icon[2]));
		closeItem.addActionListener(this); //8. ������

		
		//6.edit�� ����ֱ�.
		edit = new JMenu("����"); 
		edit.add(saveItem=new JMenuItem("�����ϱ�",icon[0]));
		saveItem.addActionListener(this); //8. ������
		edit.addSeparator(); //��輱
		
		edit.add(openfileItem=new JMenuItem("�ҷ�����",icon[5]));
		openfileItem.addActionListener(this); //8. ������
		edit.addSeparator();
		
		edit.add(copyItem=new JMenuItem("�����ϱ�",icon[3]));
		copyItem.addActionListener(this); //8. ������
		edit.addSeparator();
		
		edit.add(cutItem=new JMenuItem("�߶󳻱�",icon[4]));
		cutItem.addActionListener(this); //8. ������
		edit.addSeparator();
		
		edit.add(pasteItem=new JMenuItem("�ٿ��ֱ�",icon[8]));
		pasteItem.addActionListener(this); //8. ������
		
		source=new JMenu("����");
		refactor=new JMenu("����");
		search=new JMenu("����");
		
		source.add(fontMessage = new JMenuItem("�۲�"));
		fontMessage.addActionListener(this);
		
		search.add(message = new JMenuItem("��������"));
		message.addActionListener(this);
		
		//7.
		jmb.add(file);
		jmb.add(edit);
		jmb.add(source);
		jmb.add(refactor);
		jmb.add(search);
		this.setJMenuBar(jmb);
		
		//3.
		jsp=new JScrollPane(jta=new JTextArea(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//�����ӿ� �ؽ�Ʈ�Ƹ��Ƹ� ������ �ƴ϶� JScrollPane�ȿ� �ؽ�Ʈ�Ƹ��ư� ���ԵǾ�����.
		jta.setFont(font);
		this.add(jsp);
	}
	
	

	//1.�����ڸ� ���� �����찡 �ߴ��� �ʱ�ȭ �۾�.
	public sbMemojang(){  //�ܺ� ������.
		jang = this; //�������� this. �ν��Ͻ�ȭ
		initView();
		
		setTitle("���� �޸���");
		this.addWindowListener(new WindowAdapter() {

			
			//13. ���� �Ͻðڽ��ϱ�? 
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(jta.getText().length());
				
				int demo = 0;
				
				if (jta.getText().length()>0){
					demo = JOptionPane.showConfirmDialog(sbMemojang.jang, "�����Ͻðڽ��ϱ�?");
					System.out.println(demo);
					
					//ok������ save
					if(demo==JOptionPane.OK_OPTION){
						save();
					}
				} 
				if(demo!=JOptionPane.CANCEL_OPTION)
					System.exit(0);
				
					}
		});
		
		
		
		this.setBounds(100,100,500,500); //this : JFrame
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x�� �������� Ŭ�ν� ��.
		//�ٷ� ����ó���� �ȴ�. Ŭ��¡ �ȸ�����൵ �ٷ� ����. �����ϴ� ���� �ƴ�. frame�� ������
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //��� �ٷ� ���� �ȵ�.x������ ���� �ȵ�.
		
		
	}
	
	public static void main(String[] args) {
		new sbMemojang();
	}

}

