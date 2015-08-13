package sist.obj.inheritance;

import java.io.BufferedWriter;

public class SayMain extends Object{		
	private Halbe h;
	public SayMain(){		
	}
    public SayMain(Halbe h){		
	}	
    
    public void compareInstance() {
    	Abe   a=new Abe();
		Abe  aa=new Abe();
		
		Halbe h=(Halbe)new Na();
		
		if(a instanceof Na) {
			System.out.println("Na");
		}
		
		if(a instanceof Abe) {
			System.out.println("Abe");
		}
		
		if(a instanceof Halbe) {
			System.out.println("Halbe");
		}		
		
		if(a.equals(new Halbe())) {
			System.out.println("Hable equals");
		}
		
		if(a.equals(new Abe())) {
			System.out.println("Abe equals");
		}
		
		if(a.equals(new Na())) {
			System.out.println("Na equals");
		}
		
		if(a.equals(aa)) {
			System.out.println("a = aa");
		}
		
		if(a == aa) {
			System.out.println("a = aa");
		}
		
		if(h instanceof Na) {
			System.out.println("Na2");
		}
		
		if(h instanceof Abe) {
			System.out.println("Abe2");
		}
		
		if(h instanceof Halbe) {
			System.out.println("Halbe2");
		}
    }
    
    public void compare2() {
    	String s1 = "7";
		String s2 = new String("7"); //"7";
		
		if(s1 == s2) {
			System.out.println("s1 == s2");
		}
		
		if(s1.equals(s1)) {
			System.out.println("s1 equals s2");
		}
    }
    
	public static void main(String[] args){
		SayMain sm = new SayMain();
		sm.compare2();
				
	}

}
