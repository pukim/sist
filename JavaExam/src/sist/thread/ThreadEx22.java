/**
 * 
 */
package sist.thread;

/**
 * @author Administrator
 *
 */
public class ThreadEx22 {
	public static void main(String[] args) {
		Date d = new Date();
		MyThread22 t1 = new MyThread22(d);
		MyThread22 t2 = new MyThread22(d);
		
		t1.start();
		t2.start();
	}
}

class Date {
	int iv = 0;
}

class MyThread22 extends Thread {
	Date d;
	
	MyThread22(Date d) {
		this.d = d;
	}
	
	public void run() {
		int lv = 0;
		
		while(lv < 3) {
			System.out.println(getName() + " Loval var : " + ++lv);
			System.out.println(getName() + " Instance var : " + ++d.iv);
			System.out.println();
		}
	}
}