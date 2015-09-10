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


//수빈 메모장
public class sbMemojang extends JFrame implements ActionListener{
	
	private static sbMemojang jang;
	//4.메뉴바 선언
	private JMenuBar jmb;
	private JMenu file, edit, source, refactor, search; 
	private JMenuItem newItem, openItem, closeItem, //file안에 들어가는거
				saveItem, openfileItem, copyItem, cutItem, pasteItem,
				message, fontMessage;   //edit안에 들어가는거
	
	//DialogEx
	private JMenuItem dialogItem;
	
	//2.변수선언.
	private JScrollPane jsp;
	private JTextArea jta;
	private Font font = new Font("굴림", Font.BOLD, 15);
	//9.아이콘
	private ImageIcon[]icon = new ImageIcon[9]; //ImageIcon(인터페이스)은 Icon이다.
	//11.
	private JFileChooser jfc = new JFileChooser();//JFile 추종자
	
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
				 ps.print(jta.getText()); //한줄만 출력.
				 
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
				  br = new BufferedReader(new FileReader(jfc.getSelectedFile())); //char기반
				  String temp = "";
				  while((temp = br.readLine())!=null){ //한줄읽어온걸 temp에 담는다. 파일의 끝을 만나면 null을 리턴.
					  jta.append(temp+ "\n");
				  }
			} catch (Exception e) {
				// TODO: handle exception
			}
		 }
	}
	
	
	//8.감지자 (implements ActionListener) 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		//////
		
		
		if(e.getSource()==newItem){	//new할때마다 메모장 새로 열림
			new sbMemojang();
		//}if(e.getActionCommand().equals("Open")){
		}if(e.getActionCommand().equals("Color")){
			//this.setBackground(JColorChooser.showDialog(this, "", Color.red));
			jta.setBackground(JColorChooser.showDialog(this, "", Color.red));
			jta.setText("\0"); //setText가 null(\0)이됨.
			
		}if(e.getActionCommand().equals("Close")){ //getActionCommand가 String이니까 switch문 써줘도됨.
			this.dispose(); //해당 애만 close된다ㅏ.
			
		}if(e.getSource().equals("저장하기")){
			save();
			
		}if(e.getSource().equals("불러오기")){
        	open();		
        	
		}if(e.getSource().equals("복사하기")){
			jta.copy();
			
		}if(e.getSource().equals("붙혀넣기")){
			jta.paste();
			
		}if(e.getSource().equals("잘라내기")){
			jta.cut();
		  
		}if(e.getActionCommand().equals("글꼴")){
			   new memoFont(jang);
				  
		}if(e.getActionCommand().equals("도움말정보")){
		    JOptionPane.showMessageDialog(null,"이것은 수빈 메모장입니다.");
		   
	}
}

	
	//3.초기화될때 여기서 초기화
	public void initView(){
		
		//10.
		String istr[] = {"save.png", "open.png", "close.png",
				 			"copy.png",  "cut.png",  "edit.png",
				 				"file.png",  "new.png",  "paste.png"};
		for (int i = 0; i < istr.length; i++) {
			icon[i] = new ImageIcon("e:\\" + istr[i]);
		}
		
		//5.file에 집어넣기.
		jmb=new JMenuBar();
		
		file=new JMenu("파일"); //메뉴의 라벨
		
		file.add(newItem=new JMenuItem("새로만들기",icon[7]));
		newItem.addActionListener(this); //8. 감지자
		file.addSeparator();
		
		file.add(openItem=new JMenuItem("열기",icon[1]));
		openItem.addActionListener(this); //8. 감지자
		file.addSeparator();
		
		file.add(closeItem=new JMenuItem("종료",icon[2]));
		closeItem.addActionListener(this); //8. 감지자

		
		//6.edit에 집어넣기.
		edit = new JMenu("편집"); 
		edit.add(saveItem=new JMenuItem("저장하기",icon[0]));
		saveItem.addActionListener(this); //8. 감지자
		edit.addSeparator(); //경계선
		
		edit.add(openfileItem=new JMenuItem("불러오기",icon[5]));
		openfileItem.addActionListener(this); //8. 감지자
		edit.addSeparator();
		
		edit.add(copyItem=new JMenuItem("복사하기",icon[3]));
		copyItem.addActionListener(this); //8. 감지자
		edit.addSeparator();
		
		edit.add(cutItem=new JMenuItem("잘라내기",icon[4]));
		cutItem.addActionListener(this); //8. 감지자
		edit.addSeparator();
		
		edit.add(pasteItem=new JMenuItem("붙여넣기",icon[8]));
		pasteItem.addActionListener(this); //8. 감지자
		
		source=new JMenu("서식");
		refactor=new JMenu("보기");
		search=new JMenu("도움말");
		
		source.add(fontMessage = new JMenuItem("글꼴"));
		fontMessage.addActionListener(this);
		
		search.add(message = new JMenuItem("도움말정보"));
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
		//프레임에 텍스트아리아를 붙힌게 아니라 JScrollPane안에 텍스트아리아가 포함되어있음.
		jta.setFont(font);
		this.add(jsp);
	}
	
	

	//1.생성자를 만들어서 윈도우가 뜨는지 초기화 작업.
	public sbMemojang(){  //외부 생성자.
		jang = this; //생성자의 this. 인스턴스화
		initView();
		
		setTitle("수빈 메모장");
		this.addWindowListener(new WindowAdapter() {

			
			//13. 저장 하시겠습니까? 
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(jta.getText().length());
				
				int demo = 0;
				
				if (jta.getText().length()>0){
					demo = JOptionPane.showConfirmDialog(sbMemojang.jang, "저장하시겠습니까?");
					System.out.println(demo);
					
					//ok누르면 save
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
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x를 눌렀을때 클로스 됨.
		//바로 히든처리가 된다. 클로징 안만들어줘도 바로 해줌. 종료하는 것은 아님. frame과 차이점
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //얘는 바로 종료 안됨.x눌러도 종료 안됨.
		
		
	}
	
	public static void main(String[] args) {
		new sbMemojang();
	}

}

